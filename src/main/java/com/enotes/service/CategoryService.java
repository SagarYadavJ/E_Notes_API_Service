package com.enotes.service;

import java.util.List;

import com.enotes.dto.CategoryDTO;
import com.enotes.dto.CategoryResponse;
import com.enotes.entity.Category;

public interface CategoryService {
	
	public Boolean saveCategory(CategoryDTO categorydto);
	
	public List<CategoryDTO> getAllCategory();
	
	public List<CategoryResponse> getActiveCategory();

}
