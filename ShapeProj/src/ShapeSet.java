
public class ShapeSet {
	Shape[] shapes = new Shape[100];
	int cnt;

	void addShape(Shape shape) {
		shapes[cnt++] = shape;
	}

	void drawAll() {
		for (int i = 0; i < cnt; i++) {
			shapes[i].draw();

			// 다형성의 잘못된 예
			// Circle이면 Circle의 draw를 호출하고,
			// Rectangle이면 Rectangle의 draw를 호출한다.
			// if(shapes[i] instanceof Circle) {
			//   Circle c = (Circle)shapes[i];
			// } else if(shapes[i] instanceof Rectangle) {
			//   Rectangle r = (Rectangle)shapes[i];
			// }
			// 다형성의 특징 때문에 이렇게 안 해도 된다.
			// Circle과 Rectangle은 Shape의 자식이므로 Shape 배열에 저장할 수 있다
		}
	}

    public void allShapeDraw() {
        for(int i = 0; i < cnt; i++) {
            shapes[i].draw();
        }
    }
}
