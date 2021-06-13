package jp.co.memotodo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.memotodo.dao.CategoryDao;
import jp.co.memotodo.entity.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	private static final String FIND_ALL_CATE = "select * from category ";

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemple;

	@Override
	public List<Category> getAllCategory() {
		// TODO 自動生成されたメソッド・スタブ
		String sql = FIND_ALL_CATE;
		List<Category> cateList = jdbcTemple.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
		return cateList.isEmpty() ? null : cateList;
	}

}
