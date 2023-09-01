package com.exemplonelioalves.cursospring.service;

import com.exemplonelioalves.cursospring.entities.Category;
import com.exemplonelioalves.cursospring.entities.OrderItem;
import com.exemplonelioalves.cursospring.repository.CategoryRepository;
import com.exemplonelioalves.cursospring.repository.OrderItemRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    public List<OrderItem> findAll(){
        return orderItemRepository.findAll();
    }

    public OrderItem findById(Long id) {
        return orderItemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Order item not found"));
    }
}
