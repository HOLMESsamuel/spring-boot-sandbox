package com.springbootsandbox.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PingService {

    @Value("${message.ping}")
    private String pingMessage;

    public String ping(){
        return pingMessage;
    }
}
