package exceptions;

public class ParentException extends Exception {

	private static final long serialVersionUID = -1009843315245833838L;

	public ParentException(String errorMessage) {
		super(errorMessage);
	}
}
