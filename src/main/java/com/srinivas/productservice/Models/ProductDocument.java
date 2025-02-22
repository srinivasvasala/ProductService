package com.srinivas.productservice.Models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Document(indexName = "products")
public class ProductDocument {
    @Field(type = FieldType.Keyword)
    private String id;

    @Field(type = FieldType.Text,analyzer = "standard")
    private String name;

    @Field(type = FieldType.Text, analyzer = "standard")
    private String description;

    @Field(type = FieldType.Keyword)
    private String category;

    @Field(type = FieldType.Double)
    private Double price;

    @Field(type = FieldType.Integer)
    private Integer stockQuantity;

    @Field(type = FieldType.Double)
    private Double rating;

    @Field(type = FieldType.Text, analyzer = "standard")
    private String brand;

    @Field(type = FieldType.Text)
    private String searchableText;
//    @Field(type = FieldType.Text, analyzer = "standard")
//    private String color;

//    @Field(type = FieldType.Text, analyzer = "standard")
//    private String imageUrl;

//    @Field(type = FieldType.Object)
//    private List<String> tags;

//    @Field(type = FieldType.Object)
//    private Map<String, String> attributes;

    public ProductDocument fromProduct(Product product){
        ProductDocument doc = new ProductDocument();
        doc.setId(String.valueOf(product.getId()));
        doc.setName(product.getTitle());
        doc.setDescription(product.getDescription());
        doc.setCategory(product.getCategory().getName());
        doc.setPrice(product.getPrice().getValue());
        doc.setStockQuantity(product.getInventoryCount());
        doc.setRating(product.getRating());
        doc.setBrand(product.getBrand());

        String searchableAttributes = String.join(
                " ", product.getTitle(),
                product.getDescription(),
                product.getCategory().getName(),
                product.getBrand()
        ).toLowerCase();
        doc.setSearchableText(searchableAttributes);

        return doc;
    }





}
