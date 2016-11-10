package edu.nju;

public class MessageException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MessageException() {
		super();
	}
	
	public MessageException(String msg) {
		super(msg);
	}
}
