package com.beans;

import java.io.Serializable;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;

public class Account implements Serializable{
	private int acno;
	private String un;
	private int balance;
	public int getAcno() {
		return acno;
	}
	public void setAcno(int acno) {
		this.acno = acno;
	}
	@RequiredFieldValidator(fieldName="un", message="Username is required")
	public String getUn() {
		return un;
	}
	public void setUn(String un) {
		this.un = un;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	public Account() {
		super();
	}
	public Account(int acno, String un, int balance) {
		super();
		this.acno = acno;
		this.un = un;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [acno=" + acno + ", un=" + un + ", balance=" + balance
				+ "]";
	}
	
	
}
