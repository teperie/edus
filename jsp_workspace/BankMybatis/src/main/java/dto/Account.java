package dto;

import exc.BankException;
import exc.ERR_CODE;

public class Account {
	String id;
	String name;
	Integer balance;
	String type;
	String grade;

	public Account() {
	}

	public Account(String id, String name, Integer balance, String type) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.type = type;
	}

	public Account(String id, String name, Integer balance, String type, String grade) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.type = type;
		this.grade = grade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void deposit(int money) throws BankException {
		if (money <= 0) {
			throw new BankException("입금액은 0보다 커야 합니다.", ERR_CODE.DEPOSIT);
		}
		balance += money;
	}

	public String info() {
		return this.toString();
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", balance=" + balance + ", type=" + type + ", grade=" + grade
				+ "]";
	}

	public void withdraw(Integer money) throws BankException {
		if (money <= 0) {
			throw new BankException("출금액은 0보다 커야 합니다.", ERR_CODE.WITHDRAW);
		}
		if (balance < money) {
			throw new BankException("잔액이 부족합니다.", ERR_CODE.WITHDRAW);
		}
		balance -= money;
	}

	public void receive(Integer money) {
		balance += money;
	}
}
