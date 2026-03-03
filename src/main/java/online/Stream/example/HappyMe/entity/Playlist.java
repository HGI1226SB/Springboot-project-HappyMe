package online.Stream.example.HappyMe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Entity
@Data
public class Playlist 
{
	
@Id
private Long playlistId;
private String playlistName;
private Long musicId;
private Long movieId;

@ManyToOne
@JoinColumn(name="mediaId", nullable=false)
private Movie movie;

@ManyToOne
@JoinColumn(name="userId", nullable=false)
private User user;

public Long getPlaylistId() {
    return playlistId;}

}
