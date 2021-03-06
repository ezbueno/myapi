package com.ezandro.myapi.controllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StandardError {
	
	private Integer status;
	private Long timestamp;
	private String message;
	
}
