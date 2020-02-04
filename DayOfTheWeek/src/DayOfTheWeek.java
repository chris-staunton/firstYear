/* SELF ASSESSMENT

 1. Did I use appropriate, easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE?

        Mark out of 5: 5
        Comment: all formatted correctly and are meaningful and easy to understand

 2. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?

        Mark out of 5: 5
        Comment:   all variables understandable and correctly formatted (exception for Y, i called that variable yearForComputation
        i'm not sure if my name is appropriate of if i should have left it as Y)
 3. Did I indent the code appropriately?

        Mark out of 5:  5
        Comment: indented correctly, easy to follow

 4. Did I define the required functions correctly (names, parameters & return type) and invoke them correctly?

       Mark out of 20: 20
        Comment:  all functions were defined correctly, including names, parameters and return type. They are invoked correctly

 5. Did I implement the dayOfTheWeek function correctly and in a manner that can be understood?

       Mark out of 20: 20
        Comment:  dayOfTheWeek function implemented correctly as it can be understood and it works.

 6. Did I implement the other functions correctly, giving credit for any code that you take from elsewhere?

       Mark out of 20: 20
        Comment:  other functions correctly implemented. Other functions taken from ValidDate.java program on blackboard.

 7. Did I obtain (and process) the input from the user in the correct format (dd/mm/yyyy), and deal with any invalid input properly?       
      Mark out of 10: 10
        Comment: input was obtained and processed correctly. useDelimiter("/") was used. invalid input dealt with by try/catch

 8. Does the program produce the output in the correct format (e.g. Monday, 25th December 2017)?

       Mark out of 10: 10
        Comment:  the program produces the output in the correct format.

 9. How well did I complete this self-assessment?

        Mark out of 5: 5
        Comment: self-assessed honestly

 Total Mark out of 100 (Add all the previous marks): 100

*/ 
import java.util.Scanner;
import javax.swing.JOptionPane;

public class DayOfTheWeek {
	public static final int DAYS_IN_APRIL_JUNE_SEPT_NOV = 30;
	public static final int DAYS_IN_FEBRUARY_NORMALLY = 28;
	public static final int DAYS_IN_FEBRUARY_IN_LEAP_YEAR = 29;
	public static final int DAYS_IN_MOST_MONTHS = 31;
	public static final int NUMBER_OF_MONTHS = 12;
	public static final int TWELVETH_MONTH = 12;
	public static final int ELEVENTH_MONTH = 11;
	public static final int TENTH_MONTH = 10;
	public static final int NINETH_MONTH = 9;
	public static final int EIGHTH_MONTH = 8;
	public static final int SEVENTH_MONTH = 7;
	public static final int SIXTH_MONTH = 6;
	public static final int FIFTH_MONTH = 5;
	public static final int FOURTH_MONTH = 4;
	public static final int THIRD_MONTH = 3;
	public static final int SECOND_MONTH = 2;
	public static final int FIRST_MONTH = 1;
	
	public static String numberEnding(int day)
	{
		switch (day%10)
		{
		case 1:
			return "st";
		case 2:
			return "nd";
		case 3:
			return "rd";
		default:
			return "th";
		}	
	}
	public static String monthName( int month)
	{
		switch(month)
		{
		case FIRST_MONTH:
			return "January";
		case SECOND_MONTH:
			return "February";
		case THIRD_MONTH:
			return "March";
		case FOURTH_MONTH:
			return "April";
		case FIFTH_MONTH:
			return "May";
		case SIXTH_MONTH:
			return "June";
		case SEVENTH_MONTH:
			return "July";
		case EIGHTH_MONTH:
			return "August";
		case NINETH_MONTH:
			return "September";
		case TENTH_MONTH:
			return "October";
		case ELEVENTH_MONTH:
			return "November";
		case TWELVETH_MONTH:
			return "December";
		default:
			return "";
		}
	}
	public static String dayOfTheWeek(int day, int month, int year)
	{
		int yearForComputation = 0;
		switch (month)
		{
		case FIRST_MONTH:
		case SECOND_MONTH:
			yearForComputation = year - 1;
			break;
		default:
			yearForComputation = year;
		}
		int lastTwoDigitsOfYear = yearForComputation % 100;
		if(lastTwoDigitsOfYear > 100)
			lastTwoDigitsOfYear = lastTwoDigitsOfYear % 100;
		int firstTwoDigitsOfYear = (yearForComputation - lastTwoDigitsOfYear) / 100;
		
		double dayNumber = (day + Math.floor(2.6 * (((month + 9) % 12) + 1)
				- 0.2) + lastTwoDigitsOfYear + Math.floor(lastTwoDigitsOfYear/4) + Math.floor(firstTwoDigitsOfYear/4)
				- 2 * firstTwoDigitsOfYear) % 7;
		dayNumber = Math.abs(dayNumber);
		switch ((int)dayNumber)
		{
		case 0:
			return "Sunday";
		case 1:
			return "Monday";
		case 2:
			return "Tuesday";
		case 3:
			return "Wednesday";
		case 4:
			return "Thursday";
		case 5:
			return "Friday";
		case 6:
			return "Saturday";
		default:
			return "";
		}
	}
	//taken from ValidDate.java program on blackboard.
	public static boolean validDate( int day, int month, int year)
	{
		return ((year >= 0) && (month >= 1) && (month <= NUMBER_OF_MONTHS) &&
				(day >= 1) && (day <= daysInMonth( month, year )));
	}
	//taken from ValidDate.java program on blackboard.
	public static int daysInMonth( int month, int year )
	{
		int numberOfDaysInMonth = DAYS_IN_MOST_MONTHS;
		switch (month)
		{
		case SECOND_MONTH:
			numberOfDaysInMonth = isLeapYear( year ) ? DAYS_IN_FEBRUARY_IN_LEAP_YEAR :
				                                       DAYS_IN_FEBRUARY_NORMALLY;
			break;
		case FOURTH_MONTH:
		case SIXTH_MONTH:
		case NINETH_MONTH:
		case ELEVENTH_MONTH:
			numberOfDaysInMonth = DAYS_IN_APRIL_JUNE_SEPT_NOV;
			break;
		default:
			numberOfDaysInMonth = DAYS_IN_MOST_MONTHS;
			break;
		}
		return numberOfDaysInMonth;
	}
	// taken from ValidDate.java program on blackboard.
	public static boolean isLeapYear( int year )
	{
		return (((year%4 == 0) && (year%100 != 0)) || (year%400 == 0));
	}
	public static void main(String [] args){
		try
		{
			String input = JOptionPane.showInputDialog("Enter date (day/month/year):");
			Scanner inputScanner = new Scanner( input );
			inputScanner.useDelimiter("/");
			int day = inputScanner.nextInt();
			int month = inputScanner.nextInt();
			int year = inputScanner.nextInt();
			if(validDate(day, month, year))
			{
				JOptionPane.showMessageDialog(null, dayOfTheWeek(day, month, year) + ", "
						+ day + numberEnding(day) + " " + monthName(month) + " " + year);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid date", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		catch (NullPointerException exception)
		{
		}
		catch (java.util.NoSuchElementException exception)
		{
			JOptionPane.showMessageDialog(null, "No number entered.", "Error", 
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
