package com.swift.model;

/**
 * Account Object used for the ICC user's account details
 * 
 * @author Rob Powell
 * @version 1.0
 */
public class Account {

	private int id;
    private long timeStamp;
	private String accountName;
	private String password;
	private String mobileNumber;
	private Network operator;

	public Account() {

	}

	/**
	 * 
	 * @param mobileNumber
	 *            Mobile Number of the user, used to login to the Operator's service
	 * @param accountName
	 *            ICC specific account name, to identify different account's within ICC
	 * @param pwd
	 *            Password of the user's operator account
	 * @param operator
	 *            The user's Telecoms Operator
	 */
	public Account(final String mobileNumber, final String accountName, final String pwd, final Network operator) {
		this.accountName = accountName;
		this.mobileNumber = mobileNumber;
		this.password = pwd;
		this.operator = operator;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public String getPassword() {
		return this.password;
	}

	public Network getOperator() {
		return this.operator;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public int getId() {
		return this.id;
	}

	public void setId(final int id) {
		this.id = id;
	}

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setOperator(Network operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "Account{" +
				"id=" + id +
				", timeStamp=" + timeStamp +
				", accountName='" + accountName + '\'' +
				", password='" + password + '\'' +
				", mobileNumber='" + mobileNumber + '\'' +
				", operator=" + operator +
				'}';
	}

	@Override
    public boolean equals(Object o) {
        if(o instanceof Account)
            return this.id == ((Account) o).getId();
        return super.equals(o);
    }
}