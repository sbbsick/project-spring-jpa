package com.exemplonelioalves.cursospring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data // @Data is a Lombok annotation to create all getters, setters, equals, hashcode and toString methods, based on fields.
@Entity // @Entity is a JPA annotation to map the class as an entity.
@Table(name = "tb_user") // @Table is a JPA annotation to map the class as a table and set the table name.
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    public User() { }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    @JsonIgnore // @JsonIgnore is a Jackson annotation to ignore the attribute in the JSON serialization.
    @OneToMany(mappedBy = "client") // @OneToMany is a JPA annotation to map a one-to-many relationship.
    @Setter(AccessLevel.NONE) // @Setter is a Lombok annotation to create a setter method and AccessLevel is a Lombok enum to set the access level.
    private List<Order> orders = new ArrayList<>();
}
