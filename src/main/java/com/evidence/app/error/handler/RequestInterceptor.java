package com.evidence.app.error.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

/**
 * The type Request interceptor.
 *
 * @author JayendraB
 * @createdOn 5 /14/2021
 */
@Component
@Slf4j
public class RequestInterceptor implements Filter{

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        log.info("++++++++++++++++++++++++++++++++++ REQUEST INITIALIZED +++++++++++++++++++++++++++++++++++++++++++");
        final var httpServletRequest = (HttpServletRequest) servletRequest;
        //log.info("Input Request : {}",getDataFromStream(httpServletRequest.getReader()));
        try {
            filterChain.doFilter(httpServletRequest, servletResponse);
        } finally {
                afterRequest();
        }
    }

    private void afterRequest() {
        log.info("++++++++++++++++++++++++++++++++++ REQUEST COMPLETED +++++++++++++++++++++++++++++++++++++++++++");
    }

    private String getDataFromStream(BufferedReader reader){
        return reader.lines().collect(Collectors.joining());
    }
}
