/* SELF ASSESSMENT

Harness Class: Member variables (8 marks)  8
All my data members are declared, private and the ones that don't change are marked as private. I also have a constant for the maximum number of uses of a harness.
Comment: all data members are declared, ones that dont change are private and constant for max num of uses		

Harness Class: Harness constructor 1 & constructor 2 (6 marks)  6
I initialise all the variables using the parameters given and set the other members to reasonable default values.
Comment: 2 constructors, one takes all the parameters and initialises the variables. the other only takes make, model number, and instructor name and sets numofuses to 0, onloan to false, and no clubmember

Harness Class: checkHarness method (5 marks)  5
My method takes an instructor's name as a parameter, and if the harness is not on loan sets the instructor member variable to the given parameter value (assuming the instructor's name is not null/empty). It also resets the number of times the harness was used.
Comment: my checkHarness takes instructor name, harness make and model. it will find the harness and reset the num of uses back to zero and update the safety instructor. this is only done if not on loan

Harness Class: isHarnessOnLoan method (2 marks)  2
My method has no parameters and returns the value of the loan status variable.
Comment: takes no parameters, returns true if on loan

Harness Class: canHarnessBeLoaned method (4 marks)  4
My method has no parameters and returns true if the harness is not on loan and if the number of times it was used is less than the maximum allowed number of times.
Comment: no parameters, returns true if num of uses less than max and it is not on loan

Harness Class: loanHarness method (6 marks)  6
My method has a member name as a parameter and it checks if harness can be loaned by using the canHarnessBeLoaned method. If true, it sets the club member value to the parameter value, sets the on loan status to true and increments the number of times used variable.
Comment: if harness can be loaned, sets clubMember from parameter and increases the num of uses by 1
 
Harness Class: returnHarness method (5 marks)  5
My method has no parameters, checks if the harness is on loan, and if so, changes its on-loan status to false, and resets the club member value.
Comment: no parameters, if on loan changes to false and club member to null

Harness Class: toString method (3 marks)  3
My method returns a String representation of all the member variables.
Comment: returns a string representation of all member values

HarnessRecords Class: member variables (3 marks)  3
I declare the member variable as a private collection of Harnesses 
Comment: harnessArray is a private static arrayList

HarnessRecords Class: HarnessRecords constructor 1 & 2 (9 marks)  9
In the first constructor, I set the member variable to null [1 mark]. In the second constructor, I use the set of characteristics in the list to create Harness objects and add them to the collection. 
Comment: first constructor, set to null. 2nd constructor, take in lists of the characeritics and cycle through, create harness objects and add them to the collection.

HarnessRecords Class: isEmpty method (1 marks)  1
I return true if the collection is null/empty and, false otherwise.
Comment: return true if empty

HarnessRecords Class: addHarness method (5 marks)  5 
My method takes a Harness object as a parameter and adds the harness to the collection.
Comment: takes harness object as parameter and adds it to collection

HarnessRecords Class: findHarness method (6 marks)  6
My method takes a make and model number as parameters. It checks if a harness with such properties exists and if it does it returns harness object, otherwise returns null.
Comment: make and model as parameters. check if exist and returns this object

HarnessRecords Class: checkHarness method (6 marks)   6
must take instructor name, make and model number as parameters and return a Harness. If a harness with the make and model number exists by using the findHarness method and is not on loan, the Harness method checkHarness is called with the instructor name as a parameter and the updated Harness object is returned. If the harness is not available returns null.
Comment: instructor, make and model as parameters. if harness exists and not on loan then call checkHarness method

HarnessRecords Class: loanHarness method (7 marks)  7
My method takes a club member name as a parameter and looks for an available harness by calling the method canHarnessBeLoaned be loaned. If an available harness is found it is loaned by using the Harness method loanHarness with the club member as a parameter, returning the harness. If there's no available harness null is returned.
Comment: club member as parameter and looks for available harness. if one is found it is loaned, munOfUses increase by 1 and the clubMember variable updated

HarnessRecords Class: returnHarness method (7 marks)   7
My method takes a make and model number as parameters. It checks if a harness with those properties exists by using the findHarness method. If the found harness is not null, it returns the harness object by using Harness method returnHarness, otherwise returns null.
Comment: make and model as parameters. if exists it will set on loan to false and club member to null

HarnessRecords Class: removeHarness method (8 marks)   8
My method takes a make and model number as parameters and check the collection for a harness with those properties and removes it. It returns the harness object if it is found, otherwise returns null.
Comment: make and model as parameters and removes harness with those values if it exists

GUI (Java main line) (5 marks)   5
My test class has a menu which implements at least the five points specified using the HarnessRecords class methods.
Comment: implements the five points and print option, through JOptionPane

*/



import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class ClimbingClubManagement {
	public static final int MAIN_MENU = 0;
	public static final int ADD_HARNESS = 1;
	public static final int RECORD_SAFETY_CHECK = 2;
	public static final int REMOVE_HARNESS = 3;
	public static final int LOAN_HARNESS = 4;
	public static final int RETURN_HARNESS = 5;
	public static void main(String args[]) {
		boolean useProgram=true;
		ArrayList<String> harnessMakes = new ArrayList<String>();
		ArrayList<Integer> harnessModelNumbers = new ArrayList<Integer>();
		ArrayList<String> harnessInstructors = new ArrayList<String>();
		ArrayList<Integer> harnessNumOfUses = new ArrayList<Integer>();
		ArrayList<Boolean> harnessLoanStatus = new ArrayList<Boolean>();
		ArrayList<String> harnessClubMembers = new ArrayList<String>();
		Scanner inputScan = new Scanner(System.in);
		String numberOfHarnesses = JOptionPane.showInputDialog("How many harnesses does the club currently own?: ");
		int numOfHarnesses = Integer.parseInt(numberOfHarnesses);
		int harnessCount = numOfHarnesses;
		while(harnessCount>0)
		{
			JTextField make = new JTextField();
			JTextField modelNumber = new JTextField();
			JTextField instructor = new JTextField();
			JTextField numOfUses = new JTextField();
			JTextField loanStatus = new JTextField();
			JTextField clubMember = new JTextField();
			Object[] message = 
			{
			    "Make:", make,
			    "Model Number:", modelNumber,
			    "Instructor:", instructor,
			    "Number of Uses:", numOfUses,
			    "On Loan?(true or false): ", loanStatus,
			    "Club Member Loaned to: ", clubMember
			    
			};
			int option = JOptionPane.showConfirmDialog(null, message, "Enter Existing Harness Details", 
					JOptionPane.OK_CANCEL_OPTION);
			if (option == JOptionPane.OK_OPTION) 
			{
				String harnessMake = make.getText();
				int harnessModel = Integer.parseInt(modelNumber.getText());
				String safetyInstructor = instructor.getText();
				int harnessUses = Integer.parseInt(numOfUses.getText());
				boolean onLoan = (loanStatus.getText().equals("true")?(true):(false));
				String loanClubMember = clubMember.getText();
				if(harnessMake!=null && safetyInstructor!=null)
				{
					harnessMakes.add(harnessMake);
					harnessModelNumbers.add(harnessModel);
					harnessInstructors.add(safetyInstructor);
					harnessNumOfUses.add(harnessUses);
					harnessLoanStatus.add(onLoan);
					harnessClubMembers.add(loanClubMember);
					harnessCount--;
				}
			}
		}
		HarnessRecords harnessCollection = new HarnessRecords(numOfHarnesses, harnessMakes, 
				harnessModelNumbers, harnessInstructors, harnessNumOfUses, harnessLoanStatus, harnessClubMembers);
		
		String[] firstOptions = {"Exit Program", "Use Harnesses", "View Current Harnesses"};
		String[] secondOptions = {"Main Menu", "Add Harness", "Record Safety Check", 
						"Remove Harness", "Loan Harness" ,"Return Harness"};
		while(useProgram) {
			int firstChoice = JOptionPane.showOptionDialog(null, "What would you like to do?", "Climbing Club"
					, JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, firstOptions, firstOptions[0]);
			
			if(firstChoice == 0)
			{
				useProgram = false;
			}
			else if(firstChoice == 2) {
				System.out.println("Harness Details in collection: ");
				harnessCollection.printHarnessRecords();
			}
			else if(firstChoice == 1) {
				int secondChoice = JOptionPane.showOptionDialog(null, "What would you like to do?", "Climbing Club"
						, JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, secondOptions, secondOptions[0]);
				
				if(secondChoice == 0) {
					
				}
				else if(secondChoice == ADD_HARNESS) {
					//add
					JTextField make = new JTextField();
					JTextField modelNumber = new JTextField();
					JTextField instructor = new JTextField();
					Object[] message = 
						{
						    "Make:", make,
						    "Model Number:", modelNumber,
						    "Instructor:", instructor
						};
					int option = JOptionPane.showConfirmDialog(null, message, "Enter Harness Details", 
							JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) 
					{
						String harnessMake = make.getText();
						int harnessModel = Integer.parseInt(modelNumber.getText());
						String safetyInstructor = instructor.getText();
						if(harnessMake!=null && safetyInstructor!=null)
						{
							Harness newHarness = new Harness(harnessMake, harnessModel, safetyInstructor);
							harnessCollection.addHarness(newHarness);
						}
						
						
					}
				
				}
				else if(secondChoice == RECORD_SAFETY_CHECK) {
					//safety check
					JTextField make = new JTextField();
					JTextField modelNumber = new JTextField();
					JTextField instructor = new JTextField();
					Object[] message = 
						{
									"Make:", make, 
									"Model Number:", modelNumber, 
									"Instructor:", instructor 
						};
					int option = JOptionPane.showConfirmDialog(null, message, "Enter Harness Details",
							JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
						String safetyInstructor = instructor.getText();
						String harnessMake = make.getText();
						int harnessModelNumber = Integer.parseInt(modelNumber.getText());
						harnessCollection.checkHarness(safetyInstructor, harnessMake, harnessModelNumber);
					}
				}
				else if(secondChoice == REMOVE_HARNESS) {
					//remove
					JTextField make = new JTextField();
					JTextField modelNumber = new JTextField();
					Object[] message = 
						{
						    "Make:", make,
						    "Model Number:", modelNumber
						};
					int option = JOptionPane.showConfirmDialog(null, message, "Enter Harness Details",
							JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
						String harnessMake = make.getText();
						int harnessModelNumber = Integer.parseInt(modelNumber.getText());
						harnessCollection.removeHarness(harnessMake, harnessModelNumber);
					}
				}
				else if(secondChoice== LOAN_HARNESS) {
					//loan
					String clubMember = JOptionPane.showInputDialog("Loan Harness to: ", "Name of Club Member");
					if(clubMember!=null) {
						harnessCollection.loanHarness(clubMember);
					}
				}
				else if(secondChoice == RETURN_HARNESS) {
					//return
					JTextField make = new JTextField();
					JTextField modelNumber = new JTextField();
					Object[] message = 
						{
						    "Make:", make,
						    "Model Number:", modelNumber
						};
					int option = JOptionPane.showConfirmDialog(null, message, "Enter Harness Details",
							JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
						String harnessMake = make.getText();
						int harnessModelNumber = Integer.parseInt(modelNumber.getText());
						harnessCollection.returnHarness(harnessMake, harnessModelNumber);
					}
				}
			}
		}
		inputScan.close();
	}
}
