package fr.pizzeria.exception;

public class SavePizzaException extends StockageException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4464726704514516220L;

	public SavePizzaException() {
		super();
	}

	public SavePizzaException(String message) {
		super(message);
	}

}
