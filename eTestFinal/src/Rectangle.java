
public class Rectangle extends Shape {
	double length;
	double width;

	public Rectangle(String name, double length, double width) {
		super(name);
		this.length = length;
		this.width = width;
	}

	@Override
	public String toString() {
		return shapeName + " of length " + length + " and width " + width;
	}

	public double area() {
		return (length * width);
	}

}
