package com.exemplonelioalves.cursospring.config;

import com.exemplonelioalves.cursospring.entities.Order;
import com.exemplonelioalves.cursospring.entities.User;
import com.exemplonelioalves.cursospring.repository.OrderRepository;
import com.exemplonelioalves.cursospring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;


@Configuration
@Profile("test")
@RequiredArgsConstructor
public class TestConfig implements CommandLineRunner {
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        User user0 = new User(null, "Silas", "silas@ggmail.com", "99999999", "12345");
        User user1 = new User(null, "Benicio", "Benicio@ggmail.com", "99999999", "12345");
        User user2 = new User(null, "Ligia", "Ligia@ggmail.com", "99999999", "12345");
        User user3 = new User(null, "Mingo", "Mingo@ggmail.com", "99999999", "12345");

        Order o1 = new Order(null, Instant.parse("2023-06-20T19:53:07Z"), user0);
        Order o2 = new Order(null, Instant.parse("2023-03-21T03:42:10Z"), user1);
        Order o3 = new Order(null, Instant.parse("2023-05-22T15:21:22Z"), user2);
        Order o4 = new Order(null, Instant.parse("2023-08-22T15:21:22Z"), user3);


        userRepository.saveAll(Arrays.asList(user0, user1, user2, user3));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));

    }
}
