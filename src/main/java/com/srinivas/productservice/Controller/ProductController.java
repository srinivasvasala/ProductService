package com.srinivas.productservice.Controller;

import com.srinivas.productservice.DTOs.GenericProductDto;
import com.srinivas.productservice.Exception.ProductNotFoundException;
import com.srinivas.productservice.Service.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/{id}")
    public GenericProductDto getProductById(@RequestHeader(value = HttpHeaders.AUTHORIZATION, required = false) String authToken, @PathVariable("id") UUID id) throws ProductNotFoundException {
        return productService.getProductById(authToken,id);
    }

    @GetMapping
    public List<GenericProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") UUID id) {
        try {
            return productService.deleteProductById(id);
        } catch (ProductNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto) {
        return productService.createProduct(genericProductDto);
    }

    public void updateProductById() {

    }
}
