package com.planisense.treemanagement.infrastructure.configuration;

import com.planisense.treemanagement.domain.ports.TreeRepositoryPort;
import com.planisense.treemanagement.domain.services.TreeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public TreeServiceImpl treeService(TreeRepositoryPort treeRepository) {
        return new TreeServiceImpl(treeRepository);
    }

}
