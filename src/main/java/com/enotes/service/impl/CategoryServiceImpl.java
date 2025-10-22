package com.enotes.service.impl;


import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enotes.dto.CategoryDTO;
import com.enotes.dto.CategoryResponse;
import com.enotes.entity.Category;
import com.enotes.repository.CategoryRepository;
import com.enotes.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public Boolean saveCategory(CategoryDTO categorydto) {
		//Category category = new Category();
		
//		category.setName(categorydto.getName());
//		category.setDescription(categorydto.getDescription());
//		category.setIsActive(categorydto.getIsActive());
		Category category = mapper.map(categorydto, Category.class);
		
		
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
	public List<CategoryDTO> getAllCategory() {
		List<Category> listCategories = categoryRepository.findAll();
		
		List<CategoryDTO> categoryDTOList = listCategories.stream()
				.map(cat -> mapper.map(cat,CategoryDTO.class)).toList();
		
//		for(Category cat : listCategories)
//		{
//			System.out.println(cat);
//		}
		return categoryDTOList;
	}

	@Override
	public List<CategoryResponse> getActiveCategory() {
		
		List<Category> listCategories = categoryRepository.findByIsActiveTrue();
		
		List<CategoryResponse> categoryResponse = listCategories.stream()
				.map(cat -> mapper.map(cat,CategoryResponse.class)).toList();
		
		return categoryResponse;
	}

}
