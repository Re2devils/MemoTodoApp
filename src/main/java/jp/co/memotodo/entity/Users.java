package jp.co.memotodo.entity;

public class Users {
	private Integer userId;
	private String loginId;
	private String userName;
	private String email;
	private String password;
	private Integer roleId;

	public Users() {

	}
	public Users(Integer id, String login, String name, String mail, String pass, Integer role) {
		userId = id;
		loginId = login;
		userName = name;
		email = mail;
		password = pass;
		roleId = role;
	}
	public Users(String login, String name, String mail, String pass, Integer role) {
		loginId = login;
		userName = name;
		email = mail;
		password = pass;
		roleId = role;
	}
	public Users(String login, String name, String mail, String pass) {
		loginId = login;
		userName = name;
		email = mail;
		password = pass;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}
