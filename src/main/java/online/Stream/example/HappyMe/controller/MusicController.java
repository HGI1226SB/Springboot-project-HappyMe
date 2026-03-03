package online.Stream.example.HappyMe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import online.Stream.example.HappyMe.ResponseEntity.ResponseStructure;
import online.Stream.example.HappyMe.entity.Music;
import online.Stream.example.HappyMe.service.MusicService;

@RestController
@RequestMapping("/song")


public class MusicController {
	
	/*
	 * addnewsong
	 * getallsong
	 * getsongbyname
	 * delete song
	 * filterbygenre
	 * 
	 */
	@Autowired
	private MusicService songservice;
	
	
	@PostMapping("/addNewSong")
	public ResponseEntity<?> addNewSong(@RequestBody Music song)
	{
		ResponseStructure structure = songservice.addNewSong(song);
		return new ResponseEntity<>(structure, HttpStatus.CREATED);

	}
	@GetMapping("/getAllSong")
	public ResponseEntity<?> getAllSong()
	{
		ResponseStructure structure =songservice.addgetAllSong();
		return new ResponseEntity<>(structure,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getSongByName")
	public ResponseEntity<?> getSongByName(@RequestParam String songName)
	{
		ResponseStructure structure=songservice.getSongByName(songName);
		return new ResponseEntity<>(structure,HttpStatus.OK);
		
	}
	@DeleteMapping("/deleteBySongName")
	public ResponseEntity<?> deleteBySongName(@RequestParam String songName)
	{
		
			ResponseStructure structure=songservice.getSongByName(songName);
			return new ResponseEntity<>(structure,HttpStatus.OK);
			
	}
	
	@GetMapping("/filterByGenre")
	public ResponseEntity<?> filterByGenre(@RequestParam String genre) {
		ResponseStructure structure = songservice.filterByGenre(genre);
		return new ResponseEntity<>(structure, HttpStatus.OK);

	}
	
	
	
	

}
