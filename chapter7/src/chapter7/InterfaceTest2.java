package chapter7;

interface Clickable {
	void click();
}

class Button {
	Clickable clickable;

	void onClick() {
		System.out.println("쏙 들어갔다 나옴");
		if (clickable != null)
			clickable.click();
	}

	void addClickEventListner(Clickable clickable) {
		this.clickable = clickable;
	}
}

public class InterfaceTest2 {

	public static void main(String[] args) {
		Button button = new Button();
		
		button.addClickEventListner(new Clickable() {

			@Override
			public void click() {
				// TODO Auto-generated method stub
				System.out.println("로그인 처리");
			}
			
		});
		
		button.onClick();

	}

}
