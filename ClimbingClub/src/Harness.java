
public class Harness {
	private static final int MAXIMUM_NUM_OF_USES = 25;
	String make;
	int modelNumber;
	private int numberOfUses;
	private String safetyCheckInstructor;
	private boolean onLoan;
	private String clubMember;

	Harness(String make, int modelNumber, int numberOfUses, String safetyCheckInstructor, boolean onLoan,
			String clubMember) {
		this.make = make;
		this.modelNumber = modelNumber;
		this.numberOfUses = numberOfUses;
		this.safetyCheckInstructor = safetyCheckInstructor;
		this.onLoan = onLoan;
		this.clubMember = clubMember;
	}

	Harness(String make, int modelNumber, String safetyCheckInstructor) {
		this.make = make;
		this.modelNumber = modelNumber;
		this.numberOfUses = 0;
		this.safetyCheckInstructor = safetyCheckInstructor;
		this.onLoan = false;
		this.clubMember = null;
	}

	boolean checkHarness(String instructor) {
		if (!this.onLoan && instructor != null) {
			this.numberOfUses = 0;
			this.safetyCheckInstructor = instructor;
			return true;
		} else {
			System.out.println("Safety check failed!");
			return false;
		}

	}

	boolean isHarnessOnLoan() {
		if (this.onLoan) {
			return true;
		} else {
			return false;
		}
	}

	boolean canHarnessBeLoaned() {
		if (isHarnessOnLoan() || this.numberOfUses >= MAXIMUM_NUM_OF_USES) {
			return false;
		} else {
			return true;
		}
	}

	void loanHarness(String member) {
		if (canHarnessBeLoaned()) {
			this.clubMember = member;
			this.numberOfUses++;
			this.onLoan = true;
		}
	}

	void returnHarness() {
		if (this.onLoan) {
			this.onLoan = false;
			this.clubMember = null;
		}
	}

	public String toString() {
		String harnessDescription = "Model number:" + this.modelNumber + "\nMake: " + this.make + "\nNumber of uses: "
				+ this.numberOfUses + "\nName of last safety checker: " + this.safetyCheckInstructor;
		harnessDescription += "\nLoan Status: "
				+ ((isHarnessOnLoan()) ? ("On Loan\n" + "Loaned to: " + this.clubMember) : ("Not on Loan."));
		harnessDescription += ("\n---------------");
		return harnessDescription;
	}

}
