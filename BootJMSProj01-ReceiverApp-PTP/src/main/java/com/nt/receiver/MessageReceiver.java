//MessageReceiver.java(18.05.2025)
package com.nt.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
    
	@JmsListener(destination="testmq")
	public void readMessage(String text) {
		System.out.println("Message::"+text);
	}
}
