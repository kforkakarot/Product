package com.twinleaves.products.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Batch {

    @Id
    private String batchId;

    private Integer Mrp;

    private Integer sp;

    private Integer purchasePrice;

    private Integer availableQuantity;

    private LocalDate inwardedOn;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}

