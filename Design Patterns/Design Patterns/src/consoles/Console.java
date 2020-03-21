package consoles;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/*
 * Class Console represents a static method
 * to taking input values from standard keyboard
 * @author Kim Jang Wong
 * @date 17 March 2020
 */

public class Console {

	/** Constructs an empty constructor for this property. */
	public Console() {
		// I might not use this constructor, depend how I feel
	}

	/*
	 * Read keyboard input values
	 * @param prompt the string representation of input message
	 * catch IOException if any unexpected operation occur. 
	 	 * @return the string representation of this input value.
	 */
	public static String readInput(String prompt) {
		BufferedReader br = null; // read input by buffered reader object
		String input = null;
		System.out.print(prompt);
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			while(input == null) {
				input = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error! Invalid input, try again");
			System.err.println(e.getMessage());
		}
		return input.trim(); // omitted any white space 
	}

	/*
	 * Read keyboard input values, matching any regular expression patterns
	 * @param prompt the string representation of the prompt message
	 * @param regex the string pattern matches the input value
	 * * catch IOException if any unexpected operation occur. 
	 * @return the string representation of this input value.
	 */
	public static String readInput(String prompt, String regexp) {
		BufferedReader br = null; // read input by buffered reader object
		String input = null;
		System.out.print(prompt);
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			while(input == null) {
				input = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error! Invalid input, try again.");
			System.err.println(e.getMessage());
		}
		return input.trim(); // omitted any white space
	}

	/*
	 * This method to prompt to return back to menu.
	 */
	public static void backToMenu(){
		readInput("Please Press ENTER key to return to menu.");
	}

}
