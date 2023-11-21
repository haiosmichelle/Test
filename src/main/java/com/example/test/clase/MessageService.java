package com.example.test.clase;
import com.example.test.clase.Message;
import com.example.test.clase.MessageFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class MessageService {
    private final MessageFactory messageFactory;

    @Autowired
    public MessageService(MessageFactory messageFactory) {
        this.messageFactory = messageFactory;
    }

    public List<Message> readMessagesFromFile(String filePath) throws IOException {
        String json = new String(Files.readAllBytes(Paths.get(filePath)));
        return messageFactory.decodeMessages(json);
    }
}

