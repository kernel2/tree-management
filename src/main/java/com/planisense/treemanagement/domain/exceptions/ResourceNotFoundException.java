package com.planisense.treemanagement.domain.exceptions;

public final class ResourceNotFoundException extends ApplicationException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
