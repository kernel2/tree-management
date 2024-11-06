package com.planisense.treemanagement.infrastructure.adapters.persistence;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.planisense.treemanagement.domain.exceptions.JsonParsingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class JsonLoaderService {

    private final TreeJpaRepository treeJpaRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public JsonLoaderService(TreeJpaRepository treeJpaRepository, ObjectMapper objectMapper) {
        this.treeJpaRepository = treeJpaRepository;
        this.objectMapper = objectMapper;
    }

    @Transactional
    public void loadTreesFromJson(String filePath) {
        try {
            List<TreeEntity> trees = objectMapper.readValue(new File(filePath), new TypeReference<List<TreeEntity>>() {
            });
            treeJpaRepository.saveAll(trees);
        } catch (IOException e) {
            throw new JsonParsingException("Erreur de lecture du fichier JSON", e);
        }
    }
}
