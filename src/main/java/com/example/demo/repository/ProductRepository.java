package com.example.demo.repository;

import com.example.demo.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    //JPQL - Java Programming Query Language
    List<ProductEntity> findByStockGreaterThanEqual(long value);

    // task prices less than equal
    List<ProductEntity> findByPriceLessThanEqual(long value);

    List<ProductEntity> findByStockGreaterThanEqualAndPriceLessThanEqual(long value, long price);
}
