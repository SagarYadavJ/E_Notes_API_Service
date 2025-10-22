package com.enotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enotes.dto.CategoryDTO;
import com.enotes.dto.CategoryResponse;
import com.enotes.entity.Category;
import com.enotes.service.CategoryService;
import com.enotes.service.impl.CategoryServiceImpl;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryServiceImpl;
	
	@PostMapping("/saveCategory")
	public ResponseEntity<?> saveCategoryDetails(@RequestBody CategoryDTO categoryDetails)
	{
	    Boolean savedcategory = categoryServiceImpl.saveCategory(categoryDetails);
	    if(savedcategory)
	    {
		   return new ResponseEntity<>("Category Details Saved", HttpStatus.CREATED);
	    }
	    else
	    {
		   return new ResponseEntity<>("Category Details Not Saved", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/getCategory")
	public ResponseEntity<?> getAllCategory()
	{
		List<CategoryDTO> listCategory = categoryServiceImpl.getAllCategory();
		
		if(CollectionUtils.isEmpty(listCategory))
		{
			return ResponseEntity.noContent().build();
		}else {
			return new ResponseEntity<>(listCategory, HttpStatus.OK);
		}
		
	}

	@GetMapping("/active-getCategory")
	public ResponseEntity<?> getActiveCategory()
	{
		List<CategoryResponse> listCategory = categoryServiceImpl.getActiveCategory();
		
		if(CollectionUtils.isEmpty(listCategory))
		{
			return ResponseEntity.noContent().build();
		}else {
			return new ResponseEntity<>(listCategory, HttpStatus.OK);
		}
		
	}
	
}
