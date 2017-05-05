import java.util.Scanner;

public class BuffonsNeedle {
	public static void main(String[] args) {
		int iter = input(new Scanner(System.in));
		int succes = sim(iter);
		double pi = (double) iter / succes;
		System.out.println(iter + "/" + succes + " = " + pi);
	}

	public static int sim(int iter) {
		int N = 0, t = 2;
		double bot, top, theta;
		for (int i = 0; i < iter; i++) {
			bot = Math.random() * t;
			theta = Math.random() * 180;
			top = bot + Math.sin(Math.toRadians(theta));
			if (top > t) {
				N++;
			}
		}
		if (N == 0) {
			throw new IllegalArgumentException("Too few iterations.");
		}
		return N;
	}

	public static int input(Scanner console) {
		System.out.print("Enter number of iterations: ");
		if (console.hasNextInt()) {
			return console.nextInt();
		} else {
			throw new IllegalArgumentException("Not a valid input");
		}
	}
}
