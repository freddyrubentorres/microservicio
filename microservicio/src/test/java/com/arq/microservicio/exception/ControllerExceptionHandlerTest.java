package com.arq.microservicio.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author : Freddy Torres
 * file :  ControllerExceptionHandlerTest
 * @since : 2/10/2024, mié
 **/

class ControllerExceptionHandlerTest {
    private ControllerExceptionHandler exceptionHandler;

    @Mock
    private WebRequest webRequest;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        exceptionHandler = new ControllerExceptionHandler();
    }
    @Test
    public void testResourceNotFoundException() {
        // Given
        String errorMessage = "Resource not found";
        ResourceNotFoundException exception = new ResourceNotFoundException(errorMessage);
        when(webRequest.getDescription(false)).thenReturn("Resource not found description");
        // When
        ResponseEntity<ErrorMessage> response = exceptionHandler.resourceNotFoundException(exception, webRequest);
        // Then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testGlobalExceptionHandler() {
        // Given
        String errorMessage = "Internal server error";
        Exception exception = new Exception(errorMessage);
        when(webRequest.getDescription(false)).thenReturn("Internal error description");
        // When
        ResponseEntity<ErrorMessage> response = exceptionHandler.globalExceptionHandler(exception, webRequest);
        // Then
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
}
