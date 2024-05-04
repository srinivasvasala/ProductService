package com.srinivas.productservice.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(generator = "generator_name")
    @GenericGenerator(name="generator_name")
    @Column(name="id",columnDefinition = "binary(16),nullable=false,updatable=false")
     private UUID id;

}
