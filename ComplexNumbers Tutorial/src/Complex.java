
public class Complex {
	private double x;
	private double y;
	public Complex(){
		x=0;
		y=0;
	}
	public Complex(double realPart, double imaginaryPart) {
		x=realPart;
		y=imaginaryPart;
	}
	public static Complex add (Complex a, Complex b) {
		double x1 = a.x;
		double x2 = b.x;
		double y1 = a.y;
		double y2 = b.y;
		double newX = x1+x2;
		double newY = y1+y2;
		Complex sum = new Complex(newX, newY);
		return sum;
	}
	public static Complex multiply(Complex a, Complex b) {
		double x1 = a.x;
		double x2 = b.x;
		double y1 = a.y;
		double y2 = b.y;
		double newX = ((x1*x2)-(y1*y2));
		double newY = ((x1*y2)+(y1*x2));
		Complex multiply = new Complex(newX, newY);
		return multiply;
	}
	public static Complex divide(Complex a, Complex b) {
		double x1 = a.x;
		double x2 = b.x;
		double y1 = a.y;
		double y2 = b.y;
		double newX = ((x1*x2)+(y1*y2))/((x2*x2)+(y2*y2));
		double newY = ((y1*x2)-(x1*y2))/((x2*x2)+(y2*y2));
		Complex divide = new Complex(newX, newY);
		return divide;
	}
	public static String toString(Complex a) {
		String complexString = a.x + " " + a.y + "i.";
		return complexString;
	}
}
