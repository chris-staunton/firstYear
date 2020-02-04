import java.util.Scanner;
public class BMI {
	public static void main(String[] args ) {
	
		Scanner input = new Scanner(System.in);
		System.out.print("How much do you weigh in kgs?");
		double weight = input.nextDouble();
		System.out.print("What is your height in metres?");
		double height = input.nextDouble();
		double bmi = weight / (height * height);
		
		System.out.print("Yout BMI is " + bmi);
		if (bmi > 25)
			System.out.print("\nlol ur fat");
		else 
			System.out.print("\nEat a damn sandwich ya doofus");
		
		input.close();
	}
}
