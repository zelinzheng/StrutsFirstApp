package com.actions;

import java.util.Map;

import com.beans.User;
import com.dbutil.ORMDAccounts;
import com.dbutil.ORMDUsers;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class FirstAction extends ActionSupport implements ModelDriven<User>{
	
	private User user = new User();
	
	public String execute()
	{
		
		//a tag using an action
		//or add the value into the session
		//value="#session[un]
/*ValueStack vs = ActionContext.getContext().getValueStack();
		Map<String, String> m = new HashMap<String, String>();
		m.put("AcNo", "2565654");
		m.put("Bal", "15000");
		vs.push(m);*/
		Map<String, Object> sm = ActionContext.getContext().getSession();
		//ValueStack vs = ActionContext.getContext().getValueStack();
		
		Map<String, String> m = ORMDAccounts.getAccount((user.getUn()));
		//vs.push(m);
		sm.putAll(m);
		
		return "success";
	}
	
	@Override
	public void validate() {
		if(user.getUn().trim().length() == 0) {
			this.addFieldError("un", "This can't be left blank.");
		} else if((ORMDUsers.userCheck(user.getUn()))) {
			this.addFieldError("un", "This username doesn't exist.");
		} else if(user.getPass().trim().length() == 0) {
			this.addFieldError("pass", "This can't be left blank.");
		} else if(!ORMDUsers.passCheck(user.getUn(), user.getPass())) {
			this.addFieldError("pass", "Wrong password!");
		}
		
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}
