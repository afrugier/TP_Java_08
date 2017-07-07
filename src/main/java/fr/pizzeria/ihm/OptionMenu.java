package fr.pizzeria.ihm;

import fr.pizzeria.dao.IPizzaDao;

public abstract class OptionMenu {
	
	/**
	 * Définie les méthodes getLibelle, getTitle et execute
	 */
	public OptionMenu(){
	}

	public abstract String getLibelle();
	public abstract String getTitle();
	public abstract boolean execute(IPizzaDao Dao);
}
