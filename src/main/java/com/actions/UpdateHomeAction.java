package com.actions;

import java.util.Map;

import com.dbutil.ORMDAccounts;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class UpdateHomeAction extends ActionSupport{
	public String execute() {
		System.out.println("This is updatehomeaction");
		ValueStack vs = ActionContext.getContext().getValueStack();
		Map<String, String> m = ORMDAccounts.getAccount((vs.getContext().get("un").toString()));
		System.out.println(vs.getContext().get("un").toString());
		vs.push(m);
		return "success";
		
	}
}
