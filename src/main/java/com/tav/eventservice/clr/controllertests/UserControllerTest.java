package com.tav.eventservice.clr.controllertests;

import com.tav.eventservice.dto.UserDto;
import com.tav.eventservice.errors.exceptions.TestFailedException;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static com.tav.eventservice.clr.constants.TestConstants.*;

@Component
@Profile("test")
@RequiredArgsConstructor
public class UserControllerTest implements CommandLineRunner {
    private final RestTemplate restTemplate;

    @Override
    public void run(String... args) throws Exception {
        if (!testCreateUserNotNull()) {
            throw new TestFailedException("testCreateUser");
        } else {
            System.out.println("testCreateUser passed!");
        }
    }

    private boolean testCreateUserNotNull() {
        try {
            UserDto userDto = UserDto.builder().email(EMAIL_3).password(PASSWORD_1).build();

            final ResponseEntity<UserDto> response = restTemplate.postForEntity(
                    "http://localhost:8080/user", userDto, UserDto.class
            );

            final UserDto userDtoRes = response.getBody();
            return userDtoRes != null;
        } catch (Exception e) {
            return false;
        }
    }
}
