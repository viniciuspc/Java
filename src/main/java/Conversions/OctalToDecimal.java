package Conversions;

import java.util.Scanner;

/**
 * Converts any Octal Number to a Decimal Number
 * 
 * @author Zachary Jones
 *
 */
public class OctalToDecimal {

	/**
	 * Main method
	 * 
	 * @param args
	 *            Command line arguments
	 */
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Octal Input: ");
		String inputOctal = sc.nextLine();
		int result = convertOctalToDecimal(inputOctal);
		if (result != -1)
			System.out.println("Result convertOctalToDecimal : " + result);
		sc.close();
		
	}

	/**
	 * This method converts an octal number to a decimal number.
	 * 
	 * @param inputOctal
	 *            The octal number
	 * @return The decimal number
	 */
	public static int convertOctalToDecimal(String inputOctal) {

		
			// Actual conversion of Octal to Decimal:
			Integer outputDecimal = Integer.parseInt(inputOctal, 8);
			return outputDecimal;
	}
}