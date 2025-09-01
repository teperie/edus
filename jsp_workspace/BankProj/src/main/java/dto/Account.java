package dto;

import java.io.Serializable;

import exc.BankException;
import exc.ERR_CODE;

public class Account implements Serializable {
	private String id;
	private String name;
	private int balance;
	
	public Account() {}
	public Account(String id, String name, int balance) {
		this.id=id;
		this.name=name;
		this.balance=balance;
	}
	
	public String info() {
		return String.format("계좌번호:%s, 이름:%s, 잔액:%d", id,name,balance);
	}
	
	public void receive(int money) {
		balance += money;
	}
	
	public void deposit(int money) throws BankException {
		if(money<=0) throw new BankException("입금오류", ERR_CODE.DEPOSIT); 
		balance += money;
	}	
	
	public void withdraw(int money) throws BankException {
		if(balance<money) throw new BankException(ERR_CODE.WITHDRAW);
		balance -= money;
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
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
}