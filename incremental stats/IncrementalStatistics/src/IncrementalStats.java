/* SELF ASSESSMENT 
   1. Did I use easy-to-understand meaningful variable names? 
       Mark out of 10: 10
       Comment: i believe i  used understandable variable names
   2. Did I format the variable names properly (in lowerCamelCase)? 
       Mark out of 5: 5
       Comment: all of my variables are named according to the coding standard
   3. Did I indent the code appropriately? 
       Mark out of 10: 10
       Comment: my code is indented correctly and easy to follow
   4. Did I input the numbers one at a time from the command line?
       Mark out of 10:  10
       Comment: the numbers are entered one at a time
   5. Did I check the input to ensure that invalid input was handled appropriately?
       Mark out of 10:  10
       Comment: i used an if function to check this
   6. Did I use an appropriate while or do-while loop to allow the user to enter numbers until they entered exit/quit?
       Mark out of 20:  20
       Comment: i used a do-while loop. it will ask for input until user enters 'exit'
   7. Did I implement the loop body correctly so that the average and variance were updated and output appropriately?
       Mark out of 30:  30
       Comment: count was placed first. average and variance were updated as they will be changed when the next input is
       entered if placed anywhere else.
   8. How well did I complete this self-assessment? 
       Mark out of 5: 5
       Comment: i self-assessed honestly
   Total Mark out of 100 (Add all the previous marks): 100
*/
import java.util.Scanner;

public class IncrementalStats {
	public static void main(String[] args){
		
		
		System.out.print("This program computes the average and "
				+ "variance of all numbers entered. \n" + 
				"Enter a number (or type 'exit'): ");
		
		double currentAverage = 0;
		double previousAverage = 0;
		double currentVariance = 0;
		double previousVariance = 0;
		int count = 0;
		boolean finished = false;
	
		do
		{
			Scanner numberScanner = new Scanner(System.in);
		
			if (numberScanner.hasNextDouble())
			{
				count++;
				double inputNumber = numberScanner.nextDouble();
				currentAverage = previousAverage + (inputNumber - previousAverage)/count;
				currentVariance = ((previousVariance * (count - 1)) + 
						(inputNumber - previousAverage)
						 * (inputNumber - currentAverage))/count;
				System.out.print( "\nSo far the average is " + currentAverage +
						" and the variance is " + currentVariance + "\nEnter another "
						+ "number (or type ' exit'): ");
				previousAverage = currentAverage;
				previousVariance = currentVariance;
			}
			else if (numberScanner.hasNext("exit"))
			{
				finished = true;
				System.out.print("Goodbye");
				numberScanner.close();
			}
			else
			{
				System.out.print("Error. Please Enter a valid input: ");
			}
		}while (!finished);
		
	}
}
