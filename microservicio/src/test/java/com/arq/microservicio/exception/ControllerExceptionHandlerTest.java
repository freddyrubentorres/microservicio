package com.arq.microservicio.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
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
        ResponseEntity<Message> response = exceptionHandler.resourceNotFoundException(exception, webRequest);
        // Then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testGlobalExceptionHandler() {
        // Given
        Exception exception = new Exception("Error inesperado");
        WebRequest request = mock(WebRequest.class);
        when(request.getDescription(false)).thenReturn("Descripción del error");
        // When
        ResponseEntity<ErrorsMessage> response = exceptionHandler.globalExceptionHandler(exception, request);
        // Then
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        ErrorsMessage message = response.getBody();
        assertNotNull(message);
        assertEquals("Descripción del error", message.getDescription());
    }

    @Test
    public void testNotValid() {
        // Given
        MethodArgumentNotValidException exception = mock(MethodArgumentNotValidException.class);
        WebRequest request = mock(WebRequest.class);
        when(request.getDescription(false)).thenReturn("Request description");
        FieldError fieldError = new FieldError("objectName", "fieldName", "Field error message");
        when(exception.getAllErrors()).thenReturn(List.of(fieldError));
        // When
        ResponseEntity<ErrorsMessage> response = exceptionHandler.notValid(exception, request);
        // Then
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        ErrorsMessage body = response.getBody();
        assert body != null;
        assertEquals("Request description", body.getDescription());
    }
}
