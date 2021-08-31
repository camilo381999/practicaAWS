package com.co.pragma.edad;

import lombok.Data;

@Data
public class Request {
	private int id;
	private int edad;
	private String httpMethod;
	private Usuario usuario;
}
