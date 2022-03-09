package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDTO {
    //@JsonProperty("product-name") for referencing json name in swagger
    private String productName;
    private Long price;
    private Long stock;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }
}
