package com.example.test.clase;

import com.example.test.clase.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class MessageFactory {
    private ObjectMapperConfig objectMapper;

    public MessageFactory(ObjectMapperConfig objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<Message> decodeMessages(String json) throws IOException {
        return objectMapper.readValue(json, new TypeReference<List<Message>>() {});
    }
}
