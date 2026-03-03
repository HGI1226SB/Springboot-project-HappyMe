package online.Stream.example.HappyMe.Dto;

import lombok.Data;

@Data
public class UserRequest {
	private int userId;
	private String userName;
	private String email;
	private String password;

}
