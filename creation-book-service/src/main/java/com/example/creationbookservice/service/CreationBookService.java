package com.example.creationbookservice.service;

import com.example.creationbookservice.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@EnableBinding(Source.class)
@EnableScheduling
@Service
public class CreationBookService {

    private final Source source;

    private static Long increments = 0L;

    @Autowired
    public CreationBookService(Source source) {
        this.source = source;
    }

    @Scheduled(fixedRate = 10000)
    public void createBook() {
        increments ++;
        Book book = new Book.Builder()
                .setId(increments)
                .setName("Book" + increments)
                .setDescription("Description" + increments)
                .setStatus("unchecked")
                .setPrice(10.0 )
                .build();

        source.output().send(MessageBuilder.withPayload(book).build());
        System.out.println("Created book: " + book);
    }
}