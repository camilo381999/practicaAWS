package com.co.pragma.edad;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@DynamoDBTable(tableName="Usuarios")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Usuario {

	@DynamoDBHashKey
	private long id;
	
	@DynamoDBAttribute
	private String tipoID;
	@DynamoDBAttribute
	private String nombres;
	@DynamoDBAttribute
	private String apellidos;
	@DynamoDBAttribute
	private int edad;
	@DynamoDBAttribute
	private String ciudadNacimiento;
}
