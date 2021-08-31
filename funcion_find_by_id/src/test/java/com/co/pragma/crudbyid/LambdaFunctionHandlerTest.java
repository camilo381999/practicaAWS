package com.co.pragma.crudbyid;

import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class LambdaFunctionHandlerTest {


    /*@Test
    public void testLambdaFunctionHandler() {
        LambdaFunctionHandler handler = new LambdaFunctionHandler(s3Client);
        Context ctx = createContext();

        String output = handler.handleRequest(event, ctx);

        // TODO: validate output here if needed.
        Assert.assertEquals(CONTENT_TYPE, output);
    }*/
}
