//MessageReceiver.java(18.05.2025)
package com.nt.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.nt.model.Actor;

@Component
public class MessageReceiver {
    
	@JmsListener(destination="testmq1")
	public void readMessage(Actor actor) {
		System.out.println("Message::"+actor);
	}
}
