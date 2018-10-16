package com.test.service;
import org.springframework.stereotype.Service;

@Service
public class HelloMessageService {

    public String getMessage() {
        return "Hello " + "NOT ONE";
    }

    public String getMessage(String name) {
        return "Hello " + "ONE";
    }

}

