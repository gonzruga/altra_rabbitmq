package com.altrahouse.rabbitmqmessagequeue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
public class RabbitmqMessageQueueApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqMessageQueueApplication.class, args);
	}



}
/*

	@GetMapping("/log")
	public List<LoginClass> testLoginMethod(){
		return List.of(
				new LoginClass(
						"axbkLoginID","marko@altra.one", "Estonia", "Tallinn", "admin", 3500
				)
		);
	}

 */