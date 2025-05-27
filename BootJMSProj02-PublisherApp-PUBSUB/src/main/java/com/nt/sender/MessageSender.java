//MessageSender.java(18.05.2025)
package com.nt.sender;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;

@Component
public class MessageSender implements CommandLineRunner {
    @Autowired
	private JmsTemplate template;
	@Override
	public void run(String... args) throws Exception {
		
	  /*  template.send("testmq",new MessageCreator() {
			
			@Override
			public Message createMessage(Session ses) throws JMSException {
				Message message=ses.createTextMessage("Good Morning::"+new Date());
				return message;
			}
		});	*/
		
		template.send("testmq",ses->ses.createTextMessage("Good Morning::"+new Date()));
	}
}
