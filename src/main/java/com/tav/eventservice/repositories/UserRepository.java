package com.tav.eventservice.repositories;

import com.tav.eventservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEventsId(long id);
    List<User> getUsersByEventsId(long id);
    Optional<User> findByEmail(String email);
}
