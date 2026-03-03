package online.Stream.example.HappyMe.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import online.Stream.example.HappyMe.Repository.MusicRepository;
import online.Stream.example.HappyMe.Repository.PlaylistRepository1;
import online.Stream.example.HappyMe.entity.Playlist;

@Repository
public class playlistDao {

    @Autowired
    private PlaylistRepository1 playlistRepository;

	public List<Playlist> search(String playlistName) {
		
		return playlistRepository.findByPlaylistName(playlistName);
	}

	public Optional<Playlist> addMovieToPlaylist(Playlist playlist, Long movieId) {
		
		return playlistRepository.findById(movieId);
	}

	public Optional<Playlist> addMusicToPlaylist(Playlist playlist, Long musicId) {
		
		return playlistRepository.findById(musicId);
	}

	public Playlist registerPlaylist(Playlist playlist) {
		
		return playlistRepository.save(playlist);
	}

}
