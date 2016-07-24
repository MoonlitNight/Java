package com.chat.user;

import java.io.Serializable;

/**
 * 
 * @author � ��������������װ�û���Ϣ
 */
public class User implements Serializable{
	/**
	 * ���л�������Ӱ汾��
	 */
	private static final long serialVersionUID = 6992578394277753279L;
	private String loginName;// �û���¼��
	private String password;// �û�����
	private String phone;// �û��ֻ�����
	private String email;// �û���������

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
			throw new Exception("�û������������֡�����ĸ�ַ���ͷ");
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
			throw new Exception("���벻��Ϊ�����ֻ����ĸ�ַ�");
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
			throw new Exception("�ֻ����벻�Ϸ�");
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
			throw new Exception("�����ʼ���ַ���Ϸ�");
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
