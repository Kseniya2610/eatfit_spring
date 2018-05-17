package com.ranga.service;
import com.ranga.entity.Category;

import java.util.List;

public interface CategoryService {
	public long createCategory(Category category);
    public Category updateCategory(Category category);
    public void deleteCategory(long id);
    public List<Category> getAllCategories();
    public Category getCategory(long id);	
	public List<Category> getAllCategories(String name);
}
