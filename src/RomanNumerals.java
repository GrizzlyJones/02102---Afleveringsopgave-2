//	This program translates user input from arabic to roman numerals.
//	Roman numerals are alphabetical and only defined 1-3999.

import java.util.Scanner;

public class RomanNumerals {
	public static void main(String[] args) {
		int num = input(new Scanner(System.in));
		System.out.println(num + " = " + toRoman(num));
	}

	// Translates arabic to roman numeral
	// Pre : Int 1-3999
	// Post: String
	public static String toRoman(int num) {
		if (num <= 0 || num >= 4000) {
			throw new IndexOutOfBoundsException("Number must be between 1 and 3999");
		}
		String roman = "";
		
		roman += intToRoman(num/1000, "M");
		
		num %= 1000;
		roman += intToRoman(num/100, "C", "D", "M");
		
		num %= 100;
		roman += intToRoman(num/10, "X", "L", "C");
		
		num %= 10;
		roman += intToRoman(num, "I", "V", "X");
		
		return roman;
	}

	// Asks user for input, and ensures the validity of the input
	// Pre : Scanner object
	// Post: Int
	public static int input(Scanner console) {
		System.out.print("Enter positive integer to convert: ");
		if (console.hasNextInt()) {
			return console.nextInt();
		} else {
			throw new IllegalArgumentException("Not a valid input");
		}
	}
	
	// Translates a single digit to roman number
	// Pre : Int digit to be translated, String letter that indicates 1,
	//		 String letter that indicates 5, String letter that indicates 10
	// Post: String ruman number
	public static String intToRoman(int i, String one, String five, String ten) {
		String num = "";
		if (i <= 3) {
			num = repeat(one, i);
		} else if (i == 4) {
			num = one;
			num += five;
		} else if (i <= 8) {
			num = five;
			num += repeat(one, i%5);
		} else {
			num = one;
			num += ten;
		}
		return num;
	}
	
	// Translates a single digit to roman number
	// Pre : Int digit to be translated, String letter that indicates 1
	// Post: String ruman number
	public static String intToRoman(int i, String one) {
		String num = "";
		if (i <= 3) {
			num = repeat(one, i);
		}
		return num;
	}
	
	// Repeats a char N times
	// Pre : Char character to be repeated, Int number of repetitions
	// Post: String with chaeacter repeated N times.
	public static String repeat(String ch, int N) {
		String rep = "";
		for (int i = 0; i < N; i++) {
			rep += ch;
		}
		return rep;
	}
}
