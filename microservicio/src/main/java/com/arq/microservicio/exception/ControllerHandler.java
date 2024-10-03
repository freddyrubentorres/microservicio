package com.arq.microservicio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Freddy Torres
 * file :  ControllerHandler
 * @since : 28/9/2024, sáb
 **/

public class ControllerHandler {
    public static ResponseEntity<Object> generateResponse(HttpStatus status, String message, Object responseObj) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", responseObj);
        map.put("timestamp", new Date());
        map.put("statusCode", status.value());
        map.put("message", message);
        return new ResponseEntity<>(map, status);
    }
}
