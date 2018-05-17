package com.ranga.controller;

import com.ranga.entity.Category;
import com.ranga.service.CategoryService;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {

	private static final Logger logger = Logger.getLogger(CategoryController.class);

	public CategoryController() {
		System.out.println("CategoryController()");
	}

	@Autowired
	private CategoryService categoryService;

	@RequestMapping("createCategory")
	public ModelAndView createCategory(@ModelAttribute Category category) {
		logger.info("Creating Category. Data: " + category);
		return new ModelAndView("categoryForm");
	}

	@RequestMapping("editCategory")
	public ModelAndView editCategory(@RequestParam long id, @ModelAttribute Category category) {
		logger.info("Updating the Category for the Id " + id);
		category = categoryService.getCategory(id);
		return new ModelAndView("categoryForm", "categoryObject", category);
	}

	@RequestMapping("saveCategory")
	public ModelAndView saveCategory(@ModelAttribute Category category) {
		logger.info("Saving the Category. Data : " + category);
		if (category.getId() == null) { // if employee id is 0 then creating the employee other updating the employee
			categoryService.createCategory(category);
		} else {
			categoryService.updateCategory(category);
		}
		return new ModelAndView("redirect:getAllCategories");
	}

	@RequestMapping("deleteCategory")
	public ModelAndView deleteCategory(@RequestParam long id) {
		logger.info("Deleting the Category. Id : " + id);
		categoryService.deleteCategory(id);
		return new ModelAndView("redirect:getAllCategories");
	}

	@RequestMapping(value = { "getAllCategories", "/" })
	public ModelAndView getAllCategories() {
		logger.info("Getting the all Categories.");
		List<Category> categoryList = categoryService.getAllCategories();
		return new ModelAndView("categoryList", "categoryList", categoryList);
	}

	@RequestMapping("searchCategory")
	public ModelAndView searchCategory(@RequestParam("searchName") String searchName) {
		logger.info("Searching the Category. Category Names: " + searchName);
		List<Category> categoryList = categoryService.getAllCategories(searchName);
		return new ModelAndView("categoryList", "categoryList", categoryList);
	}
}
