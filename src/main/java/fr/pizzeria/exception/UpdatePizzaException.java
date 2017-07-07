package fr.pizzeria.exception;

public class UpdatePizzaException extends StockageException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9181053071332463432L;

	public UpdatePizzaException() {
		super();
	}

	public UpdatePizzaException(String message) {
		super(message);
	}
}
