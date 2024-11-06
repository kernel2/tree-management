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
    public void run(String... args) {
        String url = "https://opendata.paris.fr/api/explore/v2.1/catalog/datasets/les-arbres/exports/json?lang=fr&timezone=Europe%2FBerlin";
        jsonLoaderService.loadTreesFromJsonUrl(url);
    }

}
