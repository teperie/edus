package acc;

public class Account {
	private String id;
	String name;
	private int balance;

	Account() {

	}

	public Account(String id, String name, int balance) {
		this.setId(id);
		this.name = name;
		// this.setBalance(balance);
		deposit(balance);
	}

	public String info() {
		return String.format("계좌번호: %s, 이름: %s, 잔액: %d", getId(), name, getBalance());
	}

	public void deposit(int amount) {
		setBalance(getBalance() + amount);
	}

	public boolean withdraw(int amount) {
		boolean result = false;
		if (getBalance() >= amount) {
			setBalance(getBalance() - amount);
			result = true;
		} else
			System.out.println("잔액이 부족합니다.");
		return result;
	}

	public void receive(int amount) {
		setBalance(getBalance() + amount);
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}