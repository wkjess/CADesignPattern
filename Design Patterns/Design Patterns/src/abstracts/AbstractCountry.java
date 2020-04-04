package abstracts;

/*
 * The abstract class AbstractCountry is,
 * model Object or Value Object where, 
 * this object is simple class containing get and set methods,
 * to store data retrieved using,
 * data access object class.
 * @author Kim Jang Wong
 * Date: 22 March 2020
 */

public abstract class AbstractCountry {

	/** Declare each global variables. */

	private static String code; // the code for the country e.g. IRE
	private static String name; // the name of the country e.g. Ireland
	private static String continent; // each of the country's continent belong to
	private static float surfaceArea; // the surface area of the country
	private static String headOfState; // refers to the head of state

	/** assigns the getters and setters for each variables. */

	/*
	 * Get the string representation of the country code
	 * @return the string representation of the country code
	 */
	public String getCountryCode() {
		return code;
	}
	/*
	 * Set the country code
	 * @param codes the country code
	 */
	public void setCountryCode(String codes) {
		code = codes;
	}

	/*
	 * Get the string representation of the country name.
	 * @return the string representation of the country name.
	 */
	public String getCountryName() {
		return name;
	}

	/*
	 * Set the country name
	 * @param names the country name
	 */
	public void setCountryName(String names) {
		name = names;
	}

	/*
	 * Get the string representation of the country's continent.
	 * @return the string representation of the country's continent
	 */
	public String getCountryContinent() {
		return continent;
	}

	/*
	 * Set the country's continent.
	 * @param continents the country's continent.
	 */
	public void setCountryContinent(String continents) {
		continent = continents;
	}

	/*
	 * Get the surface area of the country
	 * @return the surface area of the country.
	 */
	public float getCountrySurfaceArea() {
		return surfaceArea;
	}

	/*
	 * Set the surface are of the country.
	 * @param area the country's surface area.
	 */
	public void setCountrySurfaceArea(float area) {
		surfaceArea = area;
	}

	/*
	 * Get the string representation of the head of state
	 * @return the string representation of the country's head of state.
	 */
	public String getCountryHeadOfState() {
		return headOfState;
	}

	/*
	 * Set the country's head of state.
	 * @param states the country's head of state.
	 */
	public void setCountryHeadOfState(String states) {
		headOfState = states;
	}

}
