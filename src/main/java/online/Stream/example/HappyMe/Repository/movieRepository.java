package online.Stream.example.HappyMe.Repository;

import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.data.jpa.repository.JpaRepository;

import online.Stream.example.HappyMe.entity.Movie;

public interface movieRepository extends JpaRepository<Movie, Long> {

	List<Movie> findByGenre(String genre);
	

}
