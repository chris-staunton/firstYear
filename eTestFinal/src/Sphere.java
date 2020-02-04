
public class Sphere extends Shape {
	double radius;

	public Sphere(String name, double radius) {
		super(name);
		this.radius = radius;
	}

	@Override
	public String toString() {
		return shapeName + " of radius " + radius;
	}

	public double area() {
		return ((radius * radius) * Math.PI * 4);
	}
}
