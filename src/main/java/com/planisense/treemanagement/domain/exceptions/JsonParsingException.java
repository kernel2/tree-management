package com.planisense.treemanagement.domain.exceptions;

public final class JsonParsingException extends ApplicationException {
    public JsonParsingException(String message) {
        super(message);
    }

    public JsonParsingException(String message, Throwable cause) {
        super(message, cause);
    }
}
