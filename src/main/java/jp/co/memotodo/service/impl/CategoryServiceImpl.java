package jp.co.memotodo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.memotodo.dao.CategoryDao;
import jp.co.memotodo.entity.Category;
import jp.co.memotodo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao cateDao;
	@Override
	public List<Category> getAllCategory() {
		// TODO 自動生成されたメソッド・スタブ
		return cateDao.getAllCategory();
	}

}
