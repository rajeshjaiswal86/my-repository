package com.example.resttemplate.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.resttemplate.dto.Message;

@Service
@RequestMapping(value = "/service")
public class MessageServiceImpl implements MessageService {
	private static final Logger log = LoggerFactory.getLogger(MessageServiceImpl.class);
	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public ResponseEntity<Message> getMessage() {
		Message msg = new Message();
		msg.setMessage("Hello SpringBoot!");
		log.info("IN SERVICE : msg.getMessage() ::" + msg.getMessage());
		return new ResponseEntity<Message>(msg,HttpStatus.OK);
	}
}
