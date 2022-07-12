package com.springbootsandbox.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PingServiceTest {

    @Autowired
    private PingService pingService;

    @Value("${message.ping}")
    private String pingMessage;

    @Test
    void ping() {
        assertEquals(pingMessage, pingService.ping());
    }
}