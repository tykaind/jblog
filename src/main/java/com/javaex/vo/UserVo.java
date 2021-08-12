package com.javaex.vo;

public class UserVo {

	private int userNo;
	private String id;
	private String password;
	private String userName;
	private String joinDate;
	
	
	
	public UserVo() {}
	
	public UserVo(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public UserVo(String id, String password, String userName) {
		this.id = id;
		this.password = password;
		this.userName = userName;
	}

	public UserVo(int userNo, String id, String password, String userName, String joinDate) {
		this.userNo = userNo;
		this.id = id;
		this.password = password;
		this.userName = userName;
		this.joinDate = joinDate;
	}

	
	
	
	
	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	
	
	
	@Override
	public String toString() {
		return "userVo [userNo=" + userNo + ", id=" + id + ", password=" + password + ", userName=" + userName
				+ ", joinDate=" + joinDate + "]";
	}
}
