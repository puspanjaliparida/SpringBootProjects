//MessageSender.java(18.05.2025)
package com.nt.sender;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.nt.model.Actor;

@Component
public class MessageSender implements CommandLineRunner {
    @Autowired
	private JmsTemplate template;
	@Override
	public void run(String... args) throws Exception {
		
		Actor actor1=new Actor(1001,"ntr","hyd",8000.0);
		template.convertAndSend("testmq1",actor1);
		System.out.println("Message is Sent");
	}
}
