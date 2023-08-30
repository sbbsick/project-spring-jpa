package com.exemplonelioalves.cursospring.controllers;

import com.exemplonelioalves.cursospring.entities.Category;
import com.exemplonelioalves.cursospring.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<Category>> findAll(){
        return ResponseEntity.ok().body(categoryService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(categoryService.findById(id));
    }
}
