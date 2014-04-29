package com.actions;

import java.util.List;
import java.util.Map;

import com.beans.Transactions;
import com.dbutil.DaoTransaction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ViewSummaryAction extends ActionSupport{

	@Override
	public String execute() {
		Map<String, Object> sm = ActionContext.getContext().getSession();
		List<Transactions> lt = DaoTransaction.getAllTransByUn(sm.get("un").toString());
		//List<Transactions> lt = DaoTransaction.getAllTransFromUn(sm.get("un").toString());
		//List<Transactions> lt2 = DaoTransaction.getAllTransToUn(sm.get("un").toString());
		for (Transactions transactions : lt) {
			if(transactions.getUn().equals(sm.get("un").toString())) {
				transactions.setTransfertype("Debit");
				String amount = transactions.getAmount();
				transactions.setAmount("-"+amount);
			} else {
				transactions.setTransfertype("Credit");
			}
		}
		sm.put("alltrans", lt);
		//sm.put("totrans", lt2);
		System.out.println("View Summary Action:");
		for(Object object:lt) {
			System.out.println(object);
		}
		
		return "success";
	}
}
