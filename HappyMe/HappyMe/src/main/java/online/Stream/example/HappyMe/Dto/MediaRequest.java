package online.Stream.example.HappyMe.Dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class MediaRequest {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long mediaId;
	private String title;
	private String type;
	private String genre;
	private String duration;
	private String filePath;
}
