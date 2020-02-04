/* SELF ASSESSMENT  
   1.  createSequence:
Did I use the correct method definition?
Mark out of 5: 5
Comment: i used the correct method definition
Did I create an array of size n (passed as the parameter) and initialise it?
Mark out of 5: 5
Comment: i created an array of size n-1 as the value 1 is never used. It is intialised.
Did I return the correct item?
Mark out of 5: 5
Comment: My function returns an array of all the numbers between 2 and including n
   2.  crossOutMultiples
Did I use the correct method definition?
Mark out of 5: 5
Comment: i used the correct method definition
Did I ensure the parameters are not null and one of them is a valid index into the array
Mark out of 2: 2
Comment: i caught the error of invalid index in the main method. I used an if statement to catch null array
Did I loop through the array using the correct multiple?
Mark out of 5: 5
Comment: the correct multiple is used.
Did I cross out correct items in the array that were not already crossed out?
Mark out of 3: 3
Comment: if a higher multiple was not crossed out already, it will be crossed out.
   3.  sieve   
Did I have the correct function definition?
Mark out of 5: 5
Comment: I used the correct function definition
Did I make calls to other methods?
Mark out of 5: 5
Comment:      i called the crossOutHigherMultiple and the create sequence functions
Did I return an array with all non-prime numbers are crossed out?
Mark out of 2: 2
Comment: all non primes are replaced with 0, the array is returned
   4.  sequenceTostring  
Did I have the correct function definition?
Mark out of 5: 5
Comment: i used the correct function definition
Did I ensure the parameter to be used is not null?
Mark out of 3: 3
Comment: i ensured the parameter is not null
Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets? 
Mark out of 10: 10
Comment:    i looped around updating the sequence string with primes and non primes encased with brackets
   5.  nonCrossedOutSubseqToString  
Did I have the correct function definition
Mark out of 5: 5
Comment:        I used the correct function definition
Did I ensure the parameter to be used is not null?  
Mark out of 3: 3
Comment: i ensured the parameter is not null
Did I loop through the array updating the String variable with just the non-crossed out numbers? 
Mark out of 5: 5
Comment: only primes are added to the string.
   6.  main  
Did I ask  the user for input n and handles input errors?  
Mark out of 5: 5
Comments: asked for appropriate input and handled input errors with users being asked to input a valid value.
Did I make calls to other methods (at least one)?
Mark out of 5: 5
Comment:  I called the sieve method which called the necessary methods such as createSequence and the print functions
Did I print the output as shown in the question?  
Mark out of 5: 5
Comment:  output is printed as shown in the question. The sequence is only printed if there is a change (new number crossed out)
   7.  Overall
Is my code indented correctly?
Mark out of 4: 4
Comments: my code is indented correctly, it is easy to follow
Do my variable names make sense?
Mark out of 4: 4
Comments: all variable names make sense
Do my variable names, method names and class name follow the Java coding standard
Mark out of 4: 4
Comments: They all follow the java coding standard
      Total Mark out of 100 (Add all the previous marks):  100 
*/

import java.util.Scanner;

public class SieveOfEratosthenes {
	public static final int START_NUMBER = 2;
	public static int[] createSequence(int number) {
		int[] numberSequence = new int[(number-1)];
		int arrayIndex = 0;
		for(int index = START_NUMBER; index <= number; index++)
		{
			numberSequence[arrayIndex] = index;
			arrayIndex++;
		}
		System.out.println(sequenceToString(numberSequence));
		return numberSequence;
	}
	public static int[] crossOutHigherMultiples(int[] numbers, int numberForCrossOut) {
		int[] numberSequence = numbers.clone();
		boolean finished = false;
		if (numberSequence!=null)
		{
			for(int index = 0; index<numberSequence.length&&!finished; index++)
			{
				if ((numberSequence[index]== 0)&& index + START_NUMBER == numberForCrossOut)
				{
					finished = true;
				}
				else if (numberSequence[index]/numberForCrossOut == 1) {
				} 
				else if(numberSequence[index]%numberForCrossOut==0)
				{
					numberSequence[index] =0;
				}
			}
			if(!finished)
			{
				System.out.println(sequenceToString(numberSequence));
			}
		}
		return numberSequence;
	}
	public static int[] sieve(int naturalNumberN)
	{
		int[] numberSequence = createSequence(naturalNumberN);
		for (int index= START_NUMBER; index<=Math.sqrt(naturalNumberN); index++)
		{
			numberSequence = crossOutHigherMultiples(numberSequence, index);
		}
		return numberSequence;  
	}
	public static String sequenceToString(int[] numberSequence)
	{
		String numberSequenceString = "";
		if (numberSequence!=null)
		{
			for(int index = 0; index<numberSequence.length; index++)
			{
				int numberInSieve = index+START_NUMBER;
				if (numberSequence[index]==0)
				{
					numberSequenceString += "[" + numberInSieve + "]";
				}
				else 
				{
					numberSequenceString += numberInSieve;
				}
				numberSequenceString += ((numberInSieve<=numberSequence.length)? (", ") : (""));
			}
		}
		return numberSequenceString;
	}
	public static String nonCrossedOutSubseqToString(int[] sieve)
	{
		String numberSequenceString = "";
		if (sieve != null)
		{
			for(int index = 0; index<sieve.length; index++)
			{
				int numberInSieve = index+START_NUMBER;
				if (sieve[index]!=0)
				{
					numberSequenceString += numberInSieve;
					numberSequenceString += ((numberInSieve<sieve.length)? (", ") : (" "));
				}
			}
		}
		return numberSequenceString;
	}
	public static void main(String[] args) {
		boolean finished = false;
		Scanner inputScanner = new Scanner(System.in);
		while (!finished)
		{
			System.out.print("Enter int >= 2: ");
			if (inputScanner.hasNextInt())
			{
				int naturalNumberN = inputScanner.nextInt();		
				if (naturalNumberN<START_NUMBER)
				{
					System.out.println("Error, please enter a valid value.");
				}
				else
				{
					int[] sieve = sieve(naturalNumberN);
					System.out.println(nonCrossedOutSubseqToString(sieve));
					finished = true;
					inputScanner.close();
				}
			}
			else
			{
				System.out.println("Error, please enter a valid value.");
				inputScanner.next();
			}
		}
	}

}
