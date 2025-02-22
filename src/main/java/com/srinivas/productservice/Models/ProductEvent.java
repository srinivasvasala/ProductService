package com.srinivas.productservice.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProductEvent implements Serializable {
    private String eventId;
    private ProductEventType eventType;
    private String productId;
    private LocalDateTime timestamp;
    private String userId;
    private Map<String,Object>oldValues;
    private Map<String,Object>newValues;
    private String message;

    @JsonIgnore
    private transient Product product;

    public ProductEvent(ProductEventType eventType,String productId, Product product){
        this.eventId = UUID.randomUUID().toString();
        this.eventType = eventType;
        this.productId = productId;
        this.timestamp = LocalDateTime.now();
        this.oldValues = new HashMap<>();
        this.newValues = new HashMap<>();
    }

    @Builder
    public ProductEvent (ProductEventType eventType, String productId,
                         Map<String,Object> oldValues,
                         Map<String,Object> newValues,
                         Product product, String userId,
                         String message){
        this.eventId = UUID.randomUUID().toString();
        this.eventType = eventType;
        this.productId = productId;
        this.timestamp = LocalDateTime.now();
        this.oldValues = oldValues;
        this.newValues = newValues;
        this.product = product;
        this.userId = userId;
        this.message = message;
    }

    public static ProductEvent CreatePriceChangeEvent(String productId, BigDecimal oldPrice, BigDecimal newPrice, String userId){

        return ProductEvent.builder()
                .eventType(ProductEventType.PRICE_CHANGE)
                .productId(productId)
                .oldValues(Map.of("oldPrice", oldPrice))
                .newValues(Map.of("newPrice", newPrice))
                .userId(userId)
                .message("Price changed from " + oldPrice + " to " + newPrice)
                .build();
    }
    public static ProductEvent CreateStockChangeEvent(String productId, Integer oldStock, Integer newStock, String userId){

        return ProductEvent.builder()
                .eventType(ProductEventType.STOCK_CHANGE)
                .productId(productId)
                .oldValues(Map.of("oldStock", oldStock))
                .newValues(Map.of("newStock", newStock))
                .userId(userId)
                .message("Stock changed from " + oldStock + " to " + newStock)
                .build();
    }
    public static ProductEvent CreateProductCreatedEvent(String productId, Product product, String userId){

        return ProductEvent.builder()
                .eventType(ProductEventType.PRODUCT_CREATED)
                .productId(productId)
                .product(product)
                .userId(userId)
                .message("Product created")
                .build();
    }

    public static ProductEvent CreateProductUpdatedEvent(String productId, Product product, String userId){

        return ProductEvent.builder()
                .eventType(ProductEventType.PRODUCT_UPDATED)
                .productId(productId)
                .product(product)
                .userId(userId)
                .message("Product updated")
                .build();
    }
    public static ProductEvent CreateProductDeletedEvent(String productId, Product product, String userId){

        return ProductEvent.builder()
                .eventType(ProductEventType.PRODUCT_DELETED)
                .productId(productId)
                .product(product)
                .userId(userId)
                .message("Product deleted")
                .build();
    }




}
