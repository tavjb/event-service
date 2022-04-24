package com.tav.eventservice.clr;

import com.tav.eventservice.dto.UserDto;
import com.tav.eventservice.errors.exceptions.TestFailedException;
import com.tav.eventservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.tav.eventservice.clr.constants.TestConstants.EMAIL_1;
import static com.tav.eventservice.clr.constants.TestConstants.PASSWORD_1;

@Component
@Profile("test")
@RequiredArgsConstructor
public class UserTest implements CommandLineRunner {
    private final UserService userService;

    @Override
    public void run(String... args) throws TestFailedException {
        if (!testCreateUserNotNull()) {
            throw new TestFailedException("testCreateUser");
        } else {
            System.out.println("testCreateUser passed!");
        }
    }

    private boolean testCreateUserNotNull() {
        try {
            UserDto userDto = UserDto.builder()
                    .email(EMAIL_1)
                    .password(PASSWORD_1)
                    .build();

            UserDto output = userService.create(userDto);
            return output != null;
        } catch (Exception e) {
            return false;
        }
    }
}
