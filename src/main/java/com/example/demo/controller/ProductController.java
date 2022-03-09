package com.example.demo.controller;

import com.example.demo.dto.CommonResponse;
import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.ProductReturnDTO;
import com.example.demo.dto.UpdateStockDTO;
import com.example.demo.entity.ProductEntity;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // task prices less than equal
    @GetMapping("")
    public List<ProductEntity> getProducts(
            @RequestParam(value = "minimum stock", defaultValue = "0") int minStock,
            @RequestParam(value = "maximum prices", defaultValue = "0") int maxPrice)
    {
        //TODO: Add code to get all product list here
        return productService.fetch(minStock, maxPrice);
    }

    @GetMapping("{id}")
    public ProductReturnDTO getProduct(@PathVariable("id") String id) {
        //TODO: Add code to get product here
        ProductEntity entity = productService.getById(Long.parseLong(id));
        return new ProductReturnDTO(entity);
    }

    @PostMapping("")
    public ProductEntity addProduct(@RequestBody ProductDTO product) {
        //TODO: Add code to post here00
        return productService.add(product);
    }

    @PutMapping("/stock")
    public ProductEntity updateStock(@RequestBody UpdateStockDTO request) {
        //TODO: Add code to post here
        return productService.updateStock(request);
    }

    @PutMapping("/name")
    public CommonResponse updateName() {
        //TODO: Add code to post here
        return new CommonResponse("Under Construction");
    }

    @DeleteMapping("{id}")
    public CommonResponse deleteProduct(@PathVariable("id") String id) {
        //TODO: Add code to get product list here
        productService.delete(Long.parseLong(id));
        return new CommonResponse("Successfully delete product");
    }
}
