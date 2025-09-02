package dto;

import java.io.Serializable;

import exc.BankException;

// This file is deprecated and will be removed. All logic is now in Account.java.
public class SpecialAccount extends Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String grade;
	
	public SpecialAccount(String id, String name, int balance, String grade) {
		super(id,name,balance);
		this.grade=grade;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Override
	public void deposit(int money) throws BankException {
		switch(grade.toLowerCase()) {
		case "vip": money += (int)(money*0.04); break;
		case "gold": money += (int)(money*0.03); break;
		case "silver": money += (int)(money*0.02); break;
		case "normal": money += (int)(money*0.01); break;
		}
		super.deposit(money);
	}
	
	@Override
	public String info() {
		return super.info()+", 등급:"+getGrade();
	}
	
}