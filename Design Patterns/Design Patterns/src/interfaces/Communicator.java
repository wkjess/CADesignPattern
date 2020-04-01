package interfaces;

/*
 * Interface Communicator is defined for 
 * data access object Interface
 * it operates on sharing contract on  the model objects.
 * @author Kim Jang Wong
 * @date: 19 March 2020
 */
public interface Communicator {

	/** Define a list of methods to be implemented. */

	/*
	 * Listing all countries.
	 * e.g. Ireland and so forth
	 */
	public abstract void getAllCountries();

	/*
	 * Searching a country name
	 * by inserting the country name
	 * e.g. Malaysia
	 */
	public abstract void searchCountryByName();

	/*
	 * Searching a country
	 * by entering the country code
	 * e.g. IE
	 */
	public abstract void searchCountryByCode();

	/*
	 * Adding a new country
	 * into the database by
	 * entering the country details
	 */
	public abstract void addNewCountry();

	/*
	 * Closing the connection after
	 * completing querying and retrieving information from
	 * server.
	 */
	public abstract void closingConnection();

}
