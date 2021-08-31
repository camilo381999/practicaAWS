package com.co.pragma.crudbyid;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
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
			usuario = mapper.load(Usuario.class, request.getId());
			System.out.println(request.getId());
			
			return usuario;
		case "DELETE":
			usuario = mapper.load(Usuario.class, request.getId());
			mapper.delete(usuario);
			return usuario;
		}
		return null;
	}

}