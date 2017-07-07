package fr.pizzeria.dao;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;

/**
 * @author pc
 *
 */
public class PizzaDaoMemoire implements IPizzaDao {

	public Pizza[] listePizza = new Pizza[50];

	/**
	 * initialise le tableau de pizza
	 */
	public PizzaDaoMemoire() {

		listePizza[0] = new Pizza(0, "PEP", "Pépéroni", 12.50);
		listePizza[1] = new Pizza(1, "MAR", "Margherita", 14.00);
		listePizza[2] = new Pizza(2, "REI", "La reine", 11.50);
		listePizza[3] = new Pizza(3, "FRO", "La 4 fromages", 12.00);
		listePizza[4] = new Pizza(4, "CAN", "La cannibale", 12.50);
		listePizza[5] = new Pizza(5, "SAV", "La savoyarde", 13.00);
		listePizza[6] = new Pizza(6, "ORI", "L'orientale", 13.50);
		listePizza[7] = new Pizza(7, "IND", "L'indienne", 14.00);
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#findAllPizzas()
	 */
	public Pizza[] findAllPizzas() {
		return listePizza;
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#saveNewPizza(fr.pizzeria.model.Pizza)
	 */
	public boolean saveNewPizza(Pizza pizza) {

		for (int i = 0; i < listePizza.length; i++) {

			if (listePizza[i] == null) {

				listePizza[i] = new Pizza(i, pizza.getCode(), pizza.getNom(), pizza.getPrix());
				break;
			}
		}

		return false;
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#updatePizza(java.lang.String, fr.pizzeria.model.Pizza)
	 */
	public boolean updatePizza(String codePizza, Pizza pizza) {

		for (int i = 0; i < listePizza.length; i++) {
			if (codePizza.equals(listePizza[i].getCode())) {
				listePizza[i].setCode(pizza.getCode());
				listePizza[i].setNom(pizza.getNom());
				listePizza[i].setPrix(pizza.getPrix());
				break;
			}
		}

		return false;
	}
	
	public void verifierExistence(String codePizza) throws SavePizzaException {
		boolean trouve = false;
		for (int i = 0; i < findAllPizzas().length; i++) {

			if (findAllPizzas()[i]!=null && codePizza.equals(findAllPizzas()[i].getCode())) {
				trouve = true;
			}
		}
		if (!trouve){
			throw new SavePizzaException("Le code "+codePizza+" n'existe pas");
		}

	}
	
	public void verifierAbsence(String codePizza) throws SavePizzaException {
		boolean trouve = false;
		for (int i = 0; i < findAllPizzas().length; i++) {

			if (findAllPizzas()[i]!=null && codePizza.equals(findAllPizzas()[i].getCode())) {
				trouve = true;
			}
		}
		if (trouve){
			throw new SavePizzaException("Le code "+codePizza+" existe déja");
		}

	}
	

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#deletePizza(java.lang.String)
	 */
	public boolean deletePizza(String codePizza) {
		
		for (int i = 0; i < listePizza.length; i++) {
			if (codePizza.equals(listePizza[i].getCode())) {
				listePizza[i] = null;
				break;
			}
		}
		
		return false;
	}

}
