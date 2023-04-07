package com.altrahouse.rabbitmqmessagequeue.publisher;

import com.altrahouse.rabbitmqmessagequeue.config.MessageConfig;
import com.altrahouse.rabbitmqmessagequeue.dto.LoginClass;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/login")
public class LoginPublisher {


    @Autowired
    private RabbitTemplate template;

    @PostMapping("/event")
    public String recordLoginEvent(@RequestBody LoginClass loginDetails) {

    loginDetails.setLoginId(UUID.randomUUID().toString());
    System.out.println("print");

    //Use convert & send method with parameters: String exchange, String Routing Key, Object (loginStatus)
    template.convertAndSend(MessageConfig.EXCHANGE, MessageConfig.ROUTING_KEY, loginDetails);
        return "Login event details have been recorded: " +loginDetails;

    }

    @GetMapping("/get")
    public String testGetMapping() {
        return "Get Mapping works";
    }

}
