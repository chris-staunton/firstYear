import java.util.Scanner;

public class WeightConverter {
	public static final double OUNCE_TO_KILO_CONVERSION = 0.02834952;
	public static final double OUNCES_IN_A_POUND = 16;
	public static final double POUNDS_IN_A_STONE = 14;
	public static void main(String [] args) {
		boolean finished = false;
		Scanner inputScanner = new Scanner(System.in);
		
		while (!finished)
		{
			System.out.println("Enter the number of Stones, Pounds and Ounces seperated by spaces (or enter quit): ");
			if(inputScanner.hasNextInt())
			{
				int stones = inputScanner.nextInt();
				int pounds = inputScanner.nextInt();
				int ounces = inputScanner.nextInt();
				System.out.println(getFormattedWeightString(stones, pounds, ounces));
				System.out.println(convertToKilograms(stones, pounds, ounces));
			}
			else if (inputScanner.hasNext("quit"))
			{
				inputScanner.close();
				finished = true;
			}
			else
			{
				System.out.println("Error. Please enter valid values.");
				inputScanner.next();
			}
		}
	}
	public static double convertToKilograms(int stones, int pounds, int ounces) {
		double kilograms = 0;
		double ounceToKilograms = ounces * OUNCE_TO_KILO_CONVERSION;
		double poundsToKilograms = (pounds * OUNCES_IN_A_POUND) * OUNCE_TO_KILO_CONVERSION;
		double stonesToKilograms = ((stones * POUNDS_IN_A_STONE) * OUNCES_IN_A_POUND) * OUNCE_TO_KILO_CONVERSION;
		kilograms = ounceToKilograms + poundsToKilograms + stonesToKilograms;
		return kilograms;
	}
	public static String getFormattedWeightString(int stones, int pounds, int ounces) {
		String formattedWeightString = "";
		if (stones != 0)
		{
			formattedWeightString = stones + " stones";
			if (pounds != 0)
			{
				formattedWeightString = formattedWeightString + ", " + pounds + " pounds";
				if (ounces != 0)
				{
					formattedWeightString = formattedWeightString + ", " + ounces + " ounces";
				}
			}
		}
		else 
		{
			if (pounds != 0)
			{
				formattedWeightString = formattedWeightString + pounds + " pounds";
				if (ounces != 0)
				{
					formattedWeightString = formattedWeightString + ", " + ounces + " ounces";
				}
			}
			else
			{
				formattedWeightString = formattedWeightString + ounces + " ounces";
			}
		}
		return formattedWeightString;
	}

}
