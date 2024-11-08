package com.planisense.treemanagement.application.dto;

import java.util.List;

public class GenreTreeCountDTO {
    private String genre;
    private Long treeCount;
    private List<TreeDTO> trees;

    public GenreTreeCountDTO(String genre, Long treeCount, List<TreeDTO> trees) {
        this.genre = genre;
        this.treeCount = treeCount;
        this.trees = trees;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Long getTreeCount() {
        return treeCount;
    }

    public void setTreeCount(Long treeCount) {
        this.treeCount = treeCount;
    }

    public List<TreeDTO> getTrees() {
        return trees;
    }

    public void setTrees(List<TreeDTO> trees) {
        this.trees = trees;
    }
}

