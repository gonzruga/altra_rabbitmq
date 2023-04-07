package com.altrahouse.rabbitmqmessagequeue.consumer;

import com.altrahouse.rabbitmqmessagequeue.config.MessageConfig;
import com.altrahouse.rabbitmqmessagequeue.dto.LoginClass;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumeClass {


//    @RabbitListener(queues = MessageConfig.QUEUE)
    public void consumeMessageFromQueue(LoginClass loginDetails) {
    System.out.println("Login details received from queue: " + loginDetails);
}

}
