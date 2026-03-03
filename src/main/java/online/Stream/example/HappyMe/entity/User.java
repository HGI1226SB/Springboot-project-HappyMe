package online.Stream.example.HappyMe.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class User {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int userId;
	private String userName;
	private String email;
	private String password;
	// User uploads many movies
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Movie> movies;

    // User creates many playlists
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Playlist> playlists;
}
	