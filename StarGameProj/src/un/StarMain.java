package un;

public class StarMain {

	public static void main(String[] args) {
		Tank tank = new Tank();
		Marine marine = new Marine();
		Dropship dropship = new Dropship();
		SCV scv = new SCV();

		scv.unitRepair(tank);
//		scv.unitRepair(marine);
		scv.unitRepair(dropship);
		scv.unitRepair(scv);
	}

}
