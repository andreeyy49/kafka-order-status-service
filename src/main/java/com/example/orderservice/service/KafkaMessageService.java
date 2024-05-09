package com.example.orderservice.service;

import com.example.orderservice.model.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class KafkaMessageService {

    private final KafkaTemplate<String, OrderResponse> kafkaTemplate;

    @Value("${app.kafka.kafkaMessageTopicStatus}")
    private String statusTopic;


    @Autowired
    public KafkaMessageService(KafkaTemplate<String, OrderResponse> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void add() {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setDate(Instant.now());
        orderResponse.setStatus("CREATED");
        kafkaTemplate.send(statusTopic, orderResponse);
    }
}
