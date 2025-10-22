package com.enotes.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
	
	
	// when user send a request by passing data, till now that data is binding to category entity but it is not a good
	// practice , so we create a DTO Layer (Which is used to transfer the data) to accept the incoming request and bind it.
	
	// Mapper is used to convert the DTO Class into Category Entity.
	
	private Integer id;
	private String name;
	private String description;
	private Boolean isActive;
	private Integer createdBy;
	private Date createdOn;
	private Integer updatedBy;
	private Date updatedOn;
	

}
