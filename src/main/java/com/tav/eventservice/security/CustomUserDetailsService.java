package com.tav.eventservice.security;

import com.tav.eventservice.entities.User;
import com.tav.eventservice.repositories.UserRepository;
import com.tav.eventservice.util.ObjectMappingUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        return ObjectMappingUtil.userToSpringSecurityUser(getUser(email));
    }

    private User getUser(final String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}
