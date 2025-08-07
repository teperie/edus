package emp;

public class Sales extends Permanent {
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
		// TODO Auto-generated method stub
		return super.toString();
	}

}
