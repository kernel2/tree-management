package com.planisense.treemanagement.infrastructure.configuration;

public record ErrorResponse(int status, String error, String message, String path) {
}
