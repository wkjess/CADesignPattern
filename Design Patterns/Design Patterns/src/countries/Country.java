package countries;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import abstracts.AbstractCountry;
import connections.MySQLConnector;
import consoles.Console;
import enumeration.Continent;
import interfaces.Communicator;

/*
 * Class Country represents two ways communication
 * between client program while making a query
 * where query will be passing through from selected menu
 * subsequently querying connected to the server's database
 * once information have been dealt with, the server's database will be
 * returning the information through the connected
 * client program.
 * The class also extends its parent's class AbstractCountry
 * and implements its interface's methods from Communicator
 * @author Kim Jang Wong
 * Date 24 March 2020
 */

public class Country extends AbstractCountry implements Communicator {

	/** Initial the connection to communicate with database. */

	private Connection connection = null;
	
	/* Constructs the class object and create the connection object. */
	public Country() {
		connection = MySQLConnector.getConnection();
	}

	/*
	 * Listing all countries.
	 * e.g. Ireland and so forth
	 */
	@Override
	public void getAllCountries() {
		// initial the prepared statement.
		PreparedStatement pstmt = null;

		// define the query statement for all country.
		String query = "SELECT Name FROM country ORDER BY Name ASC";
		try {
			// establish the connection with this statement.
			pstmt = connection.prepareStatement(query);
			// store the the value into the result set.
			ResultSet rs = pstmt.executeQuery();
			// now prompt the return result extracting from database.
			System.out.printf("All the countries are listed below:%n");

			// extracting all data related to this query
			while(rs.next()) {
				// getting the column's value from database i.e. just the country name
				String countryName = rs.getString("Name");

				// if success then display the country name to the screen.
				System.out.printf("%s%n", countryName);
			}
			// closing the data connection
			rs.close(); pstmt.close();
		} catch(SQLException se) {
			System.out.println("Communication error: Couldn't establish or invalid network, check the connection.");
		} catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

	/*
	 * Searching a country name
	 * by inserting the country name
	 * e.g. Malaysia
	 */
	@Override
	public void searchCountryByName() {
		// initial the prepared statement.
		PreparedStatement pstmt = null;

		// prompt the query message searching country by name
		System.out.printf("Hey! Which country are you searching for?%n");
		// read input from keyboard
		String input = Console.readInput("Enter country name: ");

		// define the query statement for searching a country.
		String query = "SELECT * FROM country WHERE Name = ?";

		try {
			// establish the connection with this statement.
			pstmt = connection.prepareStatement(query);

			// passing the input value into the argument.
			pstmt.setString(1, input);

			// executing the query and store the value into the result set.
			ResultSet rs = pstmt.executeQuery();

			// if the country exist, then get it from database

			if(rs.next()) {
				// now prompt the return result extracting from database.
				System.out.printf("The country %s that you search for are been found%n", input);
				System.out.println("COUNTRY CODE" + "\t" +
						"NAME" + "\t" +
						"CONTINENT" + "\t" +
						"SURFACE AREA" + "\t" +
						"HEAD OF STATE");

				// extracting all data related to this query
				// getting the each column's value from database

				String code = rs.getString("Code");
				String name = rs.getString("Name");
				String continent = rs.getString("Continent");
				float surfaceArea = rs.getFloat("SurfaceArea");
				String headOfState = rs.getString("HeadOfState");

				// then display the country details to the screen.
				System.out.format("%s   \t %-10s   \t %-10s   \t   %5.3f   \t   %s%n", code, name, continent, surfaceArea, headOfState);
			} else {
				// Oops, no such country found prompt message
				System.out.printf("Hey! Sorry the country %s that you search for cannot be found.%n", input);
			}

			// closing the data connection
			rs.close(); pstmt.close();
		} catch(SQLException se) {
			System.out.println("Communication error: Couldn't establish or invalid network, check the connection.");
		} catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

	/*
	 * Searching a country
	 * by entering the country code
	 * e.g. IE
	 */
	@Override
	public void searchCountryByCode() {
		// initial the prepared statement.
		PreparedStatement pstmt = null;
		// allows A - Z characters only and length max of 3
				String codePattern = "^[A-Z]{3}$";

		// prompt the query message searching country by code
		System.out.printf("Hey! Which country are you searching for?\n");

		// read input from keyboard
		String input = Console.readInput("Enter country code: ", codePattern);

		// define the query statement for searching a country.
		String query = "SELECT * FROM country WHERE Code = ?";

		try {
			// establish the connection with this statement.
			pstmt = connection.prepareStatement(query);

			// passing the input value into the argument.
			pstmt.setString(1, input);

			// executing the query and store the value into the result set.
			ResultSet rs = pstmt.executeQuery();

			// if the country exist, then get it from database

			if(rs.next()) {
				// now prompt the return result extracting from database.
				System.out.printf("The country %s that you search for are been found%n", input);
				System.out.println("COUNTRY CODE" + "\t" +
						"NAME" + "\t" +
						"CONTINENT" + "\t" +
						"SURFACE AREA" + "\t" +
						"HEAD OF STATE");

				// extracting all data related to this query
				// getting the each column's value from database
				String code = rs.getString("Code");
				String name = rs.getString("Name");
				String continent = rs.getString("Continent");
				float surfaceArea = rs.getFloat("SurfaceArea");
				String headOfState = rs.getString("HeadOfState");

				// then display the country details to the screen.
				System.out.format("%5s   \t %20s   \t %20s   \t   %5.3f   \t   %s%n", code, name, continent, surfaceArea, headOfState);
			} else {
				// Oops, no such country found prompt message
				System.out.printf("Hey! Sorry the cuntry %s that you search for cannot be found.%n", input);
			}
			// closing the data connection
			rs.close(); pstmt.close();
		} catch(SQLException se) {
			System.out.println("Communication error: Couldn't establish or invalid network, check the connection.");
		} catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

	private static boolean validate() {
		// allows A - Z characters only and length max of 3
		String codePattern = "^[A-Z]{3}$";
		// allows words that start with upper case and ends with lower case
		String namePattern = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
		// allows numbers only
		String floatPattern = "^[+-]?([0-9]*[.])?[0-9]+$";
		Country country = new Country();

		System.out.println("Please enter the new country details to add into the database.");
		boolean valid = false;
		try {
			String code = Console.readInput("Enter country code i.e. IRE: ");
			country.setCountryCode(code);
			// check if input value match
			while(valid == false) {
				if(country.getCountryCode().matches(codePattern) && ! code.isEmpty()) {
					valid = true;
				} else {
					valid = false;
					System.out.println("Error: Either fields are empty or invalid letter entered, try again.");
					code = Console.readInput("Reenter country code i.e. IRE: ");
				}
			}
		} catch(Exception ex) {
			System.out.println("Error: Invalid letter or fields are empty, check it and try again.");
		}

		try {
			String name = Console.readInput("Enter country name i.e. Ireland: ");
			country.setCountryName(name);
			// check if input value match
			while(valid == false) {
				if(country.getCountryName().matches(namePattern) && ! name.isEmpty()) {
					valid = true;
				} else {
					valid = false;
					System.out.println("Error: Either fields are empty or invalid letter entered, try again.");
					name = Console.readInput("Reenter country name i.e. Ireland: ");
				}
			}
		} catch(Exception ex) {
			System.out.println("Error: Invalid letter or fields are empty, check it and try again.");
		}

		//continent	
		System.out.println("Choose one of the following continents: ");

		try { 						
			System.out.println("1: Asia");
			System.out.println("2: Europe");
			System.out.println("3: North America");
			System.out.println("4: Africa");
			System.out.println("5: Oceania");
			System.out.println("6: Antarctica");
			System.out.println("7: South America");

			// declaring the class enumeration inside switch-case using singleton pattern
			// read choose value
			do {
				String choose = Console.readInput("Enter number between 1 to 7 only.");
				switch (choose) {

				case ("1"):
					// for Asian country
					Continent asia = Continent.getContinentAsia();
				country.setCountryContinent(asia.getContinentName()); //has to get the name of the country as String to save into the Database
				break;	

				case ("2"):	
					Continent euro = Continent.getContinentEurope();
				country.setCountryContinent(euro.getContinentName());
				break;

				case ("3"):
					Continent northAmerica = Continent.getContinentNorthAmerica();
				country.setCountryContinent(northAmerica.getContinentName());
				break;

				case ("4"):	
					Continent africa = Continent.getContinentAfrica();
				country.setCountryContinent(africa.getContinentName());
				break;

				case ("5"):	
					Continent oceania = Continent.getContinentOceania();
				country.setCountryContinent(oceania.getContinentName());
				break;

				case ("6"):	
					Continent antartica = Continent.getContinentAntarctica();
				country.setCountryContinent(antartica.getContinentName());
				break;

				case ("7"):		
					Continent southAmerica = Continent.getContinentSouthAmerica();
				country.setCountryContinent(southAmerica.getContinentName());
				break;

				default: 
					break;
				}
			} while(valid == false);
		} catch (Exception ex) {
			System.out.println("Error reading input, try again");
		}

		try {
			String surfaceArea = Console.readInput("Enter the surface area i.e. 34.333:  ");
			//			float valueFloat = Float.valueOf(surfaceArea);
			country.setCountrySurfaceArea(Float.valueOf(surfaceArea)); // convert from string to float value
			// check if input value match
			while(valid == false) {
				if(Float.toString(country.getCountrySurfaceArea()).matches(floatPattern) && ! surfaceArea.isEmpty()) {
					valid = true;
				} else {
					valid = false;
					System.out.println("Error: Either fields are empty or invalid float value entered, try again.");
					surfaceArea = Console.readInput("Reenter country surface area i.e. 233.33: ");
				}
			}
		} catch(Exception ex) {
			System.out.println("Error: Invalid letter or fields are empty, check it and try again.");
		}

		try {
			String headOfState = Console.readInput("Enter country's head of state i.e. LJhonson: ");
			country.setCountryHeadOfState(headOfState);
			// check if input value match
			while(valid == false) {
				if(country.getCountryHeadOfState().matches(namePattern) && ! headOfState.isEmpty()) {
					valid = true;
				} else {
					valid = false;
					System.out.println("Error: Either fields are empty or invalid letter entered, try again.");
					headOfState = Console.readInput("Reenter country's head of state i.e. London: ");
				}
			}
		} catch(Exception ex) {
			System.out.println("Error: Invalid letter or fields are empty, check it and try again.");
		}
		return valid;
	}

	/*
	 * Adding a new country
	 * into the database by
	 * entering the country details
	 */
	@Override
	public void addNewCountry() {
		// initial the prepared statement.
		PreparedStatement pstmt = null;
		Country country = new Country();

		// verify all fields are correct before adding it into the database
		if(validate()) {
			// adding value into the database
			// define the query statement for all country.

			String query = "INSERT INTO country (Code, Name, Continent, SurfaceArea, HeadOfState) VALUES (?, ?, ?, ?, ?)";

			try {
				// establish the connection with this statement.
				pstmt = connection.prepareStatement(query);

				// passing the input value into the argument.
				pstmt.setString(1, country.getCountryCode());
				pstmt.setString(2, country.getCountryName());
				pstmt.setString(3, country.getCountryContinent());
				pstmt.setFloat(4, country.getCountrySurfaceArea());
				pstmt.setString(5, country.getCountryHeadOfState());

				pstmt.executeUpdate();

				// executing the query and store the value into the result set.
				//ResultSet rs = pstmt.executeQuery();
				System.out.println("DATABASE CONFIRMATION: The new country has been added successfully.");

				// extracting all data related to this query
				//while(rs.next()) {
					// getting the each column's value from database

					//String code = rs.getString("Code");
					//String name = rs.getString("Name");
					//String continent = rs.getString("Continent");
					//float surfaceArea = rs.getFloat("SurfaceArea");
					//String headOfState = rs.getString("HeadOfState");

					// then display the country details to the screen.
					//System.out.format("%10s   \t %25s   \t %25s   \t   %5.5f   \t   %s%n", code, name, continent, surfaceArea, headOfState);
				//}
				// closing the data connection
				/*rs.close();*/ pstmt.close();
			} catch(SQLException ex) {
				System.out.println("Error: The connection and data invalid, check it and try again");
			}
		} else {
			System.out.println("Error: Something went wrong, please check all details are valid and try again.");
		}
	}

	/*
	 * Closing the connection after
	 * completing querying and retrieving information from
	 * server.
	 */
	public void closingConnection() {
		try {
			System.out.println("Okay, all connected object will be closing now and a refresh of the connection is done!");
			if(connection == null) {
				connection.close();
			}
		} catch(SQLException se) {
			System.err.println(se.getMessage());
		}
	}

}
