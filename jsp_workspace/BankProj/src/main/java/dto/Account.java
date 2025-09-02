package dto;

import java.io.Serializable;

import exc.BankException;
import exc.ERR_CODE;

public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private int balance;
	private String grade;
	
	public Account() {}
	public Account(String id, String name, int balance) {
		this(id, name, balance, null);
	}
	public Account(String id, String name, int balance, String grade) {
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.grade = grade;
	}
	
	public String info() {
		String base = String.format("계좌번호:%s, 이름:%s, 잔액:%d", id, name, balance);
		if (grade != null && !grade.isEmpty()) {
			base += ", 등급:" + grade;
		}
		return base;
	}
	
	public void receive(int money) {
		balance += money;
	}
	
	public void deposit(int money) throws BankException {
		if (money <= 0) throw new BankException("입금오류", ERR_CODE.DEPOSIT);
		if (grade != null && !grade.isEmpty()) {
			switch (grade.toLowerCase()) {
				case "vip": money += (int)(money * 0.04); break;
				case "gold": money += (int)(money * 0.03); break;
				case "silver": money += (int)(money * 0.02); break;
				case "normal": money += (int)(money * 0.01); break;
				default: break;
			}
		}
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
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
}