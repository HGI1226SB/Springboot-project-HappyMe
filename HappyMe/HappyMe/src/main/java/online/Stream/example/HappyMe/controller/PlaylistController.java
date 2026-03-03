package online.Stream.example.HappyMe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import online.Stream.example.HappyMe.ResponseEntity.ResponseStructure;
import online.Stream.example.HappyMe.entity.Playlist;
import online.Stream.example.HappyMe.service.MusicService;
import online.Stream.example.HappyMe.service.PlaylistService;

@RestController
@RequestMapping("/playlists")
public class PlaylistController 
{
	@Autowired
	PlaylistService playlistservice;
	
	@RequestMapping("/register")
	public ResponseEntity<?> registerplaylist(@RequestBody Playlist playlist) {
		ResponseStructure structure=playlistservice.registerplaylist(playlist);
		return new ResponseEntity<>(structure,HttpStatus.CREATED);
		
	}
	/*
	 * addmusic 
	 * addmovie
	 * addtoplaylist
	 * search
	 * 
	 */
	@PostMapping("/addMusic")
	public ResponseEntity<?> addMusicToPlaylist(@RequestBody Playlist playlist,@RequestParam Long musicId) {
		ResponseStructure structure = playlistservice.addMusicToPlaylist(playlist, musicId);
		return new ResponseEntity<>(structure, HttpStatus.OK);

	}
	@PostMapping("/addMovie")
	public ResponseEntity<?> addMovieToPlaylist(@RequestBody Playlist playlist, @RequestParam Long movieId) {
		ResponseStructure structure = playlistservice.addMovieToPlaylist(playlist, movieId);
		return new ResponseEntity<>(structure, HttpStatus.OK);

	}
	
	@GetMapping("/media/search")
	public ResponseEntity<?> search(@RequestParam String playlistName) {
	ResponseStructure structure = playlistservice.search(playlistName);
	return new ResponseEntity<>(structure, HttpStatus.OK);
	}
	
	
	
	
	
	

}
