package fr.pizzeria.ihm;

import fr.pizzeria.dao.IPizzaDao;

/**
 * @author pc Fait la liste des pizzas situer dans le tableau listePizza
 *
 */
public class ListerPizzaOptionMenu extends OptionMenu {

	/* (non-Javadoc)
	 * @see fr.pizzeria.ihm.OptionMenu#getLibelle()
	 */
	@Override
	public String getLibelle() {
		return "1. Lister les pizzas";
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.ihm.OptionMenu#execute(fr.pizzeria.dao.IPizzaDao)
	 */
	@Override
	public boolean execute(IPizzaDao dao) {
		for (int i = 0; i < dao.findAllPizzas().length; i++) {

			if (dao.findAllPizzas()[i] != null) {

				// for (int j = 0; j < listePizza[i].length; j++) {
				// System.out.print(listePizza[i][j] + " ");
				// }
				System.out.print(dao.findAllPizzas()[i].getCode() + " -> " + dao.findAllPizzas()[i].getNom() + " ("
						+ dao.findAllPizzas()[i].getPrix() + ") ");

				System.out.println("");
			}
		}

		System.out.println("");

		return false;
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.ihm.OptionMenu#getTitle()
	 */
	@Override
	public String getTitle() {
		return "Liste des pizzas";
	}

}
