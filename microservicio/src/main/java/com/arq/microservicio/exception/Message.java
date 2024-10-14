package com.arq.microservicio.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
public class Message {
    private int statusCode;
    private Date timestamp;
    private String message;
    private String description;
}
