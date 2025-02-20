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

    @Field(type = FieldType.Text, analyzer = "standard")
    private String brand;

    @Field(type = FieldType.Text, analyzer = "standard")
    private String color;

    @Field(type = FieldType.Text, analyzer = "standard")
    private String imageUrl;

    @Field(type = FieldType.Object)
    private List<String> tags;

    @Field(type = FieldType.Object)
    private Map<String, String> attributes;

}
