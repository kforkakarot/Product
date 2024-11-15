package com.twinleaves.products.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Gtin {

    @Id
    private String id;

    private String gtin;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
