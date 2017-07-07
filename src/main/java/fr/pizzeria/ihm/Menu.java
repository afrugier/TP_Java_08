package fr.pizzeria.ihm;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoMemoire;

/**
 * @author pc
 *
 */
public class Menu {
	static Map<Integer, OptionMenu> optionMenu = new HashMap<>();
	static Scanner questionAjout = new Scanner(System.in).useLocale(Locale.US);

	public Menu(){
		optionMenu.put(new Integer(0), new ListerPizzaOptionMenu());
		optionMenu.put(new Integer(1), new AjouterPizzaOptionMenu());
		optionMenu.put(new Integer(2), new ModifierPizzaOptionMenu());
		optionMenu.put(new Integer(3), new SupprimerPizzaOptionMenu());
	}

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
				System.out.println(optionMenu.get(0).getTitle());
				optionMenu.get(0).execute(dao);
				break;
			case 2:
				System.out.println(optionMenu.get(1).getTitle());
				optionMenu.get(1).execute(dao);
				break;
			case 3:
				System.out.println(optionMenu.get(2).getTitle());
				optionMenu.get(0).execute(dao);
				optionMenu.get(2).execute(dao);
				break;
			case 4:
				System.out.println(optionMenu.get(3).getTitle());
				optionMenu.get(0).execute(dao);
				optionMenu.get(3).execute(dao);
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

		for (int i = 0; i < optionMenu.size(); i++) {
			System.out.println(optionMenu.get(i).getLibelle());
		}

		System.out.println("99. Sortir");

	}
}
