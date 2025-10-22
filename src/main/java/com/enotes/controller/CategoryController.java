package com.enotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enotes.dto.CategoryDTO;
import com.enotes.dto.CategoryResponse;
import com.enotes.entity.Category;
import com.enotes.service.CategoryService;
import com.enotes.service.impl.CategoryServiceImpl;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController 
{
	
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
	
	
	@GetMapping("/getCategoryById/{id}")
	public ResponseEntity<?> getCategoryDetailsById(@PathVariable Integer id)
	{
		
		CategoryDTO category = categoryServiceImpl.getcategoryById(id);
		
		if(ObjectUtils.isEmpty(category))
		{
			return new ResponseEntity<>("Category Details for the provided id is not found", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(category,HttpStatus.OK);
		}
		
	}
	
	@DeleteMapping("/deleteCategoryById/{id}")
	public ResponseEntity<?> deleteCategoryDetailsById(@PathVariable Integer id)
	{
		
		Boolean category = categoryServiceImpl.deletetcategoryById(id);
		
		if(category)
		{
			return new ResponseEntity<>("Category Details for the provided id is Deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Category Details for the provided id is Not Deleted",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
}
