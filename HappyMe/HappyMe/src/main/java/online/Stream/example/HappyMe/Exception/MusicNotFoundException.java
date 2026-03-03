package online.Stream.example.HappyMe.Exception;

public class MusicNotFoundException extends RuntimeException
{
	private String message;

	public MusicNotFoundException(String message) {
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
