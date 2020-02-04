import java.util.Scanner;

public class RecursionFactorial {
	public static int computeFactorial(int number)
	{
		int result = 1;
		if (number > 0)
			result = (number * computeFactorial(number - 1));
			return result;
	}
	public static boolean isFactorian(int number)
	{
		int factorial = 1;
		int numberDigits = number;
		if (numberDigits > 0 && numberDigits < 10)
		{
			factorial = computeFactorial(numberDigits);
			int sum = factorial;
		}
		else
		{
			int remainder = numberDigits % 10;
		}
		return true;
	}
	public static void main(String [] args)
	{
		System.out.print("Enter your number: ");
		Scanner inputScanner = new Scanner(System.in);
		int number = inputScanner.nextInt();
		System.out.print(computeFactorial(number));		
	}
}
