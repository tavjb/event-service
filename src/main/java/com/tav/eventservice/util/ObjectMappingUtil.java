package com.tav.eventservice.util;

import com.tav.eventservice.dto.EventDto;
import com.tav.eventservice.dto.UserDto;
import com.tav.eventservice.entities.Event;
import com.tav.eventservice.entities.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
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

    public static User userDtoToEntity(final UserDto dto) {
        return User.builder()
                .email(dto.getEmail())
                .password(dto.getPassword().hashCode())
                .build();
    }

    public static UserDto userEntityToDto(final User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }

    public static UserDetails userToSpringSecurityUser(final User user) {
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                String.valueOf(user.getPassword()),
                new ArrayList<>()
        );
    }
}
