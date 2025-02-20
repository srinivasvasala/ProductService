package com.srinivas.productservice.Service;

import com.srinivas.productservice.DTOs.GenericProductDto;
import com.srinivas.productservice.Exception.ProductNotFoundException;
import com.srinivas.productservice.Models.Product;
import com.srinivas.productservice.Repository.ProductRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SelfProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    public SelfProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Cacheable(value = "products", key = "#id")
    @Override
    public GenericProductDto getProductById(String authToken, UUID id) throws ProductNotFoundException {
        // Make a DB call & get the product with given id.
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product Not Found with id: " + id));

        // Convert existingProduct to GenericProductDto
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(existingProduct.getId());
        genericProductDto.setTitle(existingProduct.getTitle());
        genericProductDto.setDescription(existingProduct.getDescription());
        genericProductDto.setImage(existingProduct.getImage());
        genericProductDto.setCategory(existingProduct.getCategory());

        return genericProductDto;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        PageRequest pageRequest = PageRequest.of(0, 10); // Adjust pagination as needed
        List<Product> products = productRepository.findAllByTitleContainingIgnoreCase("iPhone", pageRequest);
        // Convert products to List<GenericProductDto> and return
        // Implement conversion logic
        return null;
    }

    @CacheEvict(value = "products", key = "#id")
    @Override
    public GenericProductDto deleteProductById(UUID id) throws ProductNotFoundException {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product Not Found with id: " + id));
        productRepository.deleteById(id);
        // Convert existingProduct to GenericProductDto and return+
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(existingProduct.getId());
        genericProductDto.setTitle(existingProduct.getTitle());
        genericProductDto.setDescription(existingProduct.getDescription());
        genericProductDto.setImage(existingProduct.getImage());
        genericProductDto.setCategory(existingProduct.getCategory());
        return genericProductDto;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        Product product = new Product();
        product.setTitle(genericProductDto.getTitle());
        product.setImage(genericProductDto.getImage());
        product.setDescription(genericProductDto.getDescription());
        product.setCategory(genericProductDto.getCategory());

        Product savedProduct = productRepository.save(product);

        // Convert savedProduct to GenericProductDto and return
        GenericProductDto savedProductDto = new GenericProductDto();
        savedProductDto.setId(savedProduct.getId());
        savedProductDto.setTitle(savedProduct.getTitle());
        savedProductDto.setDescription(savedProduct.getDescription());
        savedProductDto.setImage(savedProduct.getImage());
        savedProductDto.setCategory(savedProduct.getCategory());
        return savedProductDto;
    }

    @CachePut(value = "products", key = "#id")
    @Override
    public Product updateProductById(UUID id, Product product) throws ProductNotFoundException {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product Not Found with id: " + id));

        existingProduct.setTitle(product.getTitle());
        existingProduct.setImage(product.getImage());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setCategory(product.getCategory());

        return productRepository.save(existingProduct);
    }
}
