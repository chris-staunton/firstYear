import java.util.Scanner;

public class MaxAndMin {
	public static void main(String[] args) {
		
		
		System.out.print("Enter your list of numbers seperated by spaces:");
		Scanner numberScanner = new Scanner(System.in);
		if(numberScanner.hasNextDouble())
		{
			double minimumNumber = numberScanner.nextDouble();
			double maximumNumber = minimumNumber;
			while (numberScanner.hasNextDouble())
			{
				double currentNumber = numberScanner.nextDouble();
				if (currentNumber < minimumNumber)
					minimumNumber = currentNumber;
				if (currentNumber > maximumNumber)
					maximumNumber = currentNumber;
			}
			System.out.print("The numbers you entered are between " + minimumNumber +
					" and " + maximumNumber);
		}
		else
		{
			System.out.print("Error. Incorrect input. Please try again.");
		}
		numberScanner.close();
	}

}
