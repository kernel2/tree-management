package com.planisense.treemanagement.domain.model;

import java.util.List;

public class GenreTreeCount {
    private String genre;
    private Long treeCount;
    private List<Tree> trees;

    public GenreTreeCount(String genre, Long treeCount, List<Tree> trees) {
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

    public List<Tree> getTrees() {
        return trees;
    }

    public void setTrees(List<Tree> trees) {
        this.trees = trees;
    }
}
