import java.util.Scanner;

public class ValidDates {
	public static boolean validDate( int year, int month, int day)
	{
	if((isLeapYear(year)) && (month == 2) && (day > 29))
	{
		return false;
	}
	else if ((day > daysInMonth(month, year)))
	{
		return false;
	}
	else
	{
		return false;
	}
	}
	public static int daysInMonth(int month, int year)
	{
		if((isLeapYear(year)) && (month == 2))
		{
			return 29;
		}
		else if ((month == 9) || (month == 4) || (month == 6) || (month == 11))
		{
			return 30;
		}
		else
		{
			return 31;
		}
	}
	public static boolean isLeapYear(int year)
	{
		if(((year%400 == 0) || (year%4 == 0)) && (year%100 != 0))
		{
		return true;
		}
	return false;
	}	
	public static void main(String [] args) {
		System.out.print("Enter your numbers");
		Scanner inputScanner = new Scanner(System.in);
		int day = inputScanner.nextInt();
		int month = inputScanner.nextInt();
		int year = inputScanner.nextInt();
		if (validDate(year, month, day))
		{
			System.out.print("this date is valid. Great success");
		}
		else
		{
			System.out.print("Not valid");
		}
	}

}
