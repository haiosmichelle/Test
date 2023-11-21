package com.example.test;

import com.example.test.clase.Message;
import com.example.test.clase.MessageService;
import com.example.test.clase.MessageFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {

        SpringApplication.run(TestApplication.class, args);
    }
    @Bean
    public CommandLineRunner run(MessageService messageService) {
        return args -> {
            String filePath ="file:com/example/test/messages.json";

            try {
                List<Message> decodedMessages = messageService.readMessagesFromFile(filePath);

                for (Message message : decodedMessages) {
                    System.out.println("Decoded Message: " + message.getContent());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }}
