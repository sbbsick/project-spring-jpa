package com.exemplonelioalves.cursospring.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data // @Data is a Lombok annotation to create all getters, setters, equals, hashcode and toString methods, based on fields.
@Entity // @Entity is a JPA annotation to map the class as an entity.
@Table(name = "tb_category") // @Table is a JPA annotation to map the class as a table and set the table name.
public class Category implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonIgnore
    @Setter(AccessLevel.NONE)
    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();

    public Category() { }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
