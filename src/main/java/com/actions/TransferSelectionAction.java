package com.actions;

import java.util.Map;

import com.beans.Account;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TransferSelectionAction extends ActionSupport{
	
	
	private String targetun;
	
	
	public String getTargetun() {
		return targetun;
	}

	public void setTargetun(String targetun) {
		this.targetun = targetun;
	}

	public String execute() {
		System.out.println("execute: " + targetun);
		Map<String, Object> sm = ActionContext.getContext().getSession();
		System.out.println(sm);
		Map<String,String> m= (Map<String,String>)sm.get("accounts");
		String targetAcno = m.get(targetun);
		sm.put("targetun", targetun);
		sm.put("targetAcno", targetAcno);
		return "success";
	}
}
