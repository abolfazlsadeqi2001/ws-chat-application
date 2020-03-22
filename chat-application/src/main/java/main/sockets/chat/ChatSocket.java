package main.sockets.chat;

import java.util.LinkedList;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Configuration
@EnableWebSocket
public class ChatSocket implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(new ChatWebSocket(), "/chat_app");
	}
	
	class ChatWebSocket extends TextWebSocketHandler {
		private List<WebSocketSession> sessions = new LinkedList<WebSocketSession>();

		@Override
		public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
			sessions.remove(session);
		}

		@Override
		protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
			for (WebSocketSession s : sessions) {
				s.sendMessage(message);
			}
		}

		@Override
		public void afterConnectionEstablished(WebSocketSession session) throws Exception {
			sessions.add(session);
		}
		
	}
	
}
