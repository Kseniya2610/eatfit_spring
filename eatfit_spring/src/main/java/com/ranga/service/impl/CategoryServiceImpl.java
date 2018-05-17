package com.ranga.service.impl;
import com.ranga.dao.CategoryDAO;

import com.ranga.entity.Category;
import com.ranga.service.CategoryService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	public CategoryServiceImpl() {
		System.out.println("CategoryServiceImpl()");
	}
	
    @Autowired
    private CategoryDAO categoryDAO;
    
    
	@Override
	public long createCategory(Category category) {
		return categoryDAO.createCategory(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return categoryDAO.updateCategory(category);
	}

	@Override
	public void deleteCategory(long id) {
		categoryDAO.deleteCategory(id);
		
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryDAO.getAllCategories();
	}

	@Override
	public Category getCategory(long id) {
		return categoryDAO.getCategory(id);
	}

	@Override
	public List<Category> getAllCategories(String name) {
		return categoryDAO.getAllCategories(name);
	}

}
