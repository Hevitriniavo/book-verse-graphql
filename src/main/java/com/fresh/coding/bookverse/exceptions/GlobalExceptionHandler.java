package com.fresh.coding.bookverse.exceptions;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public GraphQLError handleValidationException(ConstraintViolationException ex) {
        final var message = String.format("Validation failed: %s", ex.getMessage());
        return GraphqlErrorBuilder.newError()
                .message(message)
                .build();
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public GraphQLError handleAccessDenied(AccessDeniedException ex) {
        final var message = String.format("Access Denied: %s", ex.getMessage());
        return GraphqlErrorBuilder.newError()
                .message(message)
                .build();
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public GraphQLError handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        final var message = String.format("Database error: unique constraint violated. %s",
                ex.getMostSpecificCause().getMessage());
        return GraphqlErrorBuilder.newError()
                .message(message)
                .build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UsernameNotFoundException.class)
    public GraphQLError handleUsernameNotFoundException(UsernameNotFoundException ex) {
        final var message = String.format("User not found: %s", ex.getMessage());
        return GraphqlErrorBuilder.newError()
                .message(message)
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public GraphQLError handleGenericException(Exception ex) {
        final var message = String.format("Error: %s", ex.getMessage());
        return GraphqlErrorBuilder.newError()
                .message(message)
                .build();
    }
}

