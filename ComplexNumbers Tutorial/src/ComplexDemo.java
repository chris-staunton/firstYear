
public class ComplexDemo {
	public static void main(String[] args) {
		Complex a = new Complex(2, 7);
		Complex b = new Complex(3, 4);
		System.out.println(Complex.toString(a));
		Complex add = Complex.add(a, b);
		Complex multiply = Complex.multiply(a, b);
		Complex divide = Complex.divide(a, b);
		System.out.println(Complex.toString(add));
		System.out.println(Complex.toString(multiply));
		System.out.println(Complex.toString(divide));
	}

}
