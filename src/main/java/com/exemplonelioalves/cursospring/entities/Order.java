package com.exemplonelioalves.cursospring.entities;

import com.exemplonelioalves.cursospring.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Lombok;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT") // @JsonFormat is a Jackson annotation to format the attribute in the JSON serialization.
    private Instant moment;

    @ManyToOne // @ManyToOne is a JPA annotation to map a many-to-one relationship.
    @JoinColumn(name = "client_id") // @JoinColumn is a JPA annotation to map a foreign key column.
    private User client;

    private Integer orderStatus;

    @Getter
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();


    public Order() { }

    public Order(Long id, Instant moment, User client, OrderStatus orderStatus) {
        super();
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
