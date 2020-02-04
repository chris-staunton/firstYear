/* SELF ASSESSMENT

 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?

        Mark out of 5:  5, my variables are easy to understand and theyre formatted correctly
        
 2. Did I indent the code appropriately?

        Mark out of 5: 5, code is indented properly

 3. Did I write the initialiseHighScores function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 15:  15, initialiseHighScores has correct parameter, return type and it is invoked correctly (i think it might be more efficient
       to just skip this function and not use it)

 4. Did I write the printHighScores function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 15:  15, printHighScores function has correct parameters, return type, function body and it is invoked properly

 5. Did I write the higherThan function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 15:  15, the higherThan function is correct. takes value and array, returns boolean if value is higher than any of the values
       in the array. i used it in my insertScore function, if returns false i know the value needs to be placed at the end or not in the array
       at all.

 6. Did I write the insertScore function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:  20, my insertScore function is correct. takes a value and array. will place the value in the appropriate position.

 7. Did I write the main function body correctly (first asking for the number of scores to be maintained and then repeatedly asking for scores)?

       Mark out of 20: 20, i used a while loop to ask the user for new values continuously and to display the current high scores. 

 8. How well did I complete this self-assessment?

        Mark out of 5: 5, self-assessed honestly

 Total Mark out of 100 (Add all the previous marks): 100

*/ 
import java.util.Scanner;

public class HighScores {
	public static void main(String [] args) {
		Scanner inputScanner = new Scanner(System.in);
		System.out.print("Enter the amount of high scores you wish to maintain: ");
		int numberOfHighScores = inputScanner.nextInt();
		int[] highScores = initialiseHighScores(numberOfHighScores);
		boolean finished = false;
		while(!finished)
		{
			System.out.print("Enter your score(or enter 'quit'): ");
			if (inputScanner.hasNextInt())
			{
				int newScore = inputScanner.nextInt();
				highScores = insertScore(highScores, newScore);
				printHighScores(highScores);
			}
			else if (inputScanner.hasNext("quit"))
			{
				inputScanner.close();
				finished = true;
			}
			else
			{
				System.out.print("Error. Please enter valid number.\n");
				printHighScores(highScores);
				inputScanner.next();
			}
		}
	}
	public static int[] initialiseHighScores(int numberOfHighScores)
	{
		int[] initialisedHighScores = new int[numberOfHighScores];
		return initialisedHighScores;
	}
	public static void printHighScores(int[] highScores)
	{
		System.out.print("The high scores are ");
		for(int index = 0; index < highScores.length; index++)
		{
			int score = highScores[index];
			System.out.print(score + ", ");
		}
		System.out.print("\n");
	}
	public static boolean higherThan(int[] highScores, int newScore)
	{
		int index = 0;
		while (index < highScores.length)
		{
			if (newScore > highScores[index])
			{
				return true;
			}
			else
			{
				index++;
			}	
		}
		return false;
	}
	public static int[] insertScore(int[] highScores, int newScore) {
		boolean finished = false;
		int index = 0;
		int[] newHighScores = highScores.clone();
		if (higherThan(highScores, newScore)) 
		{
			for (int count = 0; count < newHighScores.length; count++) 
			{
				if (newScore > highScores[index] && !finished)
				{
					newHighScores[count] = newScore;
					finished = true;
				} 
				else 
				{
					newHighScores[count] = highScores[index];
					index++;
				}
			}
		} 
		else 
		{
			if (highScores[index] == 0)
			{
				System.arraycopy(highScores, 0, newHighScores, 0, highScores.length);
				newHighScores[highScores.length] = newScore;
			}
		}
		return newHighScores;
	}
}
	