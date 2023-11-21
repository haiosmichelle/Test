package com.example.test.clase;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@Configuration
public class ObjectMapperConfig {
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public List<Message> readValue() throws IOException {
        URL resource = getClass().getClassLoader().getResource("messages.json");
        if (resource == null) {
            throw new RuntimeException("File 'messages.json' not found!");
        }

        return objectMapper().readValue(resource, new TypeReference<List<Message>>() {});
    }

    public List<Message> readValue(String json, TypeReference<List<Message>> typeReference) throws IOException {
        URL resource = getClass().getClassLoader().getResource(json);
        if (resource == null) {
            throw new RuntimeException("File 'messages.json' not found!");
        }

        return objectMapper().readValue(resource, new TypeReference<List<Message>>() {});

    }
}
