package com.exemplonelioalves.cursospring.entities;

import com.exemplonelioalves.cursospring.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
@AllArgsConstructor
@Entity
@Table(name = "tb_order")
public class Order {

    public Order() { }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT") // @JsonFormat is a Jackson annotation to format the attribute in the JSON serialization.
    private Instant moment;

    @ManyToOne // @ManyToOne is a JPA annotation to map a many-to-one relationship.
    @JoinColumn(name = "client_id") // @JoinColumn is a JPA annotation to map a foreign key column.
    private User client;

    private Integer orderStatus;

    public Order(Long id, Instant moment, User client, OrderStatus orderStatus) {
        this.id = id;
        this.moment = moment;
        this.client = client;
        setOrderStatus(orderStatus);
    }

    public OrderStatus getOrderStatus(){
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus){
        if(orderStatus != null){
            this.orderStatus = orderStatus.getCode();
        }
    }
}
