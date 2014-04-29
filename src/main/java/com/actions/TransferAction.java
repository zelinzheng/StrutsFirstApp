package com.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.beans.Account;
import com.dbutil.ORMDAccounts;
import com.opensymphony.xwork2.ActionContext;

public class TransferAction {
	public String execute() {
		Map<String, Object> s = ActionContext.getContext().getSession();
		String sql = "Select * from accounts where un !='" + s.get("un")+"'order by acno";
		System.out.println(sql);
		ArrayList<Account> acs = ORMDAccounts.select(sql);
		
		Map<String, String> m = new LinkedHashMap();
		for(Account a:acs) {
			m.put(a.getUn(),Integer.toString(a.getAcno()));
		}
		
		
		s.put("accounts", m);
		//System.out.println("testing: "+s.get("accounts"));
		return "success";
		
	}
}
