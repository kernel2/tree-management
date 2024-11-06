package com.planisense.treemanagement.domain.exceptions;

public final class UnexpectedErrorException extends ApplicationException {
    public UnexpectedErrorException(String message) {
        super(message);
    }
}