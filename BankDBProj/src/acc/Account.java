package acc;

import java.io.Serializable;

import exc.BankException;
import exc.ERR_CODE;

public class Account implements Serializable {
	private String id;
	String name;
	private int balance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	Account() {

	}

	public Account(String id, String name, int balance) {
		this.setId(id);
		this.name = name;
		// this.setBalance(balance);
		setBalance(balance);
	}

	public String info() {
		return String.format("계좌번호: %s, 이름: %s, 잔액: %d", getId(), name, getBalance());
	}

	public void deposit(int amount) {
		setBalance(getBalance() + amount);
	}

	public boolean withdraw(int amount) throws BankException {
		boolean result = false;
		if (getBalance() >= amount) {
			setBalance(getBalance() - amount);
			result = true;
		} else
			throw new BankException(ERR_CODE.WITHDRAW);
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

	public void addBalance(int balance) {
		setBalance(getBalance() + balance);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}