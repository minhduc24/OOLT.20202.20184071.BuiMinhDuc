package hust.soict.hedspi.aims;

public class InputException extends Exception{
	public InputException(String msg) {
		super(msg);
	}
	
	public InputException(String msg, Throwable cause) {
		super(msg, cause);
	}
}