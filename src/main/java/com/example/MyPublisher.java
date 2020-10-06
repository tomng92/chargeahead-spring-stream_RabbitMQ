package com.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(Source.class)
public class MyPublisher {

    @Autowired
    private Source source;

    @PostMapping(value= "/trn")
    public String publish(@RequestBody String payload) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        MyTransaction trx = mapper.readValue(payload, MyTransaction.class);

        source.output().send(MessageBuilder.withPayload(trx).setHeader("myheader", "myheadervalue").build());

        System.out.println("Sent a message to queue >>");
        return "success";


    }

}
