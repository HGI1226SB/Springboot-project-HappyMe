package online.Stream.example.HappyMe.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import online.Stream.example.HappyMe.Dao.MusicDao;
import online.Stream.example.HappyMe.ResponseEntity.ResponseStructure;
import online.Stream.example.HappyMe.entity.Music;

@Service
public class MusicService {
@Autowired
private MusicDao songDao;

	public ResponseStructure addNewSong(Music song) {
		Music song2=songDao.addNewSong(song);
		if(song2!=null)
		{
		ResponseStructure<Music> structure=new ResponseStructure<>();
		structure.setData(null); // Replace with actual media data
	    structure.setTimestamp(LocalDateTime.now());
	    structure.setStatusCode(HttpStatus.OK.value());
	    structure.setMessage("Add the Song successfully");
	    return structure;
		}	
	    else {
		throw new RuntimeException("Failed to add new song");
	    }
	    }

	public ResponseStructure addgetAllSong() {
		List<Music> song2=songDao.addgetAllSong();
		if(song2!=null)
		{
		ResponseStructure<Music> structure=new ResponseStructure<>();
		structure.setData(null); // Replace with actual media data
	    structure.setTimestamp(LocalDateTime.now());
	    structure.setStatusCode(HttpStatus.OK.value());
	    structure.setMessage("Get  the All Song successfully");
	    return structure;
		}	
	    else {
		throw new RuntimeException("Failed the Get the All song");
	    }
			
		}

	public ResponseStructure getSongByName( String songName) {
	
		Music song2=songDao.getSongByName(songName);
		if(song2!=null)
		{
		ResponseStructure<Music> structure=new ResponseStructure<>();
		structure.setData(null); // Replace with actual media data
	    structure.setTimestamp(LocalDateTime.now());
	    structure.setStatusCode(HttpStatus.OK.value());
	    structure.setMessage("Get  the  SongByName successfully");
	    return structure;
		}	
	    else {
		throw new RuntimeException("Failed the Get the songByName");
	    }
	}

	public ResponseStructure filterByGenre(String genre) {
		List<Music> song2=songDao.filterByGenre(genre);
		if(song2!=null)
        {
			ResponseStructure<Music> structure=new ResponseStructure<>();
			structure.setData(null); // Replace with actual media data
			            structure.setTimestamp(LocalDateTime.now());
			            structure.setStatusCode(HttpStatus.OK.value());
			            structure.setMessage("Filter the SongByGenre successfully");
			            return structure;
        }
		else {
			throw new RuntimeException("Failed the Filter the songByGenre");
		}
	}
	

}
