package com.websocket.springandsocket.controller;

import com.websocket.springandsocket.entity.Greeting;
import com.websocket.springandsocket.entity.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class WebSocketController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(Message message) {
       return new Greeting("Привет,"+ HtmlUtils.htmlEscape(message.getName()));
    }
}
