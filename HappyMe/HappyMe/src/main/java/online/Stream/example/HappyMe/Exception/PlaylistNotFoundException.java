package online.Stream.example.HappyMe.Exception;

public class PlaylistNotFoundException  extends RuntimeException{
	private String message;

	public PlaylistNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
