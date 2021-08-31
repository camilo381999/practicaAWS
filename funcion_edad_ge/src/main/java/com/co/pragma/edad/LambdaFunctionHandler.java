package com.co.pragma.edad;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaFunctionHandler implements RequestHandler<Request, Object> {

    @Override
    public Object handleRequest(Request request, Context context) {

		AmazonDynamoDB db = AmazonDynamoDBClientBuilder.defaultClient();
		DynamoDBMapper mapper = new DynamoDBMapper(db);

		if(request.getEdad()==0) {
			return null;
		}

		Map<String, AttributeValue> valueMap = new HashMap<String, AttributeValue>();
		
		valueMap.put(":edadInput", new AttributeValue().withN(String.valueOf(request.getEdad())));
		
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
				.withFilterExpression("edad >= :edadInput")
				.withExpressionAttributeValues(valueMap);
		
		List<Usuario> usuarios = mapper.scan(Usuario.class, scanExpression);
		
		return usuarios;
		
		/*switch (request.getHttpMethod()) {
		case "GET":
			List<Usuario> usuariosFullList = mapper.scan(Usuario.class, new DynamoDBScanExpression());

			List<Usuario> usuarios = new ArrayList<>();

			for (Usuario u : usuariosFullList) {
				if (u.getEdad() >= request.getEdad()) {
					usuarios.add(u);
				}
			}
			return usuarios;

		}
        return null;*/
    }

}
