package com.tav.eventservice.services;

import com.tav.eventservice.dto.EventDto;
import com.tav.eventservice.dto.UserDto;
import com.tav.eventservice.entities.Event;
import com.tav.eventservice.entities.User;
import com.tav.eventservice.repositories.EventRepository;
import com.tav.eventservice.repositories.UserRepository;
import com.tav.eventservice.util.ObjectMappingUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    public UserDto create(final UserDto userDto) {
        final User user = ObjectMappingUtil.userDtoToEntity(userDto);
        return ObjectMappingUtil.userEntityToDto(userRepository.save(user));
    }

    public EventDto attendEvent(final long userId, final long eventId) {
        final Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()) {
            throw new RuntimeException("User with id: " + userId + " doesn't exist");
        }

        final Optional<Event> eventOpt = eventRepository.findById(eventId);
        if (eventOpt.isEmpty()) {
            throw new RuntimeException("Event with id: " + eventId + " doesn't exist");
        }

        if (userRepository.existsByEventsId(eventId)) {
            throw new RuntimeException("User is already attending the event");
        }

        final Event event = eventOpt.get();
        event.getUsers().add(userOpt.get());
        return ObjectMappingUtil.eventEntityToDto(eventRepository.save(event));
    }

    public UserDto get(final long id) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isEmpty()) {
            return null;
        }
        return ObjectMappingUtil.userEntityToDto(userOpt.get());
    }

    public UserDto get(final String email) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isEmpty()) {
            return null;
        }
        return ObjectMappingUtil.userEntityToDto(userOpt.get());
    }
}
