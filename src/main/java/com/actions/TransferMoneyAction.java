package com.actions;


import java.util.Date;
import java.util.Map;

import com.beans.Transactions;
import com.dbutil.DaoTransaction;
import com.dbutil.ORMDAccounts;
import com.dbutil.ORMDUsers;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TransferMoneyAction extends ActionSupport{
	private String amount;
	private String tranpass;
	
	
	public String getTranpass() {
		return tranpass;
	}

	public void setTranpass(String tranpass) {
		this.tranpass = tranpass;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	@Override
	public String execute() {
		Map<String, Object> sm = ActionContext.getContext().getSession();
		if(ORMDAccounts.tranfer(sm.get("un").toString(), sm.get("targetun").toString(), amount)) {
			
			
			Map<String, String> m = ORMDAccounts.getAccount(sm.get("un").toString());
			sm.putAll(m);
			Transactions tran = new Transactions(sm.get("un").toString(), sm.get("targetun").toString(),amount, new Date());
			DaoTransaction.insertTransaction(tran);
			return "success";
		}
		//System.out.println("updated");
		return "false";
	}
	
	@Override
	public void validate() {
		Map<String, Object > sm = ActionContext.getContext().getSession();
		String balance = sm.get("balance").toString();
		try {
			if(Double.parseDouble(amount)>Double.parseDouble(balance)) {
				addFieldError("amount", "The amount is exceeding your balance!");
			}
			else if(!ORMDUsers.tranpassCheck(sm.get("un").toString(), tranpass)) {
				addFieldError("tranpass", "Transaction Pass is not correct");
			}
		} catch (NumberFormatException e) {
			addFieldError("amount", "Not valid input for amount");
		}
		
	}
	
	
}
