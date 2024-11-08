package com.planisense.treemanagement.application.dto;


import java.util.List;

public class ArrondissementTreeCountDTO {
    private String arrondissement;
    private Long treeCount;
    private List<TreeDTO> trees;

    public ArrondissementTreeCountDTO(String arrondissement, Long treeCount, List<TreeDTO> trees) {
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

    public List<TreeDTO> getTrees() {
        return trees;
    }

    public void setTrees(List<TreeDTO> trees) {
        this.trees = trees;
    }
}

