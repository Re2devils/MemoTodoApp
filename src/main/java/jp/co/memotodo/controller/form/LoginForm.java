package jp.co.memotodo.controller.form;

import javax.validation.constraints.NotBlank;

public class LoginForm {
	@NotBlank(message = "ユーザー名は必須です")
	private String loginId;
	@NotBlank(message = "パスワードは必須です")
	private String password;
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
