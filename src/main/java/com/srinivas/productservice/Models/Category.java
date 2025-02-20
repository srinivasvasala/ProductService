package com.srinivas.productservice.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category extends BaseModel{

    @Column(nullable = false)
    private String name;
    @OneToMany(fetch = jakarta.persistence.FetchType.EAGER,mappedBy = "category")
    private List<Product> products;
}
