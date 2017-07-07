package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

/**
 * @author pc
 *
 */
public interface IPizzaDao {
	List<Pizza> findAllPizzas();
	/**
	 * @param pizza
	 * @return
	 * @throws SavePizzaException
	 */
	boolean saveNewPizza(Pizza pizza) throws SavePizzaException;
	/**
	 * @param codePizza
	 * @param pizza
	 * @return
	 * @throws UpdatePizzaException
	 */
	boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException;
	/**
	 * @param codePizza
	 * @return
	 * @throws DeletePizzaException
	 */
	boolean deletePizza(String codePizza) throws DeletePizzaException;
	
	void verifierExistence(String codePizza) throws SavePizzaException;
	
	void verifierAbsence(String codePizza) throws SavePizzaException;
}
