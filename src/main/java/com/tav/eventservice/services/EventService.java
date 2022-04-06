package com.tav.eventservice.services;

import com.tav.eventservice.dto.EventDto;
import com.tav.eventservice.entities.Event;
import com.tav.eventservice.errors.exceptions.Constraint;
import com.tav.eventservice.errors.exceptions.InvalidInputException;
import com.tav.eventservice.repositories.EventRepository;
import com.tav.eventservice.util.ObjectMappingUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    public EventDto createEvent(final EventDto eventDto) throws InvalidInputException {
        if (eventDto.getEndDate().isBefore(eventDto.getStartDate())) {
            throw new InvalidInputException(Constraint.START_DATE_AT_OR_BEFORE_END_DATE);
        }

        final Event event = ObjectMappingUtil.eventDtoToEntity(eventDto);
        final Event eventAfterCreation = eventRepository.save(event);
        return ObjectMappingUtil.eventEntityToDto(eventAfterCreation);
    }

    public EventDto getEvent(final long id) {
         Optional<Event> eventOpt = eventRepository.findById(id);
         if (eventOpt.isEmpty()) {
             return null;
         }
        return ObjectMappingUtil.eventEntityToDto(eventOpt.get());
    }

    public EventDto updateEvent(final EventDto eventDto) throws InvalidInputException {
        if (eventDto.getId() == null) {
            throw new InvalidInputException(Constraint.REQUIRED_ARGUMENTS_MISSING);
        }

        if (eventDto.getEndDate().isBefore(eventDto.getStartDate())) {
            throw new InvalidInputException(Constraint.START_DATE_AT_OR_BEFORE_END_DATE);
        }

        final Event event = ObjectMappingUtil.eventDtoToEntity(eventDto);
        final Event eventAfterCreation = eventRepository.save(event);
        return ObjectMappingUtil.eventEntityToDto(eventAfterCreation);
    }

    public void deleteEvent(final long id) {
        eventRepository.deleteById(id);
    }
}
