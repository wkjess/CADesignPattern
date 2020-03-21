package menus;

import java.util.ArrayList;
import java.util.List;

/*
 * Class Menu represents the main activity for
 * it displays the selection of menu to choose from number
 * respectively
 *@author Kim Jang Wong
 *@date 17 March 2020
 */

public class Menu {

	private List<String> selection; // a list of menu selection

	/** Constructs empty constructor for this property. */
	public Menu() {
		createMenuSelection();
	}

	/*
	 * Create menu option to be selected by user
	 * while option will be taken from keyboard.
	 */
	public List<String> createMenuSelection() {
		// create array list object
		selection = new ArrayList<>();

		// add menu item into the array list
		selection.add("Retrieve all records stored in the database table");
		selection.add("Retrieve records by country code");
		selection.add("Retrieve records by country name");
				selection.add("Add new records into the database");

				return selection;
	}

	/* Getter methods. */
	public List<String> getMenuSelection() {
		return selection;
	}

}
