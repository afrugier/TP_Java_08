package fr.pizzeria.ihm;

import java.util.Locale;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoMemoire;

/**
 * @author pc
 *
 */
public class Menu {

	static OptionMenu[] optionMenu = new OptionMenu[]{ 
		new ListerPizzaOptionMenu(), 
		new AjouterPizzaOptionMenu(),
		new ModifierPizzaOptionMenu(), 
		new SupprimerPizzaOptionMenu() 
	};

	static Scanner questionAjout = new Scanner(System.in).useLocale(Locale.US);

	/**
	 * execute le code en fonction du choix réaliser dans le menu
	 */
	public void manage() {
		
		PizzaDaoMemoire dao = new PizzaDaoMemoire();

		int choixPizza = 0;
		do {
			afficher();
			choixPizza = questionAjout.nextInt();

			switch (choixPizza) {
			case 1:
				System.out.println(optionMenu[0].getTitle());
				optionMenu[0].execute(dao);
				break;
			case 2:
				System.out.println(optionMenu[1].getTitle());
				optionMenu[1].execute(dao);
				break;
			case 3:
				System.out.println(optionMenu[2].getTitle());
				optionMenu[0].execute(dao);
				optionMenu[2].execute(dao);
				break;
			case 4:
				System.out.println(optionMenu[3].getTitle());
				optionMenu[0].execute(dao);
				optionMenu[3].execute(dao);
				break;
			case 99:
				System.out.println("Aurevoir :-(");
				break;
			default:
				break;
			}
		} while (choixPizza != 99);
	}

	/**
	 * Affiche le menu
	 */
	public void afficher() {
		// Titre
		System.out.println("***** Pizzeria Administration *****");

		for (int i = 0; i < optionMenu.length; i++) {
			System.out.println(optionMenu[i].getLibelle());
		}

		System.out.println("99. Sortir");

	}
}
