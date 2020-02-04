/* SELF ASSESSMENT 
   1. Did I use appropriate CONSTANTS instead of numbers within the code? 
       Mark out of 5: 5
       Comment: i had to reuse 13 as it is the total amount of cards, limit of attempts was set to 20, and goal was 4
   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE? 
       Mark out of 5: 5
       Comment: easy to understand, 13 possible cards, 20 attempts, 4 correct answers
   3. Did I use easy-to-understand meaningful variable names? 
       Mark out of 10: 10
       Comment:  variables are easy to understand
   4. Did I format the variable names properly (in lowerCamelCase)? 
       Mark out of 5: 5
       Comment:  yes
   5. Did I indent the code appropriately? 
       Mark out of 10: 10
       Comment:  all of it is indented properly
   6. Did I use an appropriate loop to allow the user to enter their guesses until they win or lose? 
       Mark out of 20:  20
       Comment:  i used a while loop to keep going until the user wins
   7. Did I check the input to ensure that invalid input was handled appropriately? 
       Mark out of 10: 10
       Comment:  if anything other than higher, lower, or equal is entered the game will restart
   8. Did I generate the cards properly using random number generation (assuming all cards are equally likely each time)? 
       Mark out of 10: 10
       Comment:  yes i used random. all equally possible
   9. Did I output the cards correctly as 2, 3, 4, ... 9, 10, Jack, Queen, King? 
       Mark out of 10: 10
       Comment:  used an if statement for the picture cards
   10. Did I report whether the user won or lost the game before the program finished? 
       Mark out of 10: 10
       Comment:  the user has 10 tries until they fail or guess correctly 4 times in a row to win
   11. How well did I complete this self-assessment? 
       Mark out of 5: 5
       Comment:  assessed honestly
   Total Mark out of 100 (Add all the previous marks): 100
*/
import java.util.Random;
import java.util.Scanner;

public class HighLowCardGame {
	public static final int NUMBER_OF_CARDS = 13;
	public static final int LIMIT_OF_ATTEMPTS = 20;
	public static final int CORRECT_ANSWER_TARGET = 4;

	public static void main(String[] args) {
		System.out.println("To win you must guess correctly 4 times in a row. You have 10 tries.");
		int correctCount = 0;
		int guessCount = 0;
		Random cardGenerator = new Random();
		int previousCard = cardGenerator.nextInt(NUMBER_OF_CARDS) + 2;
		while (correctCount < CORRECT_ANSWER_TARGET && guessCount < LIMIT_OF_ATTEMPTS) {
			if (previousCard == 11) {
				System.out.print("The card is a Jack.");
			} else if (previousCard == 12) {
				System.out.print("The card is a Queen.");
			} else if (previousCard == 13) {
				System.out.print("The card is a King.");
			} else if (previousCard == 14) {
				System.out.print("The card is an Ace.");
			} else {
				System.out.print("The card is a " + previousCard + ".");
			}
			System.out.println(" You have guessed" + " correctly " + correctCount + " times in a row\nDo you think the"
					+ " next card will be higher, lower or equal?");
			Scanner inputScanner = new Scanner(System.in);
			String positionGuess = inputScanner.next();
			int randomCard = cardGenerator.nextInt(NUMBER_OF_CARDS) + 2;
			if (randomCard > previousCard && positionGuess.equals("higher")) {
				correctCount++;
				guessCount++;
				previousCard = randomCard;
			} else if (randomCard < previousCard && positionGuess.equals("lower")) {
				correctCount++;
				guessCount++;
				previousCard = randomCard;
			} else if (randomCard == previousCard && positionGuess.equals("equal")) {
				correctCount++;
				guessCount++;
				previousCard = randomCard;
			} else {
				correctCount = 0;
				previousCard = randomCard;
				System.out.println("Fail.");
				guessCount++;
			}
		}
		if (correctCount == CORRECT_ANSWER_TARGET) {
			System.out.println("\nCongratulations. You got them all correct.");
		} else {
			System.out.println("You have run out of tries.");
		}
	}
}