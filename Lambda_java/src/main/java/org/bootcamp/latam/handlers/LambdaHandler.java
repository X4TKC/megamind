package org.bootcamp.latam.handlers;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.InitializationWrapper;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.serverless.proxy.spring.SpringBootProxyHandlerBuilder;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.bootcamp.latam.helpers.QueryManager;
import org.bootcamp.latam.main.MainApplication;

import org.bootcamp.latam.model.*;
import org.bootcamp.latam.service.AthenaServiceImpl;
import org.bootcamp.latam.service.IAthenaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;

public class LambdaHandler  implements RequestHandler<Param, List<String>> {

    private static SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;
    private static final Logger logger = LoggerFactory.getLogger(LambdaHandler.class);
    private IAthenaService athenaService= new AthenaServiceImpl<>();

    static {
        try {
            handler = new SpringBootProxyHandlerBuilder<AwsProxyRequest>()
                    .defaultProxy()
                    .initializationWrapper(new InitializationWrapper())
                    .servletApplication()
                    .springBootApplication(MainApplication.class)
                    .buildAndInitialize();
        } catch (ContainerInitializationException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not initialize Spring Boot application", e);
        }
    }



//    @Override
//    public Output handleRequest(Object input, Context context) {
//        logger.info("Input received: "+ input.toString()+ " "+ context.toString());
//        String output="{\n" +
//                "          \"sessionState\": {\n" +
//                "            \"dialogAction\": {\n" +
//                "              \"type\": \"Close\"\n" +
//                "            },\n" +
//                "            \"intent\": {\n" +
//                "              \"name\": \"Say-Hello\",\n" +
//                "               \"state\": \"Fulfilled\"\n" +
//                "            }\n" +
//                "          },\n" +
//                "          \"messages\": [\n" +
//                "           {\n" +
//                "             \"contentType\": \"PlainText\",\n" +
//                "             \"content\": 'this is a test from lambda-node'\n" +
//                "            }\n" +
//                "        ]  \n" +
//                "        }";
//        Output outputTest = new Output();
//        outputTest.getSessionState().getDialogAction().setType("Close");
//        outputTest.getSessionState().getIntent().setName("Query");
//        outputTest.getSessionState().getIntent().setState("Fulfilled");
//        Messages messages = new Messages();
//        messages.setContentType("PlainText");
//        messages.setContent("this is a test from lambda-java");
//        outputTest.getMessages().add(messages);
//        logger.info("Output created: "+ outputTest + " ");
//        return outputTest;
//    }


//    @Override
//    public LambdaResponse handleRequest(Param input, Context context) {
//        logger.info("Input received: "+ input.toString()+ " "+ context.toString());
//        List<Publication> publicationList=athenaService.getDataFromAthena("Select * from workshoplabkc.publication limit 10");
//        ResponseManager responseManager = new ResponseManager();
//        for (Question question: input.getQuestions()) {
//            responseManager.add(question.getQuestion(),publicationList,publicationList.size());
//        }
//
//        LambdaResponse lambdaResponse= new LambdaResponse();
//        lambdaResponse.setResponseList(responseManager.get());
//        logger.info("Output received: " + lambdaResponse+" ");
//        return lambdaResponse;
//    }

    @Override
    public List<String> handleRequest(Param input, Context context) {
        logger.info("Input received: "+ input.toString()+ " "+ context.toString());
        QueryManager queryManager = new QueryManager(input);
        List<String> queries=queryManager.getQuery();
        logger.info("Output received: " + queries+" ");
        return queries;
    }


}