package com.actions;

import java.util.Map;

import javax.xml.ws.soap.Addressing;

import org.apache.struts.action.Action;

import com.beans.User;
import com.dbutil.ORMDAccounts;
import com.dbutil.ORMDUsers;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

public class SignupAction extends ActionSupport implements ModelDriven<User>{
	User user = new User();
	private String cofpass;
	
	public String execute() {
		
		try {
			ORMDUsers.insert(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<String, Object> sm = ActionContext.getContext().getSession();
		Map<String, String> m = ORMDAccounts.getAccount((user.getUn()));
		sm.putAll(m);
		
		return "success";
	}
	
	public String getConpass() {
		return cofpass;
	}
	public void setConpass(String conpass) {
		this.cofpass = conpass;
	}
	@Override
	public void validate() {
		if(!(ORMDUsers.userCheck(user.getUn()))) {
			this.addFieldError("un", "This username has been used.");
		}
		

		if(user.getCofpass().trim().length() == 0) {
			this.addFieldError("cofpass", "This can't be left blank");
		} else if(!user.getCofpass().trim().equals(user.getPass().trim())){
			this.addFieldError("cofpass", "This must be same as password");
		}
		if(user.getTranpass().trim().length() == 0) {
			this.addFieldError("tranpass", "This can't be left blank");
		} else if (user.getTranpass().trim().length() != 8) {
			this.addFieldError("tranpass", "Transaction password must be 8 digits");
		} else if (user.getTranpass().trim().equals(user.getUn().trim()) || user.getTranpass().trim().equals(user.getPass().trim())) {
			this.addFieldError("tranpass", "Transaction password must not be the same as others.");
		}
		if(user.getCoftranpass().trim().length() == 0) {
			this.addFieldError("coftranpass", "This can't be left blank");
		} else if(!user.getCoftranpass().trim().equals(user.getTranpass().trim())){
			this.addFieldError("coftranpass", "This must be same as password");
		}
		
		
		
	}
	@VisitorFieldValidator(appendPrefix=false)
	public User getModel() {
		return user;
	}
	
	
	
}
