package online.Stream.example.HappyMe.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import online.Stream.example.HappyMe.Dao.MovieDao;
import online.Stream.example.HappyMe.ResponseEntity.ResponseStructure;
import online.Stream.example.HappyMe.entity.Movie;

@Service
public class MovieService {

	@Autowired
	private MovieDao mediadao;
	
	public ResponseStructure<Movie> registerMedia(Movie movie) {
		Movie media2 = mediadao.registerMedia(movie);
		if(media2!=null)
		{
            ResponseStructure<Movie> structure = new ResponseStructure<>();
            structure.setData(null);
            structure.setTimestamp(LocalDateTime.now());
            structure.setStatusCode(HttpStatus.CREATED.value());
            structure.setMessage("Media registered successfully");
            return structure;
        }
        else {
            throw new RuntimeException("Media registration failed");
        }
}
	
public ResponseStructure<Movie> uploadMedia(Movie movie)
{
    Movie media2=mediadao.uploadMedia(movie);
    if(media2!=null)
    {
        ResponseStructure<Movie> structure = new ResponseStructure<>();
        structure.setData(null); // Replace with actual media data);
        structure.setTimestamp(LocalDateTime.now());
        structure.setStatusCode(HttpStatus.ACCEPTED.value());
        structure.setMessage("Media uploaded successfully");
        return structure;
    }
    else {
        throw new RuntimeException("Media upload failed");
    }


}

public ResponseStructure<Movie> getAllMedia()
{
	List<Movie> media2=mediadao.getAllMedia();
	if(media2!=null)
	{
		
	
    // Implementation to retrieve all media
    // This is a placeholder implementation and should be replaced with actual logic
    ResponseStructure<Movie> structure = new ResponseStructure<>();
    structure.setData(null); // Replace with actual media data
    structure.setTimestamp(LocalDateTime.now());
    structure.setStatusCode(HttpStatus.OK.value());
    structure.setMessage("All media retrieved successfully");
    return structure;
	}
	else 
	{
		throw new RuntimeException("Getall Media failed");
		
	}
}

public ResponseStructure<Movie> getMediaById(int id)
{
	// Implementation to retrieve media by ID
	// This is a placeholder implementation and should be replaced with actual logic
	ResponseStructure<Movie> structure = new ResponseStructure<>();
	structure.setData(null); // Replace with actual media data
	structure.setTimestamp(LocalDateTime.now());
	structure.setStatusCode(HttpStatus.OK.value());
	structure.setMessage("Media retrieved successfully");
	return structure;
}

public ResponseStructure<Movie> getMediaGenre() {
	
	ResponseStructure<Movie> structure =new ResponseStructure<>();
	
	structure.setData(null); // Replace with actual media data
	structure.setTimestamp(LocalDateTime.now());
	structure.setStatusCode(HttpStatus.OK.value());
	structure.setMessage("Media genre successfully");
	return structure;
}
}
