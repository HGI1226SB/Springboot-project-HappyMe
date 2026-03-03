package online.Stream.example.HappyMe.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import online.Stream.example.HappyMe.Repository.MusicRepository;
import online.Stream.example.HappyMe.entity.Music;
@Repository
public class MusicDao {
	
	@Autowired
	private MusicRepository songRepository;
	
	

	public Music addNewSong(Music song) {
		
		return songRepository.save(song);
	}



	public List<Music> addgetAllSong() {
		
		return songRepository.findAll();
	}


	public Music getSongByName( String songName) {
		
		return songRepository.findBySongName(songName);
	}



	public List<Music> filterByGenre(String genre) {
		// TODO Auto-generated method stub
		return songRepository.findByGenre(genre);
	}
	
	
	
	

}
