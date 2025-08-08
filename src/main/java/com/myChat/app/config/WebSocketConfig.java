package com.myChat.app.config;

import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Controller
@EnableWebSocketMessageBroker
//Message Broking is a way of routing a message
//Its like a middleman, It is going to direct the message into right place
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/chat")
            .setAllowedOrigins("http://localhost:8080")
            .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
    //set message broker
        registry.enableSimpleBroker("/topic"); //topic/chatroom1
        registry.setApplicationDestinationPrefixes("/app");
    }
}
