
public class Rectangle extends Shape{
	protected int length;
	protected int width;
	public Rectangle(String color, int length, int width) {
		super(color);
		this.length = length;
		this.width = width;
		System.out.println(this.toString());
	}
	public double getArea() {
		return (length*width);
	}
	public String toString() {
		return String.format("%s: %s%n%s: %s%n%s: %s%n%s: %s", "color", color,
				"length", length, "width", width, "area", getArea());
	}
}
