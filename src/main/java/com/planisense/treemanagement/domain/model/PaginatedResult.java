package com.planisense.treemanagement.domain.model;

import java.util.List;

public record PaginatedResult<T>(List<T> content, int totalPages, long totalElements) {
}