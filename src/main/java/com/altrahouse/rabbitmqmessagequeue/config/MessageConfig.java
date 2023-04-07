package com.altrahouse.rabbitmqmessagequeue.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MessageConfig {
    //TODO Extract below 3 fields in a constant file or properties file. currently hard coded.
    public static final String QUEUE = "altraone_login_queue";
    public static final String EXCHANGE = "altraone_login_exchange";

    public static final String ROUTING_KEY = "altraone_login_routingKey";

    // 1. Create a Queue

    @Bean
    public Queue queue(){
        return new Queue(QUEUE);//pass the Queue name
    }
    // 2. Create an Exchange (Direct, Topic, Fanout, Header)
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE) ; // Pass the same name
    }
    // 3. Create a binding
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(ROUTING_KEY);
    }

    // Convert in order to deal not with string data type but with object.
    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }


    // Rabbit template: To enable to publish event or message to queue to consume it.
    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

}
