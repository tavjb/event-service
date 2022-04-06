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
		ApplicationContext ctx = SpringApplication.run(EventServiceApplication.class, args);
//		final EventRepository eventRepository = ctx.getBean(EventRepository.class);
//
//		eventRepository.save(event);
//				Event event = Event.builder()
//				.title("Tool concert")
//				.startDate(LocalDate.of(2022, 5, 4))
//				.endDate(LocalDate.of(2022, 5, 4));
//
		final UserService userService = ctx.getBean(UserService.class);

//		userService.createUser(
//			User.builder()
//					.email("tav@gmail.com")
//					.password("1234")
//					.build()
//		);

		userService.attendEvent(1L, 1L);

	}

}
