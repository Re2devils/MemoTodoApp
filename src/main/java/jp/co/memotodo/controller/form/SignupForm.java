package jp.co.memotodo.controller.form;

import javax.validation.constraints.NotBlank;

public class SignupForm {
	@NotBlank(message = "ユーザー名は必須です")
	private String loginId;
	@NotBlank(message = "名前は必須です")
	private String userName;
	@NotBlank(message = "Eメールは必須です")
	private String email;
	@NotBlank(message = "パスワードは必須です")
	private String password;
	@NotBlank(message = "パスワードは一致しません")
	private String rePass;
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
	public String getRePass() {
		return rePass;
	}
	public void setRePass(String rePass) {
		this.rePass = rePass;
	}


}
