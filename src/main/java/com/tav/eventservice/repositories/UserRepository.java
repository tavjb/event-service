package com.tav.eventservice.repositories;

import com.tav.eventservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEventsId(final long id);
    List<User> getUsersByEventsId(final long id);
}
