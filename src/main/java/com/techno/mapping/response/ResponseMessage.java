package com.techno.mapping.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value =Include.NON_DEFAULT)
public class ResponseMessage {
	
	private Boolean error;
	private String message;
	private Object data;

}
