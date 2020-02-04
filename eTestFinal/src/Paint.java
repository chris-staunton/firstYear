
public class Paint {
	double coverage;

	Paint(double coverage) {
		this.coverage = coverage;
	}

	double amount(Shape shape) {
		System.out.println("Computing amount for " + shape.toString());
		double areaToPaint = shape.area();
		double amount = areaToPaint / coverage;
		System.out.println("Amount of paint required is " + amount);
		return amount;
	}

}
