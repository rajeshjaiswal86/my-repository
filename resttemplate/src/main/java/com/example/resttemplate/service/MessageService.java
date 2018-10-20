package com.example.resttemplate.service;

import org.springframework.http.ResponseEntity;

import com.example.resttemplate.dto.Message;

public interface MessageService {
	ResponseEntity<Message> getMessage();
}
