package jp.co.memotodo.entity;

public class Incomplete {
	private Integer incompleteId;
	private Integer userId;
	private Integer loginId;

	public Incomplete() {

	}
	public Incomplete(Integer id, Integer user, Integer login) {
		incompleteId = id;
		userId = user;
		loginId = login;
	}
	public Integer getIncompleteId() {
		return incompleteId;
	}
	public void setIncompleteId(Integer incompleteId) {
		this.incompleteId = incompleteId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getLoginId() {
		return loginId;
	}
	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}
}
