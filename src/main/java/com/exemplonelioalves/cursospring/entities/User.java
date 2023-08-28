package com.exemplonelioalves.cursospring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data // @Data is a Lombok annotation to create all getters, setters, equals, hashcode and toString methods, based on fields.
@ToString // @ToString is a Lombok annotation to create a toString method.
@AllArgsConstructor // @AllArgsConstructor is a Lombok annotation to create a constructor with all arguments.
@Entity // @Entity is a JPA annotation to map the class as an entity.
@Table(name = "tb_user") // @Table is a JPA annotation to map the class as a table and set the table name.
public class User {

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

}
