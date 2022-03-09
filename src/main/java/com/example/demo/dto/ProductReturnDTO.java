package com.example.demo.dto;

import com.example.demo.entity.ProductEntity;

public class ProductReturnDTO {
    private String name;
    private long stock;
    private long price;
    private String desc;

    public ProductReturnDTO(ProductEntity entity) {
        if (entity.getStock() <= 0){
            desc = "Out of Stock";
        } else {
            desc = "Available";
        }

        this.name = entity.getName();
        this.stock = entity.getStock();
        this.price = entity.getPrice();
    }

    public String getName() {
        return name;
    }

    public long getStock() {
        return stock;
    }

    public long getPrice() {
        return price;
    }

    public String getDesc() {
        return desc;
    }
}
