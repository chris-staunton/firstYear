/* SELF ASSESSMENT 

1. ResolveBet

I have correctly defined ResolveBet which takes the bet type (String) and the Wallet object, and a void return type [Mark out of 7:7 ].
Comment: I correctly defined ResolveBet, takes betType and playersWallet, and returns void
My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet [Mark out of 8:8 ].
Comment: Prints amount in wallet and asks how much player wants to bet
My program ensures the bet amount is not greater than the cash in the wallet [Mark out of 5: 5].
Comment: I used the wallet method get to check sufficient cash in wallet.
My program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned [Mark out of 15: 15]..
Comment: My program creates 3 dice objects, rolls them and used diceSum for total
My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet [Mark out of 20: 20].
Comment: i used an if statement to award the appropriate winnings
My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses [Mark out of 10:10 ].
Comment: My program outputs the results and adds or subtracts the bet.

2. Main

I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it [Mark out of 15: 15]
Comment: The program starts with asking the user to enter starting money once, creates a wallet and puts the cash in
My program loops continuously until the user either enters quit or the cash in the wallet is 0 [Mark out of 5:5 ]
Comment: Loops until user tries to bet with no money or enters quit
I ask the user to enter any of the four bet types or quit [Mark out of 5: 5].
Comment: I present the bet types, and ask user to enter bet type or quit
My program calls resolveBet for each bet type entered [Mark out of 5: 5].
Comment: resolveBet is called after bet type entered
At the end of the game my program presents a summary message regarding winnings and losses [Mark out of 5:5 ]
Comment: when game is over my program presents a summary message.

 Total Mark out of 100 (Add all the previous marks): 100
*/
import java.util.Scanner;

public class ChuckALuck {
	public static void resolveBet(String betType, Wallet playersWallet) {
		Scanner betScanner = new Scanner(System.in);
		System.out.println("Money in wallet: " + playersWallet.check());
		System.out.println("how much money would you like to bet?: ");
		if(betScanner.hasNextDouble()) {
			double betAmount = betScanner.nextDouble();
			if (playersWallet.get(betAmount)) {
				Dice[] diceArray = new Dice[3];
				int diceSum = 0;
				for(int index = 0; index<diceArray.length; index++) {
					diceArray[index] = new Dice();
					diceArray[index].roll();
					System.out.println(diceArray[index].toString());
					diceSum += diceArray[index].topFace();
				}
				System.out.println("Total = " + diceSum);
				if((betType.equals("Triple")) && (diceArray[0].topFace() == diceArray[1].topFace())
						&&(diceArray[0].topFace() == diceArray[2].topFace()) && 
						(diceArray[0].topFace()!=1) && diceArray[0].topFace()!=6) {
					betAmount *= 30;
					playersWallet.put(betAmount);
					System.out.println("You Won!");
				}
				else if (betType.equals("Field") && (diceSum < 8 && diceSum > 12)) {
					betAmount*=2;
					playersWallet.put(betAmount);
					System.out.println("You Won!");
				}
				else if(betType.equals("High") && (diceSum > 10) && !((diceArray[0].topFace() == diceArray[1].topFace())
						&&(diceArray[0].topFace() == diceArray[2].topFace()))) {
					betAmount*=2;
					playersWallet.put(betAmount);
					System.out.println("You Won!");
				}
				else if (betType.equals("Low") && (diceSum < 11) && !((diceArray[0].topFace() == diceArray[1].topFace())
						&&(diceArray[0].topFace() == diceArray[2].topFace()))) {
					betAmount*=2;
					playersWallet.put(betAmount);
					System.out.println("You Won!");
				}
				else {
					System.out.println("You Lost!");
				}
				System.out.println("Money in wallet: " + playersWallet.check());
			}
			else {
			System.out.println("Non-sufficient funds.");
				if(playersWallet.check()<=0) {
					System.out.println("You have ran out of money, please quit.");
				}
			}
		}
		else {
			System.out.println("Error, please enter valid input.");
		}
	}
	public static void main(String[] args) {
		String betType = "";
		Scanner inputScanner = new Scanner(System.in);
		Wallet playersWallet = new Wallet();
		boolean finished = false;
		System.out.println("Enter amount of money to place in wallet: ");
		double money = inputScanner.nextDouble();
		playersWallet.put(money);
		try {
			while(!finished) {
				System.out.println("Bet options are: Triple, Field, High or Low.\nPlease enter your bet type(or enter quit): ");
				if (inputScanner.hasNext("quit") || playersWallet.check()==0) {
					finished = true;
					System.out.println("Game over, summary message: ");
				}
				else if (inputScanner.hasNextDouble()) {
					System.out.println("Error, please enter valid input.");
					inputScanner.next();
				}
				else{
				betType = inputScanner.next();
				resolveBet(betType, playersWallet);
				}
			}
			inputScanner.close();
			System.out.println("Start Money: " + money + 
					"\nFinish Money: " + playersWallet.check());
			System.out.println("Earnings = " + (playersWallet.check()-money));
		}
		catch(Exception InputMismatchException) {
			System.out.println("Error, please enter valid input.");
			inputScanner.next();
		}
	}
	
}
