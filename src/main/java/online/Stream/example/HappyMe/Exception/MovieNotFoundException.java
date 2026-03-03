package online.Stream.example.HappyMe.Exception;

public class MovieNotFoundException extends RuntimeException
{
	private String message;

	public MovieNotFoundException(String message) {
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
