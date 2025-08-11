package acc;

import exc.BankException;

public class SpecialAccount extends Account {
	String grade;

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public SpecialAccount(String id, String name, int balance, String grade) {
		super(id, name, balance);
		this.setGrade(grade);
	}

	@Override
	public void deposit(int amount) {
		switch (grade) {
		case "VIP":
			amount += (int) (amount * 0.04);
			break;
		case "Gold":
			amount += (int) (amount * 0.03);
			break;
		case "Silver":
			amount += (int) (amount * 0.02);
			break;
		case "Normal":
		default:
			amount += (int) (amount * 0.01);
			break;

		}
		super.deposit(amount);

	}
	
	@Override
	public boolean withdraw(int amount) throws BankException{
		return false;
		
	}

	@Override
	public String info() {
		return super.info() + ", 등급: " + getGrade();
	}

}
