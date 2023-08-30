package com.exemplonelioalves.cursospring.service;

import com.exemplonelioalves.cursospring.entities.Category;
import com.exemplonelioalves.cursospring.entities.Product;
import com.exemplonelioalves.cursospring.repository.CategoryRepository;
import com.exemplonelioalves.cursospring.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found"));
    }
}
