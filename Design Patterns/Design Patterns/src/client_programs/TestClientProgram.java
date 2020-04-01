package client_programs;

import static consoles.Console.*;
import countries.Country;
import menus.Menu;

/*
 * Class ClientProgram represents an interaction from
 * client with data access object (database).
 * It shows a list of menu option
 * can be selected, all result will be extracting from
 * database and will display to the screen.
 * @author Kim Jang Wong
 * Date: 27 March 2020
 */

public class TestClientProgram {

	/** Declare the instance of the class that require.*/

	private Country country;
	private Menu menu;

	/** Construct the instance of the class and create the class menu's object. */
	public TestClientProgram() {
		// TODO Auto-generated constructor stub
		country = new Country();
		menu = new Menu();
		while(true) {
			// display menu option on the screen
			showMenu();
		}
	}

	/*
	 * This method is displaying a list of
	 * menu option to be selected by client on the screen
	 */
	private void showMenu() {
		// a variable assigned for reading input by user selection
		String option = "";

		// looping the list of menu option
		for(int i = 0; i < menu.createMenuSelection().size(); i=i+1) {
			// displaying the list of menu option
			System.out.println(i + 1 + " - " + menu.createMenuSelection().get(i));
		}
		// put extra line here
		//System.out.println();

		// now reading input from keyboard by user
		option = readInput("Choose an option from the menu: ", menu.createMenuSelection().size() + "|[1-6]");

		// observe which option been selected
		// using switch cases option
		switch (option) {

		// for getting all the country
		case "1":
			country.getAllCountries();
			break;

			// for searching a country by insert the country name
		case "2":
			country.searchCountryByName();
			break;

			// for searching a country by insert the country code
		case "3":
			country.searchCountryByCode();
			break;

			// for adding a new country into the database
		case "4":
			country.addNewCountry();
			break;

			// for closing the connection after complete the communication
		case "5":
			country.closingConnection();
			break;

			// no selection then do nothing
		default:
				break;
		}
	}

}
