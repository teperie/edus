package chapter6;


public class SpecialAccount extends Account {
	String grade;

	SpecialAccount(String id, String name, int balance, String grade) {
		super(id, name, balance);
		this.grade = grade;
	}

	@Override
	void deposit(int amount) {
		switch (grade) {
		case "VIP":
			amount += amount * 0.04;
			break;
		case "Gold":
			amount += amount * 0.03;
			break;
		case "Silver":
			amount += amount * 0.02;
			break;
		case "Normal":
		default:
			amount += amount * 0.01;
			break;

		}
		super.deposit(amount);

	}

	@Override
	String info() {
		return super.info() + ", 등급: " + grade;
	}

}
