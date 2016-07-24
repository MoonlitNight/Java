package com.chat.user;

import java.io.Serializable;

/**
 * 
 * @author 瑾 该类用于描述封装用户信息
 */
public class User implements Serializable{
	/**
	 * 序列化对象添加版本号
	 */
	private static final long serialVersionUID = 6992578394277753279L;
	private String loginName;// 用户登录名
	private String password;// 用户密码
	private String phone;// 用户手机号码
	private String email;// 用户电子邮箱

	public User() {
		super();
	}

	public User(String loginName, String password, String phone, String email) throws Exception {
		super();
		setLoginName(loginName);
		setPassword(password);
		setPhone(phone);
		setEmail(email);
	}

	/**
	 * @return the loginName
	 */
	public synchronized String getLoginName() {
		return loginName;
	}

	/**
	 * @param loginName the loginName to set
	 * @throws Exception 
	 */
	public synchronized void setLoginName(String loginName) throws Exception {
		if(!loginName.matches("[a-zA-z]\\w+")){
			throw new Exception("用户名不能以数字、非字母字符开头");
		}
		this.loginName = loginName;
	}

	/**
	 * @return the password
	 */
	public synchronized String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 * @throws Exception 
	 */
	public synchronized void setPassword(String password) throws Exception {
		if(password.matches("[\\d]+")||password.matches("[\\W]+"))
		{
			throw new Exception("密码不能为纯数字或非字母字符");
		}
		this.password = password;
	}

	/**
	 * @return the phone
	 */
	public synchronized String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 * @throws Exception 
	 */
	public synchronized void setPhone(String phone) throws Exception {
		if(!(phone.matches("[1][345789]\\d{9}")))
		{
			throw new Exception("手机号码不合法");
		}
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public synchronized String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 * @throws Exception 
	 */
	public synchronized void setEmail(String email) throws Exception {
		if(!(email.matches("^([a-zA-Z]||[1-9])\\w+@([a-zA-z]|(\\d))+\\.[a-zA-Z]+$")))
		{
			throw new Exception("电子邮件地址不合法");
		}
		this.email = email;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return  loginName + "&" + password + "&" + phone + "&" + email;
	}
}
