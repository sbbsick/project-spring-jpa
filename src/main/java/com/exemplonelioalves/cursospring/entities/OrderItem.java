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

    private Double price;
    private Double subTotal;

    @EmbeddedId
    private OrderItemPk id = new OrderItemPk();

    public OrderItem() { }

    public OrderItem(Order order, Product product, Double price, Double subTotal) {
        this.price = price;
        this.subTotal = subTotal;
        id.setOrder(order);
        id.setProduct(product);
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


