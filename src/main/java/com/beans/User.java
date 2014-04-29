package com.beans;

import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

public class User {
	private String un;
	private String pass;
	private String email;
	private String tranpass;
	private String acno;
	private String cofpass;
	private String coftranpass;
	public User() {
		super();
	}
	public User(String un, String pass, String email, String tranpass) {
		super();
		this.un = un;
		this.pass = pass;
		this.email = email;
		this.tranpass = tranpass;
	}
	public String getAcno() {
		return acno;
	}
	public void setAcno(String acno) {
		this.acno = acno;
	}
	
	@RequiredStringValidator(fieldName="un", message="Username is required!")
	public String getUn() {
		return un;
	}
	public void setUn(String un) {
		this.un = un;
	}
	
	@RequiredStringValidator(fieldName="pass", message="password is required!")
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@RequiredStringValidator(fieldName="email", message="Email is required!")
	@EmailValidator(fieldName="email", message="Wrong email format.")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTranpass() {
		return tranpass;
	}
	public void setTranpass(String tranpass) {
		this.tranpass = tranpass;
	}
	public String getCofpass() {
		return cofpass;
	}
	public void setCofpass(String cofpass) {
		this.cofpass = cofpass;
	}
	public String getCoftranpass() {
		return coftranpass;
	}
	public void setCoftranpass(String coftranpass) {
		this.coftranpass = coftranpass;
	}
	
	
	
	
	
}
