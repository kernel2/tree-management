package com.planisense.treemanagement;

import com.planisense.treemanagement.infrastructure.adapters.persistence.JsonLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TreeManagementApplication implements CommandLineRunner {

    private final JsonLoaderService jsonLoaderService;

    @Autowired
    TreeManagementApplication(JsonLoaderService jsonLoaderService) {
        this.jsonLoaderService = jsonLoaderService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TreeManagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        jsonLoaderService.loadTreesFromJson("/Users/kernel/IdeaProjects/tree-management/src/main/resources/migration/les-arbres.json");
    }

}
