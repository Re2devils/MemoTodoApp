package jp.co.memotodo.entity;

public class Role {
	private Integer roleId;
	private String roleName;

	public Role () {

	}
	public Role(Integer id, String name) {
		roleId = id;
		roleName = name;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
