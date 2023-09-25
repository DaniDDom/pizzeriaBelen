package pizzeria.belen;

import java.util.*;

/**
 * This class controls the input of the user.
 * 
 * @author Dani Dom
 *
 */

public class Input {

	/**
	 * Default Constructor.
	 */
	private Input() {
	}

	private static Scanner sc;

	static {
		sc = new Scanner(System.in);
	}

	/** ERROR MESSAGE */
	private static final String MSG_ERROR = " ERROR: The input provided is not a number, try again.";

	/**
	 * Request a String.
	 * 
	 * @param cad message
	 * @return String.
	 */
	public static String inputString(String cad) {
		
		// Chain to return.
		String chain = "";

		System.out.print(cad);
		chain += sc.nextLine();

		return chain;
	}

	/**
	 * Request a char.
	 * 
	 * @param cad message
	 * @return Char
	 */
	public static char inputChar(String cad) {
		
		// Chain to return.
		String chain;

		System.out.print(cad);

		do {
			chain = sc.nextLine();

			if (chain.length() > 1) {
				System.err.println("\n ERROR: Introduce just a character");
			} else if (chain.length() < 1) {
				System.err.println("\n ERROR: Introduce a character.");
			}

		} while (chain.length() != 1);

		return chain.toUpperCase().charAt(0);
	}

	/**
	 * Request an int
	 * 
	 * @param chain message
	 * @return Int
	 */
	public static int inputInt(String chain) {
		
		// Num to return
		int num = 0;
		boolean error = false;

		System.out.print(chain);

		do {
			error = false;
			try {
				num = sc.nextInt();
			} catch (InputMismatchException ex) {
				System.err.println(MSG_ERROR);
				error = true;
			} finally {
				sc.nextLine();
			}
		} while (error);

		return num;
	}

	/**
	 * Request a float.
	 * 
	 * @param cadena message
	 * @return float
	 */
	public static float pedirFloat(String cadena) {
		
		// Float to return
		float num = 0;
		boolean error = false;

		System.out.print(cadena);

		do {
			error = false;
			try {
				num = sc.nextFloat();
			} catch (InputMismatchException ex) {
				System.err.println(MSG_ERROR);
				error = true;
			} finally {
				sc.nextLine();
			}
		} while (error);

		return num;
	}

	/**
	 * Request a double.
	 * 
	 * @param chain message
	 * @return double
	 */
	public static double inputDouble(String chain) {
		
		// Double to return
		double num = 0;
		boolean error = false;

		System.out.print(chain);

		do {
			error = false;
			try {
				num = sc.nextDouble();
			} catch (InputMismatchException ex) {
				System.err.println(MSG_ERROR);
				error = true;
			} finally {
				sc.nextLine();
			}
		} while (error);

		return num;
	}

	/**
	 * Request a Long
	 * @param chain message
	 * @return Long
	 */
	public static long pedirLong(String chain) {
		
		// Long to return
		long num = 0;
		boolean error = false;

		System.out.print(chain);

		do {
			error = false;
			try {
				num = sc.nextLong();
			} catch (InputMismatchException ex) {
				System.err.println(MSG_ERROR);
				error = true;
			} finally {
				sc.nextLine();
			}
		} while (error);

		return num;
	}

}
