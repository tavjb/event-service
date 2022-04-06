package com.tav.eventservice.util;

import com.tav.eventservice.dto.EventDto;
import com.tav.eventservice.entities.Event;

public class ObjectMappingUtil {
    public static Event eventDtoToEntity(final EventDto eventDto) {
        return Event.builder()
                .title(eventDto.getTitle())
                .startDate(eventDto.getStartDate())
                .endDate(eventDto.getEndDate())
                .build();
    }

    public static EventDto eventEntityToDto(final Event event) {
        return EventDto.builder()
                .id(event.getId())
                .title(event.getTitle())
                .startDate(event.getStartDate())
                .endDate(event.getEndDate())
                .build();
    }
}
