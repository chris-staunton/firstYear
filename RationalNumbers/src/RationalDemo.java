import java.util.Scanner;
public class RationalDemo {
	public static void main(String[] args) {
		int numerator = 0, numerator1 = 0;
		int denominator = 0, denominator1 = 0;
		boolean finished = false;
		Scanner inputScan = new Scanner(System.in);
		while (!finished) {
			System.out.println("Enter your rational number seperated by a space.");
			if (inputScan.hasNextInt()) {
				numerator = inputScan.nextInt();
				if (inputScan.hasNextInt()) {
					denominator = inputScan.nextInt();
				} else {
					System.out.println("Invalid input!");
				}
			} else {
				System.out.println("Invalid input!");
			}
			System.out.println("Enter your rational number seperated by a space.");
			if (inputScan.hasNextInt()) {
				numerator1 = inputScan.nextInt();
				if (inputScan.hasNextInt()) {
					denominator1 = inputScan.nextInt();
				} else {
					System.out.println("Invalid input!");
				}
			} else {
				System.out.println("Invalid input!");
			}
			if (denominator != 0 && denominator1 != 0) {
				Rational secondRational = new Rational(numerator1, denominator1);
				Rational firstRational = new Rational(numerator, denominator);
				firstRational.simplify();
				secondRational.simplify();
				System.out.println("Simplified first rational number: " + firstRational.toString() + "\n"
						+ "Simplified Second rational number: " + secondRational.toString());
				System.out.print("Comparison: ");
				if (firstRational.isLessThan(secondRational)) {
					System.out.println(secondRational.toString() + " is less than " + firstRational.toString());
				} else if ((firstRational.equals(secondRational))) {
					System.out.println(firstRational.toString() + " is equal to " + secondRational.toString());
				} else {
					System.out.println(secondRational.toString() + " is greater than " + firstRational.toString());
				}
				Rational addition = firstRational.add(secondRational);
				addition.simplify();
				System.out.println("Addition: " + addition.toString());
				Rational subtraction = firstRational.subtract(secondRational);
				subtraction.simplify();
				System.out.println("Subtraction: " + subtraction.toString());
				Rational multiply = firstRational.multiply(secondRational);
				multiply.simplify();
				System.out.println("Multiplication: " + multiply.toString());
				if(denominator!=0 && denominator1!=0) {
					Rational divide = firstRational.divide(secondRational);
					divide.simplify();
					System.out.println("Division: " + divide.toString());
				}
				else {
					System.out.println("Division: 0");
				}
				finished = true;
			} else {
				System.out.println("Denominator cannot equal zero.");
			}
		}
	}
}