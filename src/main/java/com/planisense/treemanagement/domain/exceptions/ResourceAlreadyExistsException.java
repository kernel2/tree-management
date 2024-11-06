package com.planisense.treemanagement.domain.exceptions;

public final class ResourceAlreadyExistsException extends ApplicationException {
    public ResourceAlreadyExistsException(String message) {
        super(message);
    }
}
