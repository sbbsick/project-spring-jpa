package com.exemplonelioalves.cursospring.config;

import com.exemplonelioalves.cursospring.entities.*;
import com.exemplonelioalves.cursospring.entities.enums.OrderStatus;
import com.exemplonelioalves.cursospring.repository.*;
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
    private final OrderItemRepository orderItemRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");


        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        User user0 = new User(null, "Silas", "silas@ggmail.com", "99999999", "12345");
        User user1 = new User(null, "Benicio", "Benicio@ggmail.com", "99999999", "12345");
        User user2 = new User(null, "Ligia", "Ligia@ggmail.com", "99999999", "12345");
        User user3 = new User(null, "Mingo", "Mingo@ggmail.com", "99999999", "12345");

        Order o1 = new Order(null, Instant.parse("2023-06-20T19:53:07Z"), user0, OrderStatus.PAID);
        Order o2 = new Order(null, Instant.parse("2023-03-21T03:42:10Z"), user1, OrderStatus.WAITING_PAYMENT);
        Order o3 = new Order(null, Instant.parse("2023-05-22T15:21:22Z"), user2, OrderStatus.SHIPPED);
        Order o4 = new Order(null, Instant.parse("2023-08-22T15:21:22Z"), user3, OrderStatus.CANCELED);


        userRepository.saveAll(Arrays.asList(user0, user1, user2, user3));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
        OrderItem oi5 = new OrderItem(o4, p4, 2, p4.getPrice());



        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4, oi5));


    }
}
