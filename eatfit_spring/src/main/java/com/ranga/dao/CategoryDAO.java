package com.ranga.dao;
import java.util.List;

import com.ranga.entity.Category;


public interface CategoryDAO {
	public long createCategory(Category category);
    public Category updateCategory(Category category);
    public void deleteCategory(long id);
    public List<Category> getAllCategories();
    public Category getCategory(long id);	
	public List<Category> getAllCategories(String name);
}
