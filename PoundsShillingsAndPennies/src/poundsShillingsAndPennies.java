/*  SELF ASSESSMENT
   1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 10:   10
   2. Did I use easy-to-understand, meaningful CONSTANT names?
       Mark out of 5:  5
    3. Did I format the CONSTANT names properly (in UPPERCASE)?
       Mark out of 5:  5
   4. Did I use easy-to-understand meaningful variable names?
       Mark out of 10:  10
   5. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 10:  10
   6. Did I indent the code appropriately?
       Mark out of 10:  10
   7. Did I read the input correctly from the user using (an) appropriate question(s)?
       Mark out of 10:  5
   8. Did I compute the answer correctly for all cases?
       Mark out of 20:  20
   9. Did I output the correct answer in the correct format (as shown in the examples)?
       Mark out of 10:  10
   10. How well did I complete this self-assessment?
       Mark out of 10:  10
   Total Mark out of 100 (Add all the previous marks):  95
*/
import java.util.Scanner;
import java.lang.Math;

public class poundsShillingsAndPennies {
	
	public static final double POUNDS_INFLATION_RATE = 160.80;
	public static final double SHILLINGS_INFLATION_RATE = 8.04;
	public static final double PENNIES_INFLATION_RATE = 0.67;
	
	public static void main(String[] args) {
		
		Scanner inputScanner = new Scanner(System.in);
		System.out.print("Enter amount of old pounds: ");
		int oldPounds = inputScanner.nextInt();
		System.out.print("Enter amount of old shillings: ");
		int oldShillings = inputScanner.nextInt();
		System.out.print("Enter amount of old pennies: ");
		int oldPennies = inputScanner.nextInt();
		inputScanner.close();
		
		double totalSterling = (oldPounds * POUNDS_INFLATION_RATE) +
				(oldShillings * SHILLINGS_INFLATION_RATE) + (oldPennies * PENNIES_INFLATION_RATE);		
		
		double totalSterlingRounded = Math.round(totalSterling * 100.0) / 100.0;
		System.out.print(oldPounds + " old pound(s), " + oldShillings + " old shilling(s) and " 
		+ oldPennies + " old pence = £" + totalSterlingRounded);
		
	}

}
