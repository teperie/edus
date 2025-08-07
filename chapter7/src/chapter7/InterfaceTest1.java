package chapter7;

interface Movable {
	void move(int x, int y);
}

interface Attackable {
	void attack();
}

class Unit {
	int x;
	int y;

	void stop() {
	}
}

class Tank extends Unit implements Movable, Attackable {

	@Override
	public void attack() {
		// TODO Auto-generated method stub

	}

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub

	}
	
	public void siege() {
		
	}

}

public class InterfaceTest1 {
	public static void main(String[] args) {
		Tank t = new Tank();
		Unit u = new Tank();
		Movable m = new Tank();
		Attackable a = new Tank();
		
		t.siege();
		t.stop();
		t.move(0, 0);
		t.attack();
		
		// Tank 객체여도 변수 타입에 해당하는 메소드만 호출 가능
		u.stop();
		
		m.move(0, 0);
		
		a.attack();
		
	}
}
