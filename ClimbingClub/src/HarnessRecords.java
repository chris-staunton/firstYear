
import java.util.ArrayList;

public class HarnessRecords {
	private static ArrayList<Harness> harnessArray = new ArrayList<Harness>();

	HarnessRecords() {
		harnessArray = null;
	}

	HarnessRecords(int numberOfHarnesses, ArrayList<String> makes, ArrayList<Integer> modelNumbers,
			ArrayList<String> instructors, ArrayList<Integer> uses, ArrayList<Boolean> loanStatus,
			ArrayList<String> clubMembers) {
		for (int i = 0; i < numberOfHarnesses; i++) {
			String make = makes.get(i);
			int modelNumber = modelNumbers.get(i);
			String instructor = instructors.get(i);
			int numOfUses = uses.get(i);
			boolean onLoan = loanStatus.get(i);
			String clubMember = clubMembers.get(i);
			harnessArray.add(new Harness(make, modelNumber, numOfUses, instructor, onLoan, clubMember));
		}

	}

	boolean isEmpty() {
		if (harnessArray != null) {
			return false;
		} else {
			return true;
		}
	}

	void addHarness(Harness harness) {
		harnessArray.add(harness);
	}

	Harness findHarness(String make, int modelNumber) {
		Harness harness = null;
		for (int i = 0; i < harnessArray.size(); i++) {
			if ((harnessArray.get(i).modelNumber == modelNumber) && (harnessArray.get(i).make.equals(make))) {
				harness = harnessArray.get(i);
			}
		}
		return harness;
	}

	Harness checkHarness(String instructor, String make, int modelNumber) {
		Harness harness = findHarness(make, modelNumber);
		if (harness != null && harness.checkHarness(instructor)) {
			return harness;
		} else {
			System.out.println("Cannot check this harness!");
			return null;
		}
	}

	Harness loanHarness(String clubMember) {
		Harness harness = null;
		for (int i = 0; i < harnessArray.size(); i++) {
			if (harnessArray.get(i).canHarnessBeLoaned()) {
				harness = harnessArray.get(i);
				harness.loanHarness(clubMember);
			}
		}
		if (harness == null) {
			System.out.println("No available harnesses!");
		}
		return harness;

	}

	Harness returnHarness(String make, int modelNumber) {
		Harness harness = findHarness(make, modelNumber);
		if (harness != null) {
			harness.returnHarness();
			return harness;
		} else {
			return null;
		}
	}

	Harness removeHarness(String make, int modelNumber) {
		Harness harness = null;
		for (int i = 0; i < harnessArray.size(); i++) {
			if ((harnessArray.get(i).modelNumber == modelNumber) && (harnessArray.get(i).make.equals(make))) {
				harness = harnessArray.get(i);
				harnessArray.remove(harness);
			}
		}
		return harness;
	}

	void printHarnessRecords() {
		for (int i = 0; i < harnessArray.size(); i++) {
			System.out.println(harnessArray.get(i).toString());
		}
	}
}
