package un;

public class Dropship extends AirUnit implements Repairable {
	public Dropship() {
		super(200);
		hitPoint = MAX_HP;
	}

	@Override
	public String toString() {
		return "Dropship";
	}

	@Override
	public void repair() {
		hitPoint = MAX_HP;
		System.out.println("Dropship 고장 수리됨");
	}

}
