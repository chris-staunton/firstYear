import java.util.Scanner;

public class PolynomialRoots {
	public static void main(String[] args) {
		
		boolean finished = false;
		double aCoefficient = 0.0;
		double bCoefficient = 0.0;
		double cCoefficient = 0.0;
		while(!finished)
		{
			System.out.print("Enter the coefficients of your second order polynomial seperated by spaces"
					+ " (or enter quit): ");
			Scanner numberScanner = new Scanner(System.in);
			if (numberScanner.hasNextDouble())
			{
				aCoefficient = numberScanner.nextDouble();
				bCoefficient = numberScanner.nextDouble();
				cCoefficient = numberScanner.nextDouble();
				double firstRoot = ((bCoefficient * -1) + Math.sqrt(((bCoefficient * bCoefficient)
						- 4 * aCoefficient * cCoefficient))) / (2 * aCoefficient);
				double secondRoot = ((bCoefficient * -1) - Math.sqrt(((bCoefficient * bCoefficient)
						- 4 * aCoefficient * cCoefficient))) / (2 * aCoefficient);
				
				
				System.out.print("The roots of this equation are x =" + firstRoot
						+ " and x=" + secondRoot + "\n");
				
			}
			else if (numberScanner.hasNext("quit"))
			{
				finished = true;
				System.out.print("Goodbye");
				numberScanner.close();
			}
			else
			{
				System.out.print("Error. unknown input, please try again: ");
			}
		}
	}

}
