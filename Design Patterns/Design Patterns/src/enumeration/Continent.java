package enumeration;

/**
 * Enumeration Continent represents the each continent for the class Country
 * @author Kim Jang Wong
 * Date 20 March 2020
 */

public enum Continent {

	/** Each country refers to an instance of the class */
	
	ASIA ("Asia"), 
	EUROPE ("Europe"),
	NORTHAMERICA ("North America"),
	AFRICA("Africa"),
	OCEANIA ("Oceania"),
	ANTARCTICA ("Antarctica"),
	SOUTHAMERICA ("South America");

	private String continentName; // the name of the continent

	/* 
	 * Constructs the continent with this property
	 * @param continentNames the name of the continent
	 */
	Continent(String continentNames) {
		continentName = continentNames;
	}
	
	/** Constructs empty constructor with this property and restrict it access. */
	private Continent() {}

	/*
	 * Get the continent name
	 * @return the string representation of the continent name
	 */
	public String getContinentName() {
		return continentName;
	}

	/** ADDING SINGLETON PATTERN TO THE INSTANCES OF THE ENUM CLASS	


	/*
	 * Get the instance of Continent of Asia
	 * @return the instance class for this continent
	 */
	public static Continent getContinentAsia() {
		return ASIA;
	}

	/*
	* Get the instance of Continent of Europe
	* @return the instance class for this continent
	*/
	public static Continent getContinentEurope() {
		return EUROPE;
	}

	/*
	* Get the instance of Continent of North America
	* @return the instance class for this continent
	*/
	public static Continent getContinentNorthAmerica() {
		return NORTHAMERICA;
	}

	/*
	* Get the instance of Continent of Africa
	* @return the instance class for this continent
	*/
	public static Continent getContinentAfrica() {
		return AFRICA;
	}

	/*
	* Get the instance of Continent of Oceania
	* @return the instance class for this continent
	*/
	public static Continent getContinentOceania() {
		return OCEANIA;
	}

	/*
	* Get the instance of Continent of Antarctica
	* @return the instance class for this continent
	*/
	public static Continent getContinentAntarctica() {
		return ANTARCTICA;
	}

	/*
	* Get the instance of Continent of South America
	* @return the instance class for this continent
	*/
	public static Continent getContinentSouthAmerica() {
		return SOUTHAMERICA;
	}
}
