package com.srinivas.productservice.DTOs;

import com.srinivas.productservice.Models.Category;
import com.srinivas.productservice.Models.Product;
import com.srinivas.productservice.Models.ProductDocument;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class GenericProductDto {
    private UUID id;
    private String title;
    private double price;
    private Category category;
    private String description;
    private String image;
    private int inventoryCount;

    public static GenericProductDto from(Product product) {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setTitle(product.getTitle());
        genericProductDto.setDescription(product.getDescription());
        //genericProductDto.setPrice(product.getPrice());
        genericProductDto.setImage(product.getImage());
        //genericProductDto.setId(product.getId());
        genericProductDto.setInventoryCount(product.getInventoryCount());
        return genericProductDto;
    }
}