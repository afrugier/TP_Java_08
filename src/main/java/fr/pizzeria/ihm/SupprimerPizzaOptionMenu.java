package fr.pizzeria.ihm;

import java.util.Locale;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;

public class SupprimerPizzaOptionMenu extends OptionMenu {

	static Scanner questionAjout = new Scanner(System.in).useLocale(Locale.US);

	/* (non-Javadoc)
	 * @see fr.pizzeria.ihm.OptionMenu#getLibelle()
	 */
	@Override
	public String getLibelle() {
		return "4. Supprimer une pizza";
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.ihm.OptionMenu#execute(fr.pizzeria.dao.IPizzaDao)
	 */
	@Override
	public boolean execute(IPizzaDao dao) {

		System.out.println("Veuillez Choisir la pizza à supprimer");

		System.out.println("(99 pour abandonner)");
		
		String codePizza = null;
		boolean codeTrouve = false;

		do {
			codePizza = questionAjout.next();
			try {
				dao.verifierExistence(codePizza);
				codeTrouve = true;
			} catch (SavePizzaException e) {
				System.out.println("Le code " + codePizza + " n'existe pas");
				codeTrouve = false;
			}
		} while (!codeTrouve);
		
		
		if (!codePizza.equals("99")) {

			try {
				dao.deletePizza(codePizza);
			} catch (DeletePizzaException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
			System.out.println("Pizza Supprimée !");
			System.out.println("");

		}
		return false;
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.ihm.OptionMenu#getTitle()
	 */
	@Override
	public String getTitle() {
		return "Suppression d’une pizza";
	}

}
