
public class Triangle extends Shape {
	//protected String color;
	protected int base;
	protected int height;
	
	public Triangle(String color, int base, int height) {
		super(color);
		this.base = base;
		this.height = height;
		System.out.println(this.toString());
	}
	public double getArea() {
		return (0.5*base*height);
	}
	public String toString() {
		return String.format("%s: %s%n%s: %s%n%s: %s%n%s: %s", "color", color,
				"base", base, "height", height, "area", getArea());
	}

}
