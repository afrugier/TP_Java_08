package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;

/**
 * @author pc
 *
 */
public class PizzaDaoMemoire implements IPizzaDao {

	List<Pizza> listePizza = new ArrayList<Pizza>();

	/**
	 * initialise le tableau de pizza
	 */
	public PizzaDaoMemoire() {

		listePizza.add(new Pizza("PEP", "Pépéroni", 12.50));
		listePizza.add(new Pizza("MAR", "Margherita", 14.00));
		listePizza.add(new Pizza("REI", "La reine", 11.50));
		listePizza.add(new Pizza("FRO", "La 4 fromages", 12.00));
		listePizza.add(new Pizza("CAN", "La cannibale", 12.50));
		listePizza.add(new Pizza("SAV", "La savoyarde", 13.00));
		listePizza.add(new Pizza("ORI", "L'orientale", 13.50));
		listePizza.add(new Pizza("IND", "L'indienne", 14.00));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.IPizzaDao#findAllPizzas()
	 */
	public List<Pizza> findAllPizzas() {
		return listePizza;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.IPizzaDao#saveNewPizza(fr.pizzeria.model.Pizza)
	 */
	public boolean saveNewPizza(Pizza pizza) {

		listePizza.add(new Pizza(pizza.getCode(), pizza.getNom(), pizza.getPrix()));

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.IPizzaDao#updatePizza(java.lang.String,
	 * fr.pizzeria.model.Pizza)
	 */
	public boolean updatePizza(String codePizza, Pizza pizza) {

		for (int i = 0; i < listePizza.size(); i++) {
			if (codePizza.equals(listePizza.get(i).getCode())) {
				listePizza.get(i).setCode(pizza.getCode());
				listePizza.get(i).setNom(pizza.getNom());
				listePizza.get(i).setPrix(pizza.getPrix());
				break;
			}
		}

		return false;
	}

	public void verifierExistence(String codePizza) throws SavePizzaException {
		boolean trouve = false;
		for (int i = 0; i < listePizza.size(); i++) {

			if (listePizza.get(i) != null && codePizza.equals(listePizza.get(i).getCode())) {
				trouve = true;
			}
		}
		if (!trouve) {
			throw new SavePizzaException("Le code " + codePizza + " n'existe pas");
		}

	}

	public void verifierAbsence(String codePizza) throws SavePizzaException {
		boolean trouve = false;
		for (int i = 0; i < listePizza.size(); i++) {

			if (listePizza.get(i) != null && codePizza.equals(listePizza.get(i).getCode())) {
				trouve = true;
			}
		}
		if (trouve) {
			throw new SavePizzaException("Le code " + codePizza + " existe déja");
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.IPizzaDao#deletePizza(java.lang.String)
	 */
	public boolean deletePizza(String codePizza) {

		for (int i = 0; i < listePizza.size(); i++) {
			if (codePizza.equals(listePizza.get(i).getCode())) {
				listePizza.remove(i);
				break;
			}
		}

		return false;
	}

}
