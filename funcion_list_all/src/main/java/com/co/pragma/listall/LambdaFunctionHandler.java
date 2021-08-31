package com.co.pragma.listall;

import java.util.List;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaFunctionHandler implements RequestHandler<Request, Object> {

	@Override
	public Object handleRequest(Request request, Context context) {
		AmazonDynamoDB db = AmazonDynamoDBClientBuilder.defaultClient();
		DynamoDBMapper mapper = new DynamoDBMapper(db);
		Usuario usuario = null;

		switch (request.getHttpMethod()) {
		case "GET":
			List<Usuario> usuarios = mapper.scan(Usuario.class, new DynamoDBScanExpression());
			return usuarios;
		case "POST":
			usuario = request.getUsuario();
			mapper.save(usuario);
			return usuario;
		}
		return null;
	}

}