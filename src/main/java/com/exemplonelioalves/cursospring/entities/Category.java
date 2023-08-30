package com.exemplonelioalves.cursospring.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tb_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonIgnore
    @Setter(AccessLevel.NONE)
    @ManyToMany(mappedBy = "categories") // categories = name of the Set<Category> attribute in Product class.
    private Set<Product> products = new HashSet<>();

    public Category() { }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
