package com.srinivas.productservice.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "products")
public class Product extends BaseModel {
    @Column(nullable = false)
    private String title;
    @Column(length = 2000)
    private String description;
    private String image;
    //Category isn't a primitive attribute, it's a relation.
    //category_id in the product table.
    @ManyToOne(optional = false)
    private Category category;

    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private Price price;
    @Column(name = "stock_count")
    private Integer inventoryCount;
    @Version
    private Long version;

}
