
public abstract class Shape {
	String color;

	public Shape() {
		color = "White";
	}

	public abstract void draw();

	public Shape(String color) {
		this.color = color;
	}
	
}
