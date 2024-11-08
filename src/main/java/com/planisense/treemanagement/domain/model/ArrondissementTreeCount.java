package com.planisense.treemanagement.domain.model;

import java.util.List;

public class ArrondissementTreeCount {
    private String arrondissement;
    private Long treeCount;
    private List<Tree> trees;

    public ArrondissementTreeCount(String arrondissement, Long treeCount, List<Tree> trees) {
        this.arrondissement = arrondissement;
        this.treeCount = treeCount;
        this.trees = trees;
    }

    public String getArrondissement() {
        return arrondissement;
    }

    public void setArrondissement(String arrondissement) {
        this.arrondissement = arrondissement;
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
