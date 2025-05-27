//MessageSender.java(18.05.2025)
package com.nt.sender;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;

@Component
public class MessageSender  {
    @Autowired
	private JmsTemplate template;
	//@Scheduled(cron="${cron.expr}")
	@Scheduled(cron="0/10 * * * * *")
    public void send() {
        System.out.println("MessageSender.send()");		
		template.send("tcp1",ses->ses.createTextMessage("Good Morning::"+new Date()));
		System.out.println("Message Sent");
	}
}
