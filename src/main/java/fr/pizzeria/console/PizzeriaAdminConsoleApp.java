package fr.pizzeria.console;

import fr.pizzeria.dao.PizzaDaoMemoire;
import fr.pizzeria.ihm.Menu;

/**
 * @author pc
 *
 */
public class PizzeriaAdminConsoleApp {
	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		
		Menu menu = new Menu();
		menu.manage();

	}		
}
