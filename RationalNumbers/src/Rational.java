/* SELF ASSESSMENT 

Class Retional 
I declared two member variables: numerator and denominator (marks out of 4: 4).
Comment: private int variables numerator and denominator

Constructor 1 
My program takes take two integers as parameters (for numerator and denominator) and initialises the member variables with the corresponding values . If the denominator is equal to 0 I throw an exception (marks out of 5: 5).
Comment: takes 2 parameters and initializes the member variables. throws exception if denominator is zero

Constructor 2 
My program takes only one integer as parameter (numerator), and set the numerator to this value . I set the denominator to 1 in this case, as the resulting rational number in this case is an integer (marks out of 3: 3).
Comment: only takes one parameter, the numerator. set denominator to 1.

Add Method 
My program takes only a rational number as a parameter and returns a new rational number which has a numerator and denominator which the addition of the two objects - this and the parameter. My program does not overwrite any of the other two rational numbers (marks out of 8: 8).
Comment: My program takes only a rational number as a parameter and returns a new rational number which has a numerator and denominator which the addition of the two objects - this and the parameter. My program does not overwrite any of the other two rational numbers 

Subtract Method 
I have implemented this the same as add method, except it implements subtraction (marks out of 8: 8).
Comment:  same as add but implements subraction

Multiply Method 
I have implemented this the same as add method, except it implements multiplication (marks out of 8:8 ).
Comment: same as add but implements multiplicaton

Divide Method 
I have implemented this the same as add method, except it implements divide (marks out of 8: 8).
Comment: same as add but implements division

Equals Method 
My program takes a rational number as a parameter and compares it to the reference object. I only use multiplication between numerators/denominators for the purpose of comparison, as integer division will lead to incorrect results. I return a boolean value ((marks out of 8: 8).
Comment: takes rational, compares and returns a boolean

isLessThan 
My program takes a rational number as a parameter and compares it to the reference object. I only use multiplication as integer division will lead to incorrect results. I return a boolean value (marks out of 8: 8).
Comment: takes rational, compares and returns a boolean

Simplify Method 
My program returns a rational number but not a new rational number, instead it returns the current reference which is this. It doesn't take any parameters as it works only with the reference object. I first find the greatest common divisor (GCD) between the numerator and denominator, and then obtain the new numerator and denominator by dividing to the GCD (marks out of 8: 8).
Comment: void type, use the gcd() function, then divide by gcd to simplify

gcd function 
My program returns the greatest common divider of two integers: the numerator and the denominator (marks out of 6:6 ).
Comment: uses a for loop to find gcd

toString Method 
My program returns a string showing the fraction representation of the number, eg. "1/2". It takes no parameters (marks out of 4: 4).
Comment: returns string with no parameters

Test Client Class 
My program asks the user for two rational numbers, creates two rational objects using the constructor and passing in the provided values, calls addition, subtraction, multiplication, division, comparison and simplification and prints out the results (marks out of 22: 22 ).
Comment: asks for 2 rational numbers, creates 2 rational objects, calls all the function. if denominator is 0 it will ask for a new set of rational numbers.
*/

public class Rational {
	private int numerator;
	private int denominator;

	Rational(int a, int b) {
		if (b != 0) {
			numerator = a;
			denominator = b;
		} else {
			System.out.println("Error, denominator cannot equal 0.");
		}
	}

	Rational(int a) {
		numerator = a;
		denominator = 1;
	}

	public Rational add(Rational number) {
		int bottom = denominator * number.denominator;
		int top = numerator * number.denominator;
		int top1 = denominator * number.numerator;
		int finalTop = top1 + top;
		Rational sum = new Rational(finalTop, bottom);
		return sum;

	}

	public Rational subtract(Rational number) {
		int bottom = denominator * number.denominator;
		int top = numerator * number.denominator;
		int top1 = number.numerator * denominator;
		int finalTop = top - top1;
		Rational subtraction = new Rational(finalTop, bottom);
		return subtraction;
	}

	public Rational multiply(Rational number) {
		int bottom = denominator * number.denominator;
		int top = numerator * number.numerator;
		Rational multiply = new Rational(top, bottom);
		return multiply;
	}

	public Rational divide(Rational number) {
		int bottom = denominator * number.numerator;
		int top = numerator * number.denominator;
		Rational divide = new Rational(top, bottom);
		return divide;
	}

	public boolean equals(Rational number) {
		int top = numerator * number.denominator;
		int top1 = denominator * number.numerator;
		if (top1 == top) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isLessThan(Rational number) {
		int top = numerator * number.denominator;
		int top1 = denominator * number.numerator;
		if (top1 < top) {
			return true;
		} else {
			return false;
		}
	}

	public void simplify() {
		int greatestCommonDivisor = gcd();
		if (greatestCommonDivisor != 0) {
			numerator = numerator / greatestCommonDivisor;
			denominator = denominator / greatestCommonDivisor;
		} else {
			numerator = 0;
		}
	}

	public int gcd() {
		int gcd = 0;
		for (int i = 1; i <= numerator || i <= denominator; i++) {
			if (numerator % i == 0 && denominator % i == 0) {
				gcd = i;
			}
		}
		return gcd;
	}

	public String toString() {

		String rationalString = (denominator != 1) ? numerator + "/" + denominator : numerator + "";
		return rationalString;
	}
	
}
