package com.planisense.treemanagement.infrastructure.adapters.persistence;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.planisense.treemanagement.domain.exceptions.JsonParsingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@Service
@EnableAsync
public class JsonLoaderService {

    private final TreeJpaRepository treeJpaRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public JsonLoaderService(TreeJpaRepository treeJpaRepository, ObjectMapper objectMapper) {
        this.treeJpaRepository = treeJpaRepository;
        this.objectMapper = objectMapper;
    }

    @Async
    @Transactional
    public void loadTreesFromJsonUrl(String url) {
        try {
            List<TreeEntity> trees = objectMapper.readValue(new URL(url), new TypeReference<List<TreeEntity>>() {
            });
            treeJpaRepository.saveAll(trees);
        } catch (IOException e) {
            throw new JsonParsingException("Erreur de lecture du fichier JSON à partir de l'URL : " + url, e);
        }
    }
}
