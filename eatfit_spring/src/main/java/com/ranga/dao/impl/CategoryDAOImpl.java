package com.ranga.dao.impl;

import com.ranga.dao.CategoryDAO;
import com.ranga.entity.Category;

import com.ranga.util.HibernateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CategoryDAOImpl implements CategoryDAO {

	public CategoryDAOImpl() {
		System.out.println(" CategoryDAOImpl");
	}

	@Autowired
	private HibernateUtil hibernateUtil;

	@Override
	public long createCategory(Category category) {
		return (Long) hibernateUtil.create(category);

	}

	@Override
	public Category updateCategory(Category category) {
		return hibernateUtil.update(category);
	}

	@Override
	public void deleteCategory(long id) {
		Category category = new Category();
		category.setId(id);
		hibernateUtil.delete(category);

	}

	@Override
	public List<com.ranga.entity.Category> getAllCategories() {
		return hibernateUtil.fetchAll(Category.class);
	}

	@Override
	public Category getCategory(long id) {
		return hibernateUtil.fetchById(id, Category.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategories(String searchname) {
		String query = "SELECT c.* FROM Category c WHERE c.name like '%" + searchname + "%'";
		List<Object[]> categoryObjects = hibernateUtil.fetchAll(query);
		List<Category> categories = new ArrayList<Category>();
		for (Object[] categoryObject : categoryObjects) {
			Category category = new Category();
			long id = ((BigInteger) categoryObject[0]).longValue();
			String name = (String) categoryObject[1];
			category.setId(id);
			category.setName(name);

			categories.add(category);
		}
		System.out.println(categories);
		return categories;
	}
}
