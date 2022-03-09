package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.UpdateStockDTO;
import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductEntity add(ProductDTO request) {
        ProductEntity entity = new ProductEntity();

        entity.setName(request.getProductName());
        entity.setStock(request.getStock());
        entity.setPrice(request.getPrice());

        //save into db
        productRepository.save(entity);
        return entity;
    }

    // task prices less than equal
    public List<ProductEntity> fetch(long minStock, long maxPrice) {
        if (minStock > 0 && maxPrice > 0){
            return fetchStockAndPrice(minStock, maxPrice);
        }

        if (minStock > 0){
            return fetchAllInStock(minStock);
        }

        if (maxPrice > 0){
            return fetchAllUnderPrice(maxPrice);
        }

        return fetchAll();
    }

    public List<ProductEntity> fetchAll() {
        return (List<ProductEntity>) productRepository.findAll();
    }

    public List<ProductEntity> fetchStockAndPrice(long stock, long price) {
        // return all in stock
        return productRepository.findByStockGreaterThanEqualAndPriceLessThanEqual(stock, price);
    }

    public List<ProductEntity> fetchAllInStock(long value) {
        // return all in stock
        return productRepository.findByStockGreaterThanEqual(value);
    }

    public List<ProductEntity> fetchAllUnderPrice(long value) {
        // return all in stock
        return productRepository.findByPriceLessThanEqual(value);
    }

    public void delete(long id) {
        productRepository.deleteById(id);
    }

    public ProductEntity getById(long id){
        return productRepository.findById(id).orElse(new ProductEntity());
    }

    public ProductEntity updateStock(UpdateStockDTO request){
        // get product by id in database
        ProductEntity product = getById(request.getId());

        // update stock
        product.setStock(product.getStock() + request.getNumberOfStock());

        //save to database
        return productRepository.save(product);
    }
}
