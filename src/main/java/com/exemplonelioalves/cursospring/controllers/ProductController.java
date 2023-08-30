package com.exemplonelioalves.cursospring.controllers;

import com.exemplonelioalves.cursospring.entities.Category;
import com.exemplonelioalves.cursospring.entities.Product;
import com.exemplonelioalves.cursospring.service.CategoryService;
import com.exemplonelioalves.cursospring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok().body(productService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(productService.findById(id));
    }
}
