package com.arq.microservicio.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author : Freddy Torres
 * file :  ErrorsMessage
 * @since : 10/10/2024, jue
 **/

@Setter
@Getter
@AllArgsConstructor
public class ErrorsMessage {
    private int statusCode;
    private Date timestamp;
    private Map<String, List<String>> message;
    private String description;
}
