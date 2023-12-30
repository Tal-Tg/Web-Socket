package com.Demo.Messanger.webSocketConfig.entitys.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter.SseEventBuilder;

import com.Demo.Messanger.webSocketConfig.entitys.Message;
import com.Demo.Messanger.webSocketConfig.entitys.controllers.repositories.MessagesRepository;

@Controller
//@RequestMapping("test")
@CrossOrigin(origins = "*", maxAge = 3600,allowedHeaders = "*")
public class MessangerController {
	
	
//	@Autowired
//	private Message message;
	
	@Autowired
	private MessagesRepository messagesRepository;

	SseEventBuilder eventBuilder = SseEmitter.event();
	
	@MessageMapping("/hello")
	@SendTo("/topic/messages")
	public ResponseEntity<?> getMessages(@RequestBody Message message){
		Message message1 = messagesRepository.save(new Message(message.getMessage()));
		System.out.println(messagesRepository.findAll());
		return new ResponseEntity<>(messagesRepository.findAll(),HttpStatus.OK);
	}
	
//	private List<SseEmitter> emitters = new ArrayList<>();
//	
//	@GetMapping("/messages")
//	public SseEmitter messages() {
//		SseEmitter sEmitter = new SseEmitter();
//		emitters.add(sEmitter);
//		sEmitter.onCompletion(() -> emitters.remove(sEmitter));
//		return sEmitter;
//	}
	
	
	
//	@PostMapping("/new-message")
//	public ResponseEntity<?> addMessage(@RequestBody Message message){
////		messagesRepository.save(new Message(message.getMessage()));
////		for(SseEmitter emitter : emitters) {
////			try {
////				emitter.send(SseEmitter.event().name("spring").data(message));
////			} catch (IOException e) {
////				e.printStackTrace();
////			}
////		}
//		return new ResponseEntity<>(messagesRepository.findAll(),HttpStatus.CREATED);
//	}
}
