package com.example.storebookservice.service;

import com.example.storebookservice.model.Book;
import com.example.storebookservice.repository.BookRepository;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Sink.class)
public class StoreBookService {

    private final BookRepository bookRepository;

    public StoreBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @StreamListener(target = Sink.INPUT)
    public void storeBook(@Payload Book book) {
        bookRepository.save(book);
        System.out.println("Book stored: " + book);
    }
}
