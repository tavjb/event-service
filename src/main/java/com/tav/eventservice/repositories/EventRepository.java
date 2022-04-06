package com.tav.eventservice.repositories;

import com.tav.eventservice.entities.Event;
import com.tav.eventservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
