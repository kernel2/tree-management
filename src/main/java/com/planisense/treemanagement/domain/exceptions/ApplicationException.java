package com.planisense.treemanagement.domain.exceptions;

public sealed class ApplicationException extends RuntimeException
        permits ResourceAlreadyExistsException, ResourceNotFoundException, UnexpectedErrorException, JsonParsingException {

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}