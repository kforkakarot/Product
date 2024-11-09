package com.twinleaves.products.config;

import com.twinleaves.products.entity.Batch;
import com.twinleaves.products.entity.Gtin;
import com.twinleaves.products.entity.Product;
import com.twinleaves.products.repository.BatchRepository;
import com.twinleaves.products.repository.GtinRepository;
import com.twinleaves.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final BatchRepository batchRepository;
    private final GtinRepository gtinRepository;

    @Override
    public void run(String... args) throws Exception {
        Product p1 = new Product("P1", "Product 1", LocalDate.of(2024, 1, 1));
        Product p2 = new Product("P2", "Product 2", LocalDate.of(2024, 1, 2));
        Product p3 = new Product("P3", "Product 3", LocalDate.of(2024, 1, 3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3));

        Batch b1 = new Batch("B1", 100, 90, 80, 100, LocalDate.of(2024, 1, 5), p1);
        Batch b2 = new Batch("B2", 100, 90, 80, -200, LocalDate.of(2024, 1, 10), p1);
        Batch b3 = new Batch("B3", 100, 90, 80, 90, LocalDate.of(2024, 1, 15), p1);
        Batch b4 = new Batch("B4", 100, 90, 80, 0, LocalDate.of(2024, 1, 20), p1);
        Batch b5 = new Batch("B5", 100, 90, 80, 110, LocalDate.of(2024, 1, 25), p1);
        Batch b6 = new Batch("B6", 100, 90, 80, -10, LocalDate.of(2024, 1, 5), p2);
        Batch b7 = new Batch("B7", 100, 90, 80, 220, LocalDate.of(2024, 1, 10), p3);
        batchRepository.saveAll(Arrays.asList(b1, b2, b3, b4, b5, b6, b7));

        Gtin g1 = new Gtin("G1_ID", "G1", p1);
        Gtin g2 = new Gtin("G2_ID", "G2", p2);
        Gtin g3 = new Gtin("G3_ID", "G3", p3);
        gtinRepository.saveAll(Arrays.asList(g1, g2, g3));
    }
}

