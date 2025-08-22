package acc;

import java.io.Serializable;

import dao.AccountDao;
import exc.BankException;
import exc.ERR_CODE;

public class Account implements Serializable {
	private String id;
	private String name;
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
		AccountDao.update(this);
	}

	public boolean withdraw(int amount) throws BankException {
		boolean result = false;
		if (getBalance() >= amount) {
			setBalance(getBalance() - amount);
			AccountDao.update(this);
			result = true;
		} else
			throw new BankException(ERR_CODE.WITHDRAW);
		return result;
	}

	public void receive(int amount) {
		setBalance(getBalance() + amount);
		AccountDao.update(this);
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void addBalance(int balance) {
		setBalance(getBalance() + balance);
		AccountDao.update(this);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return this.info();
	}

}