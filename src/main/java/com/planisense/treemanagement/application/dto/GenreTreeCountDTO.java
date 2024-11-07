package com.planisense.treemanagement.application.dto;

public class GenreTreeCountDTO {
    private String genre;
    private Long treeCount;


    public GenreTreeCountDTO(String genre, Long treeCount) {
        this.genre = genre;
        this.treeCount = treeCount;
    }

    public String getGenre() {
        return genre;
    }

    public Long getTreeCount() {
        return treeCount;
    }
}

