/*
import java.util.Scanner;

public class factorList {
	public static void main(String[] args) {
		System.out.print("Please enter a positive whole number: ");
		Scanner numberScanner = new Scanner(System.in);
		if (numberScanner.hasNextInt()) {
			int inputNumber = numberScanner.nextInt();
			int factor = inputNumber;
			int count = 0;
			System.out.print("The factors of " + inputNumber + " are ");
			if (inputNumber > 0) {
				for (int divisor = 1; divisor <= inputNumber && divisor <= factor; divisor++) {
					factor = inputNumber / divisor;
					if (inputNumber % divisor == 0) {
						System.out.print(divisor + "x" + factor + " ");
						count++;
					}
				}
				if (count == 1) {
					System.out.print("\n" + inputNumber + " is a prime number");
				} else {
					System.out.print("\n" + inputNumber + " is not a prime number");
				}
			} else {
				System.out.print("Error. Please enter a valid number");
			}
		} else {
			System.out.print("Error please enter a valid number: ");
		}
		numberScanner.close();
	}
}
*/
import java.util.Scanner;

public class factorList {
	public static void main(String[] args) {
		boolean finished = false;
		while (!finished) {
			System.out.print("Please enter a positive whole number (or enter 'quit'): ");
			Scanner numberScanner = new Scanner(System.in);
			if (numberScanner.hasNextInt()) {
				int inputNumber = numberScanner.nextInt();
				int factor = inputNumber;
				int count = 0;
				System.out.print("The factors of " + inputNumber + " are ");
				if (inputNumber > 0) {
					for (int divisor = 1; divisor <= inputNumber && divisor <= factor; divisor++) {
						factor = inputNumber / divisor;
						if (inputNumber % divisor == 0) {
							System.out.print(divisor + "x" + factor + " ");
							count++;
						}
					}
					if (count == 1) {
						System.out.print("\n" + inputNumber + " is a prime number\n");
					} else {
						System.out.print("\n" + inputNumber + " is not a prime number\n");
					}
				} else {
					System.out.print("Error. Please enter a valid number\n");
				}
			} else if (numberScanner.hasNext("quit")) {
				finished = true;
				numberScanner.close();
				System.out.print("Goodbye");
			} else {
				System.out.print("Error. Please enter a valid number.\n");
			}
		}
	}
}