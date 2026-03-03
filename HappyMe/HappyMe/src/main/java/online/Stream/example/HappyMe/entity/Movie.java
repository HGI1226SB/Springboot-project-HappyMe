package online.Stream.example.HappyMe.entity;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data

public class Movie 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long mediaId;
	private String title;
	private String type;
	private String genre;
	private String duration;
	private String filePath;
	@OneToMany(mappedBy = "movie")
	private List<Playlist> playlists;
	@ManyToOne
	@JoinColumn(name="userId", nullable=false)
	private User user;
	
	

}
