package com.exemplonelioalves.cursospring.entities.enums;


public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private final int code;

    OrderStatus(int code){ // Por padrão, o construtor de um enum é private.
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static OrderStatus valueOf(int code){ // Método estático para converter um valor numérico para um tipo enumerado.
        for(OrderStatus value : OrderStatus.values()){ // isso é um for each
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code.");
    }
}
