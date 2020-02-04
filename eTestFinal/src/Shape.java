public abstract class Shape {
	String shapeName;

	public Shape(String name) {
		shapeName = name;
	}

	public String toString() {
		return shapeName;
	}

	public abstract double area();
}