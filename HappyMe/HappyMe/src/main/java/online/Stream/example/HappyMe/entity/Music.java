package online.Stream.example.HappyMe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;

@Entity
@Data

public class Music {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long songId;
	private String songName;
	private String title;
	private String artist;
	private String album;
	private String genre;
	public String getPlaylistName() {
		// TODO Auto-generated method stub
		return null;
	}

	
}


