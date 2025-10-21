package com.enotes.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enotes.entity.Category;
import com.enotes.repository.CategoryRepository;
import com.enotes.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Boolean saveCategory(Category category) {
		
		category.setIsDeleted(false);
		category.setCreatedBy(1);
		category.setCreatedOn(new Date());
		
		Category savedCategory = categoryRepository.save(category);
	
		if(savedCategory != null)
		{
			return true;
		}
		else 
		{
			return false;
		}
		
	}

	@Override
	public List<Category> getAllCategory() {
		List<Category> listCategories = categoryRepository.findAll();
		for(Category cat : listCategories)
		{
			System.out.println(cat);
		}
		return listCategories;
	}

}
