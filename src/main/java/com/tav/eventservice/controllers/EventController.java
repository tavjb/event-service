package com.tav.eventservice.controllers;

import com.tav.eventservice.dto.EventDto;
import com.tav.eventservice.errors.exceptions.InvalidInputException;
import com.tav.eventservice.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("event")
@RestController
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public EventDto createEvent(@RequestBody final EventDto event) throws InvalidInputException {
        return eventService.createEvent(event);
    }

    @PutMapping
    public EventDto updateEvent(@RequestBody final EventDto event) throws InvalidInputException {
        return eventService.updateEvent(event);
    }


    @GetMapping("{id}")
    public EventDto getEvent(@PathVariable final long id) {
        return eventService.getEvent(id);
    }
}
