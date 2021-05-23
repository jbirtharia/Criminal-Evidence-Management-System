package com.evidence.app.error.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * The type Exception response.
 *
 * @author JayendraB
 * @createdOn 5 /14/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {

    private LocalDateTime timeStamp;

    private int status;

    private String error;

    private String message;

    private  String path;
}
