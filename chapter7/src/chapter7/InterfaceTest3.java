package chapter7;

interface DoubleClickable {
	void doubleClick();
}

public class InterfaceTest3 {

	static void func(DoubleClickable dc) {
		dc.doubleClick();
	}

	public static void main(String[] args) {
		func(new DoubleClickable() {

			@Override
			public void doubleClick() {
				System.out.println("이미지를 더블클릭함");
			}

		});

	}

}
