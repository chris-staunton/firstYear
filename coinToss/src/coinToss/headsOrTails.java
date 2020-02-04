package coinToss;
import java.util.Random;
public class headsOrTails {
	public static final int TAILS = 0;
	public static final int HEADS = 1;
	public static final int MAX_NUMBER = 10000;
	
	public static void main(String[] args) {	
		int toss = 0;
		int numberOfTails = 0;
		int numberOfHeads = 0;
		String lastToss = "Tails";
		Random generator = new Random();
		for (toss = 0; (toss < MAX_NUMBER); toss++)
		{
			int randomNumber = generator.nextInt(2);
			if (randomNumber == TAILS)
			{
				lastToss = "Tails";
				numberOfTails++;
			}
			else
			{
				lastToss = "Heads";
				numberOfHeads++;
			}
		}	
		System.out.print("There were " + numberOfHeads + " Heads and " 
				+ numberOfTails + " Tails." + "\nThe last toss was " + lastToss);
	}
}

