package emp;

public class Sales extends Permanent implements IBusinessTrip {
	int incentive;

	public Sales(String num, String name, int salary, int incentive) {
		super(num, name, salary);
		this.incentive = incentive;
	}

	@Override
	public int getPay() {
		// TODO Auto-generated method stub
		return super.getPay() + getIncentive();
	}

	public int getIncentive() {
		return incentive;
	}

	public void setIncentive(int incentive) {
		this.incentive = incentive;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public void goBusinessTrip(int day) {
		incentive += day * 100000;
	}

}
