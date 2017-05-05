//	This program asks the user for a phrase and tests if that phrase
//	is a palindrome. A palindrome is a word or phrase that is spelled
//	the same forwards as well as backwards. Whitespace and punctuation
//	is not included in the evaluation.

import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		String potPalin = input(new Scanner(System.in));
		String stripPotPalin = stripPunc(potPalin);
		
		if (stripPotPalin.equalsIgnoreCase(reverse(stripPotPalin))) {
			System.out.printf("\"%s\" is a palindrome!", potPalin);
		} else {
			System.out.printf("\"%s\" is not a palindrome!", potPalin);
		}
	}

	// Asks user for input, and ensures the validity of the input
	// Pre : Scanner object
	// Post: User phrase
	public static String input(Scanner console) {
		System.out.print("Enter line to check: ");
		if (console.hasNextLine()) {
			return console.nextLine();
		} else {
			throw new IllegalArgumentException("Not a valid input");
		}
	}

	// Strips all whitespace and puctuation from input
	// Pre : String
	// Post: String, without whitespace & punctuation
	public static String stripPunc(String phrase) {
		String strippedLine = "";
		for (int i = 0; i < phrase.length(); i++) {
			char ch = phrase.charAt(i);
			if (Character.isLetter(ch) || Character.isDigit(ch)) {
				strippedLine += ch;
			}
		}
		return strippedLine;
	}

	// Returns input in reverse order
	// Pre : String
	// Post: String, reversed
	public static String reverse(String phrase) {
		String reversed = "";
		for (int i = 0; i < phrase.length(); i++) {
			reversed = phrase.charAt(i) + reversed;
		}
		return reversed;
	}
}
