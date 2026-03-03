package online.Stream.example.HappyMe.controller;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import online.Stream.example.HappyMe.ResponseEntity.ResponseStructure;
import online.Stream.example.HappyMe.entity.Movie;
import online.Stream.example.HappyMe.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
	@Autowired
	private MovieService mediaService;
	
	@RequestMapping("/register")
	public ResponseEntity<?> registerMedia(@RequestBody Movie media) {
		ResponseStructure<Movie> structure = mediaService.registerMedia(media);
		return new ResponseEntity<>(structure, HttpStatus.CREATED);
	}
	/*
	 * Upload media
	 * get all media
	 * get media By id
	 * stream media
	 * get by genre
	 * Delete
	 */
	@PostMapping("/upload")
	public ResponseEntity<?> uploadMedia(@RequestBody Movie media)
	{
		ResponseStructure<Movie> structure=mediaService.uploadMedia(media);
		return new ResponseEntity<>(structure,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllMedia() {
		ResponseStructure<Movie> structure = mediaService.getAllMedia();
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}
	@GetMapping("/getbyid")
	public ResponseEntity<?> getMediaById(@PathVariable int id) {
		ResponseStructure<Movie> structure = mediaService.getMediaById(id);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}
	@GetMapping("/getbygenre")

	public ResponseEntity<?> getMediaGenre(@RequestParam String genre)
	{
		ResponseStructure<Movie> structure=mediaService.getMediaGenre();
		return new ResponseEntity<>(structure,HttpStatus.OK);
	}

}

