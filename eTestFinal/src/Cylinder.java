
public class Cylinder extends Shape {
	double radius;
	double height;

	public Cylinder(String name, double radius, double height) {
		super(name);
		this.radius = radius;
		this.height = height;
	}

	@Override
	public String toString() {
		return shapeName + " of radius " + radius + " and height " + height;
	}

	public double area() {

		return ((radius * radius) * Math.PI * height);
	}

}
