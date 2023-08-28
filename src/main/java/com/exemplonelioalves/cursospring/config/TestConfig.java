package com.exemplonelioalves.cursospring.config;

import com.exemplonelioalves.cursospring.entities.User;
import com.exemplonelioalves.cursospring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;


@Configuration
@Profile("test")
@RequiredArgsConstructor
public class TestConfig implements CommandLineRunner {
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user0 = new User(null, "Silas", "silas@ggmail.com", "99999999", "12345");
        User user1 = new User(null, "Benicio", "Benicio@ggmail.com", "99999999", "12345");
        User user2 = new User(null, "Ligia", "Ligia@ggmail.com", "99999999", "12345");
        User user3 = new User(null, "Mingo", "Mingo@ggmail.com", "99999999", "12345");
        userRepository.saveAll(Arrays.asList(user0, user1, user2, user3));
    }
}
