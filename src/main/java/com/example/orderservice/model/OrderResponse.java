package com.example.orderservice.model;

import lombok.Data;

import java.time.Instant;

@Data
public class OrderResponse {

    private String status;

    private Instant date;
}
