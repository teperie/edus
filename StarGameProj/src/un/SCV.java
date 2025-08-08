package un;

public class SCV extends GroundUnit implements Repairable {
	public SCV() {
		super(60);
		hitPoint = MAX_HP;
	}

	@Override
	public String toString() {
		return "SCV";
	}

	@Override
	public void repair() {
		hitPoint = MAX_HP;
		System.out.println("SCV 고장 수리됨");
	}
	
	public void unitRepair(Repairable unit) {
		unit.repair();
	}

}
