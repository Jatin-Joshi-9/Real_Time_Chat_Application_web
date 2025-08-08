package com.myChat.app.controller;


//This ChatController is going to handle all the incoming messages from the frontend and cast it to all the clients

import com.myChat.app.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {
    // /app/sendMessage
    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")

    public ChatMessage sendMessage(ChatMessage message){
        return message;
    }

    @GetMapping("/chat")
    public String chat(){
        return "chat";
    }
}
