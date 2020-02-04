import java.util.Scanner;

public class SportsCompetition {
	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		System.out.print("Enter number of competitors: ");
		if(inputScanner.hasNextInt()) 
		{
			int numberOfCompetitors = inputScanner.nextInt();
			String outputString = "Prizes should be given to the competitors who come 1st";
			for (int currentNumber = 2; currentNumber <= numberOfCompetitors; currentNumber++) 
			{
				boolean isPrime = true;
				for (int divisor = 2; ((divisor < currentNumber) && (isPrime)); divisor++) 
				{
					if (currentNumber % divisor == 0) 
					{
						isPrime = false;
					}
				}
				if (isPrime) 
				{
					outputString = outputString + ", " + currentNumber;
					if (((currentNumber % 100) / 10) == 1) 
					{
						outputString += "th";
					} 
					else 
					{
						switch (currentNumber % 10) 
						{
						case 1:
							outputString += "st";
							break;
						case 2:
							outputString += "nd";
							break;
						case 3:
							outputString += "rd";
							break;
						default:
							outputString += "th";
							break;
						}
					}
				}
			}
			System.out.print(outputString);
		}
		inputScanner.close();
	}
}
