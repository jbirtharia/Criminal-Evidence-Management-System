package com.evidence.app.aspect;

import com.evidence.app.contants.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author JayendraB
 * Created on 29/06/21
 */
@Component
@Aspect
@Slf4j
public class DetectiveControllerRequestLogger {

    @Autowired
    ObjectMapper mapper;

    //It will run before target object
    @Before("execution(* com.evidence.app.controller.DetectiveController.*(..))")
    public void requestLogger(JoinPoint joinPoint) {
        log.info("++++++++++++++++++++++++++++++++++ REQUEST INITIALIZED +++++++++++++++++++++++++++++++++++++++++++");
        Object[] signatureArgs = joinPoint.getArgs();

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            if (ArrayUtils.isNotEmpty(signatureArgs)) {
                log.info("\nRequest object: \n" + mapper.writeValueAsString(signatureArgs[0]));
            }
        } catch (JsonProcessingException ex) {
            log.info(Constants.PARSING_EXCEPTION);
            log.info(ex.getCause().getCause().getMessage());
        }
    }

    //It will run after target object
    @AfterReturning(pointcut = "execution(* com.evidence.app.controller.DetectiveController.*(..))",
            returning = "result")
    public void responseLogger(JoinPoint joinPoint, Object result) {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            if (ArrayUtils.isNotEmpty(joinPoint.getArgs())) {
                log.info("\nResponse object: \n" + mapper.writeValueAsString(result));
            }
        } catch (JsonProcessingException ex) {
            log.info(Constants.PARSING_EXCEPTION);
            log.info(ex.getCause().getCause().getMessage());
        }
        log.info("++++++++++++++++++++++++++++++++++ REQUEST COMPLETED +++++++++++++++++++++++++++++++++++++++++++");
    }

    //It will run if target object throws exception
    @AfterThrowing(pointcut = "execution(* com.evidence.app.controller.DetectiveController.*(..))",
            throwing = "exception")
    public void exceptionLogger(JoinPoint joinPoint, Throwable exception) {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            if (ArrayUtils.isNotEmpty(joinPoint.getArgs())) {
                log.info("\nReason of Exception \t\t\t\t: \t" + mapper.writeValueAsString(exception.getMessage()));
            }
        } catch (JsonProcessingException ex) {
            log.info(Constants.PARSING_EXCEPTION);
            log.info(ex.getCause().getCause().getMessage());
        }
        log.info("++++++++++++++++++++++++++++++++++ REQUEST COMPLETED +++++++++++++++++++++++++++++++++++++++++++");
    }
}
