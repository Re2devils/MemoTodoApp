package jp.co.memotodo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.memotodo.dao.UsersDao;
import jp.co.memotodo.entity.Users;
import jp.co.memotodo.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersDao userDao;

	@Override
	public Users findByLoginId(String loginId) {
		// TODO 自動生成されたメソッド・スタブ
		return userDao.findByLoginId(loginId);
	}

	@Override
	public Users authLogin(String loginId, String pass) {
		// TODO 自動生成されたメソッド・スタブ
		return userDao.authLogin(loginId, pass);
	}

	@Override
	public boolean checkExistedOfLoginId(Users user) {
		// TODO 自動生成されたメソッド・スタブ
		return userDao.checkExistedOfLoginId(user);
	}

	@Override
	public void register(Users user) {
		// TODO 自動生成されたメソッド・スタブ
		userDao.register(user);
	}

}
