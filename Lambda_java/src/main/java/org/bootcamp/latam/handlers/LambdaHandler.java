package org.bootcamp.latam.handlers;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.InitializationWrapper;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.serverless.proxy.spring.SpringBootProxyHandlerBuilder;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.bootcamp.latam.main.MainApplication;

import org.bootcamp.latam.model.*;
import org.bootcamp.latam.model.lex.LexInput;
import org.bootcamp.latam.model.lex.Messages;
import org.bootcamp.latam.model.lex.Output;
import org.bootcamp.latam.service.AthenaServiceImpl;
import org.bootcamp.latam.service.IAthenaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LambdaHandler implements RequestHandler<LexInput, Output> {

    private static SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;
    private static final Logger logger = LoggerFactory.getLogger(LambdaHandler.class);
    private IAthenaService athenaService = new AthenaServiceImpl<>();

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




    @Override
    public Output handleRequest(LexInput input, Context context) {
        logger.info("Input received: " + input.toString() + " " + context.toString());

        Output outputTest = new Output();
        outputTest.getSessionState().getDialogAction().setType("Close");
        outputTest.getSessionState().getIntent().setName("Query");
        outputTest.getSessionState().getIntent().setState("Fulfilled");
        Messages messages = new Messages();
        List<Publication> publicationList=athenaService.getDataFromAthena("Select title from workshoplabkc.publication where type='Print book' AND Dateedition='2021';");
        messages.setContentType("PlainText");
        messages.setContent(publicationList.toString());
        outputTest.getMessages().add(messages);
        logger.info("Output created: " + outputTest + " ");
        return outputTest;
    }
}