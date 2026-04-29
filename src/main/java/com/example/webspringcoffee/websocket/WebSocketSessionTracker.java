package com.example.webspringcoffee.websocket;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class WebSocketSessionTracker {

	private final ConcurrentHashMap<String, String> sessions = new ConcurrentHashMap<>();

	@EventListener
	public void handleConnect(SessionConnectEvent event) {
		String sessionId = event.getMessage().getHeaders().get("simpSessionId").toString();
		sessions.put(sessionId, "CONNECTED");
		System.out.println("User connected: " + sessionId);
	}

	@EventListener
	public void handleDisconnect(SessionDisconnectEvent event) {
		String sessionId = event.getSessionId();
		sessions.remove(sessionId);
		System.out.println("User disconnected: " + sessionId);
	}
}