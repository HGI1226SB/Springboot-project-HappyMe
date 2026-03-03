package online.Stream.example.HappyMe.ResponseEntity;

import java.time.LocalDateTime;


import lombok.Data;
import online.Stream.example.HappyMe.entity.Movie;

@Data
public class ResponseStructure<T> {
	
		private T data;
		private LocalDateTime timestamp;
		private int statusCode;
		private String message;

	


}
