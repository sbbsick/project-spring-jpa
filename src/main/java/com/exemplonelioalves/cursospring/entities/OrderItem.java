package com.exemplonelioalves.cursospring.entities;

import com.exemplonelioalves.cursospring.entities.pk.OrderItemPk;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer quantity;
    private Double price;

    @EmbeddedId
    private OrderItemPk id = new OrderItemPk();

    public OrderItem() { }

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }
    
    public Order getOrder() {
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }

    @JsonIgnore
    public Product getProduct() {
        return id.getProduct();
    }
}


