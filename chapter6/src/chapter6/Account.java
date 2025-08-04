package chapter6;

class Account {
	String id;
	String name;
	int balance;

	String info() {
		return String.format("계좌번호: %s, 이름: %s, 잔액: %d", id, name, balance);
	}

	void deposit(int amount) {
		balance += amount;
	}

	void withdraw(int amount) {
		if (balance >= amount)
			balance -= amount;
		else
			System.out.println("잔액이 부족합니다.");
	}

}