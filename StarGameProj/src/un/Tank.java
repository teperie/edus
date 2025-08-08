package un;

public class Tank extends GroundUnit implements Repairable {

	public Tank() {
		super(150);
		hitPoint = MAX_HP;
	}

	@Override
	public void repair() {
		hitPoint = MAX_HP;
		System.out.println("Tank 고장 수리됨");
	}

	@Override
	public String toString() {
		return "Tank";
	}

}
