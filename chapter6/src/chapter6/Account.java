package chapter6;

class Account {
	String id;
	String name;
	int balance;

	Account() {

	}

	Account(String id, String name, int balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	String info() {
		return String.format("계좌번호: %s, 이름: %s, 잔액: %d", id, name, balance);
	}

	void deposit(int amount) {
		balance += amount;
	}

	boolean withdraw(int amount) {
		boolean result = false;
		if (balance >= amount) {
			balance -= amount;
			result = true;
		} else
			System.out.println("잔액이 부족합니다.");
		return result;
	}

}