package un;

public class Marine extends GroundUnit {
	public Marine() {
		super(40);
		hitPoint = MAX_HP;
	}

	@Override
	public String toString() {
		return "Marine";
	}

}
