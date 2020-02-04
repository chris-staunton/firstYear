/* SELF ASSESSMENT

 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?

        Mark out of 5:  5       Comment: I used easy to understand meaningful variable names which are formatted correctly.

 2. Did I indent the code appropriately?

        Mark out of 5: 5        Comment: i indented the code correctly.

 3. Did I write the determineStarNumber or determineTriangleNumber function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:   20       Comment: i wrote both determineStarNumber and determineTriangleNumber functions correctly in my code.
       								they take a single integer and return respective star or triangle values. 

 4. Did I write the isStarNumber function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:   20       Comment:  i wrote isStarNumber function correctly as it takes a number and returns a boolean 
       which shows if the input number is a star number or not.

 5. Did I calculate and/or check triangle numbers correctly?

       Mark out of 15:  15        Comment: yes. i used a while loop to calculate the triangle numbers

 6. Did I loop through all possibilities in the program using system defined constants to determine when to stop?

       Mark out of 10:      10    Comment:i used the system defined constat integer.MAX_VALUE to stop the values overflowing

 7. Does my program compute and print all the correct triangular star numbers?

       Mark out of 20: 20       Comment: all five triangle star numbers are outputted

 8. How well did I complete this self-assessment?

        Mark out of 5:   5     Comment: i assessed honestly

 Total Mark out of 100 (Add all the previous marks):

*/ 
public class TriangleStarNumbers {
	public static boolean isStarNumber(int possibleStarNumber) 
	{
		for (int index = 1; (index <= possibleStarNumber); index++) 
		{
			int starNumber = determineStarNumber(index);
			if (starNumber == possibleStarNumber) 
			{
				return true;
			} 
			else if (starNumber > possibleStarNumber || starNumber < 0 ) 
			{
				return false;
			}
		}
		return false;
	}
	
	public static int determineStarNumber(int index) 
	{
		int starNumber = ((6 * index) * (index - 1)) + 1;
		return starNumber;
	}

	public static int determineTriangleNumber(int triangleNumberIndex) 
	{
		int index = triangleNumberIndex;
		int triangleNumber = 0;
		boolean finished = false;
		while (!finished) 
		{
			if ((index >= 1) && (triangleNumber >= 0)) 
			{
				triangleNumber += index;
				index --;
				finished = false;

			} 
			else 
			{
				finished = true;
			}
		}
		return triangleNumber;
	}

	public static void main(String[] args) {
		int triangleNumber = 0;
		for (int index = 1; (triangleNumber < Integer.MAX_VALUE) && (triangleNumber >= 0); index++)
		{
			triangleNumber = determineTriangleNumber(index);
			if (isStarNumber(triangleNumber)) 
			{
				System.out.print(triangleNumber + "\n");
			}
		}
	}
}
