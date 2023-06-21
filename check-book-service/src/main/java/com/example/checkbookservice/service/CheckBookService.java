package com.example.checkbookservice.service;

import com.example.checkbookservice.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Processor.class)
@MessageEndpoint
public class CheckBookService {

    @Autowired
    private Processor processor;

    //Данный метод слушает сообщения из входного канала Processor.INPUT
    //Далее возвращает измененный экземпляр book и отправляет его в выходной канал Processor.OUTPUT
    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Book checkBook(Book book) {
        book.setStatus("checked");
        System.out.println(book);
        return book;
    }
}
