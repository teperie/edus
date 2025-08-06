
public class Shape {
	String color;

	public Shape() {
		color = "White";
	}

	public void draw() {
		System.out.println("[" + color + "]");
	}

	public Shape(String color) {
		this.color = color;
	}

	//
}
