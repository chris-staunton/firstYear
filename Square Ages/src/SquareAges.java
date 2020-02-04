/* SELF ASSESSMENT 
   1. Did I use appropriate CONSTANTS instead of numbers within the code?  
       Mark out of 5: 5
       Comment: 
   2. Did I use easy-to-understand, meaningful CONSTANT names? 
       Mark out of 5: 5
       Comment: 
   3. Did I format the CONSTANT names properly (in UPPERCASE)? 
       Mark out of 5: 5
       Comment: 
   4. Did I use easy-to-understand meaningful variable names? 
       Mark out of 10: 10
       Comment: 
   5. Did I format the variable names properly (in lowerCamelCase)? 
       Mark out of 10: 10
       Comment: 
   6. Did I indent the code appropriately? 
       Mark out of 10: 10
       Comment: 
   7. Did I use an appropriate for loop to test all possibilities?  There should be only one. 
       Mark out of 20:  20
       Comment: 
   8. Did I correctly check if people alive today were or could be alive in a year that is the square of their age in that year. 
       Mark out of 30:  30
       Comment: 
   9. How well did I complete this self-assessment? 
       Mark out of 5: 5
       Comment: 
   Total Mark out of 100 (Add all the previous marks): 100
*/

public class SquareAges {
	public static final int MAX_AGE = 123;
	public static final int LOWEST_YEAR = 1895;
	public static final int HIGHEST_YEAR = 2141;
	public static final int CURRENT_YEAR = 2018;
	public static void main(String[] args){
		
		int age = 0;
		int ageSquared = 0;
		int birthYear = ageSquared - age;
		for (age=0; age <= MAX_AGE; age++)
		{
			ageSquared = age * age;
			birthYear = ageSquared - age;
			if ((ageSquared >= LOWEST_YEAR) && (ageSquared 
					<= HIGHEST_YEAR) && ((CURRENT_YEAR - birthYear < MAX_AGE) 
					&& (birthYear <= CURRENT_YEAR)))
			System.out.print("\nPeople aged " + age + " years old in the year " + ageSquared + 
					" would fit in this phenomenon, as  the year " + ageSquared 
					+ " is the square of " + age + 
					".\nIt is possible that these people are alive today as they were born in the year " + birthYear);
		}	
	}
}
