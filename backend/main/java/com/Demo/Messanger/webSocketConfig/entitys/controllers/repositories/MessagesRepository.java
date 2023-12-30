package com.Demo.Messanger.webSocketConfig.entitys.controllers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Demo.Messanger.webSocketConfig.entitys.Message;

public interface MessagesRepository extends JpaRepository<Message, Integer> {

	
	
	
	
}
