package com.example.demo;

import com.example.demo.controller.ProductController;
import com.example.demo.dto.ProductDTO;
import com.example.demo.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	ProductService productService;

	@Test
	void contextLoads() {
	}

	@Test
	void testAddNewProductSuccess(){
		ProductDTO request = new ProductDTO();
		request.setProductName("Juni");
		request.setPrice((long)112);
		request.setStock((long)899);

		productService.add(request);
	}
}
