package jp.co.memotodo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.memotodo.dao.UsersDao;
import jp.co.memotodo.entity.Users;

@Repository
public class UsersDaoImpl implements UsersDao {

	//	sql sentence
	private static final String FIND_BY_LOGIN_ID = "select * from users where login_id = :loginId";
	//	and password
	private static final String AND_PASS = " and password = :password ";
	//	and not user id
	private static final String AND_NOT_USER_ID = " and user_id != :userId";
	//	insert into users table
	private static final String INSER_INTO_USERS = "insert into users(login_id, user_name, email, password "
			+ ") values(:loginId, :userName, :email, :password)";

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public Users findByLoginId(String loginId) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = FIND_BY_LOGIN_ID;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("loginId", loginId);
		List<Users> usersList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Users>(Users.class));
		return usersList.isEmpty() ? null : usersList.get(0);
	}

	@Override
	public Users authLogin(String loginId, String pass) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = FIND_BY_LOGIN_ID + AND_PASS;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("loginId", loginId);
		param.addValue("password", pass);
		List<Users> usersList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Users>(Users.class));
		return usersList.isEmpty() ? null : usersList.get(0);
	}

	@Override
	public boolean checkExistedOfLoginId(Users user) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = FIND_BY_LOGIN_ID + AND_NOT_USER_ID;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("loginId", user.getLoginId());
		param.addValue("userId", user.getUserId());
		List<Users> usersList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Users>(Users.class));
		return usersList.isEmpty() ? false : true;
	}

	@Override
	public void register(Users user) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = INSER_INTO_USERS;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("loginId", user.getLoginId());
		param.addValue("userName", user.getUserName());
		param.addValue("email", user.getEmail());
		param.addValue("password", user.getPassword());
		param.addValue("roleId", user.getRoleId());
		jdbcTemplate.update(sql, param);
	}

}
