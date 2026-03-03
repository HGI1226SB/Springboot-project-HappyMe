package online.Stream.example.HappyMe.Dao;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import online.Stream.example.HappyMe.Repository.movieRepository;
import online.Stream.example.HappyMe.ResponseEntity.ResponseStructure;
import online.Stream.example.HappyMe.entity.Movie;
@Repository
public class MovieDao {

	@Autowired
	private movieRepository mediaRepo;
	
	public Movie registerMedia(Movie media) {
		               
		return mediaRepo.save(media);
	}

	
	
	public Movie uploadMedia(Movie media)
	{
		return mediaRepo.save(media);
	}
	
	public List<Movie> getAllMedia() {
		return mediaRepo.findAll();
	}
	
	
	public Movie getMediaById(Long id) {
		return mediaRepo.findById(id).orElse(null);
	}
	
	public List<Movie> getMediaGenre(String genre) {
		return mediaRepo.findByGenre(genre);
	}
}
