package com.tav.eventservice;

import com.tav.eventservice.entities.Event;
import com.tav.eventservice.entities.User;
import com.tav.eventservice.repositories.EventRepository;
import com.tav.eventservice.repositories.UserRepository;
import com.tav.eventservice.services.EventService;
import com.tav.eventservice.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class EventServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventServiceApplication.class, args);

	}

}
