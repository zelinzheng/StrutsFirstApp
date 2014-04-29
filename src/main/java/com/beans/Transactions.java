package com.beans;


import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dbutil.HibernateUtil;



public class Transactions {
	private int transactionId;
	private String un;
	private String targetun;
	private String amount;
	private Date trandate;
	private String transfertype;
	
	
	
	public String getTransfertype() {
		return transfertype;
	}
	public void setTransfertype(String transfertype) {
		this.transfertype = transfertype;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getUn() {
		return un;
	}
	public void setUn(String un) {
		this.un = un;
	}
	public String getTargetun() {
		return targetun;
	}
	public void setTargetun(String targetun) {
		this.targetun = targetun;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public Date getTrandate() {
		return trandate;
	}
	public void setTrandate(Date trandate) {
		this.trandate = trandate;
	}
	public Transactions(String un, String targetun, String amount, Date trandate) {
		super();
		this.un = un;
		this.targetun = targetun;
		this.amount = amount;
		this.trandate = trandate;
	}
	
	public Transactions() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", un=" + un
				+ ", targetun=" + targetun + ", amount=" + amount
				+ ", trandate=" + trandate + "]";
	}
	
	
}
