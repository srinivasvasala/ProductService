package com.srinivas.productservice.Service;

import com.srinivas.productservice.DTOs.GenericProductDto;
import com.srinivas.productservice.Exception.ProductNotFoundException;
import com.srinivas.productservice.Models.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    GenericProductDto getProductById(String authToken, UUID id) throws ProductNotFoundException;

    List<GenericProductDto> getAllProducts();

    GenericProductDto deleteProductById(UUID id) throws ProductNotFoundException;

    GenericProductDto createProduct(GenericProductDto genericProductDto);

    Product updateProductById(UUID id, Product product) throws ProductNotFoundException;
}
