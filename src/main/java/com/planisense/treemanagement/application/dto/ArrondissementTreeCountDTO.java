package com.planisense.treemanagement.application.dto;


import java.util.List;

public class ArrondissementTreeCountDTO {
    private String arrondissement;
    private Long treeCount;
    private List<TreeDTO> trees;

    public ArrondissementTreeCountDTO(String arrondissement, Long treeCount) {
        this.arrondissement = arrondissement;
        this.treeCount = treeCount;
    }

    public String getArrondissement() {
        return arrondissement;
    }

    public Long getTreeCount() {
        return treeCount;
    }

}

