package jp.co.memotodo.dao;

import jp.co.memotodo.entity.Users;

public interface UsersDao {
//	search by login id
	public Users findByLoginId(String loginId);
//	check login
	public Users authLogin(String loginId, String pass);
//	check exsit of a login id
	public boolean checkExistedOfLoginId(Users user);
//	insert a user record
	public void register(Users user);
}
