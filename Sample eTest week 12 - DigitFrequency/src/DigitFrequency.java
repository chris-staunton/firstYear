import java.util.Scanner;

public class DigitFrequency {
	public static final int NUMBER_OF_DIGITS = 10;
	public static void main(String [] args) {
		Scanner inputScanner = new Scanner(System.in);
		boolean finished = false;
		int[] frequencies = new int[NUMBER_OF_DIGITS];
		while (!finished)
		{
			System.out.print("Enter a number> ");
			if (inputScanner.hasNextInt())
			{
				int number = inputScanner.nextInt();
				countDigitFrequencies(number, frequencies);
				printDigitFrequencies(frequencies);
			}
			else if (inputScanner.hasNext("quit"))
			{
				finished = true;
				inputScanner.close();
				System.out.println("Goodbye :)");
			}
			else
			{
				System.out.println("Error. Please enter a valid number.");
				inputScanner.next();
			}
		}
	}
	public static void countDigitFrequencies( int number, int[] frequencies ) {
		int temp = 0;
		while (number > 0)
		{
			temp = number%10;
			frequencies[temp] ++;
			number /= 10;
		}
	}
	public static void printDigitFrequencies( int[] frequencies ) {
		System.out.print("Digit frequencies: ");
		for (int index = 0; index < frequencies.length; index++)
		{
			int number = index;
			int frequency = frequencies[index];
			if (frequencies[index] != 0)
			{
				System.out.print(number + "(" + frequency + ") ");
			}
		}
		System.out.print("\n");
	}
}