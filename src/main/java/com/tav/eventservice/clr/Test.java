package com.tav.eventservice.clr;

import com.tav.eventservice.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class Test implements CommandLineRunner {
    private final RestTemplate restTemplate;

    @Override
    public void run(String... args) throws Exception {
        final ResponseEntity<UserDto> res = restTemplate.exchange(
                "http://localhost:8080/user/1", HttpMethod.GET, null, UserDto.class
        );

        System.out.println("Response body: " + res.getBody());
    }
}
