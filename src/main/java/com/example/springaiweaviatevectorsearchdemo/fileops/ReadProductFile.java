package com.example.springaiweaviatevectorsearchdemo.fileops;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class ReadProductFile {

    @Value("classpath:products.json")
    Resource resource;

    public void readAndPrintJsonFile() {
          try (InputStream inputStream = resource.getInputStream()) {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(inputStream);
            for (JsonNode node : jsonNode) {
                if (node.has("description")) {
                    System.out.println(node.get("description").toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
