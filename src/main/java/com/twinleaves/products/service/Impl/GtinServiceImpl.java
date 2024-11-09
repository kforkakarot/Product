package com.twinleaves.products.service.Impl;

import com.twinleaves.products.service.GtinService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GtinServiceImpl implements GtinService {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Object[]> getGtinWithBatches() {

        String sqlQuery = """
            SELECT g.gtin, b.batchId, b.availableQuantity
            FROM Gtin g
            JOIN Product p ON g.product.productId = p.productId
            JOIN Batch b ON b.product.productId = p.productId
            WHERE b.availableQuantity > 0
               OR (b.availableQuantity <= 0 AND b.inwardedOn = (
                    SELECT MAX(b2.inwardedOn)
                    FROM Batch b2
                    WHERE b2.product.productId = p.productId AND b2.availableQuantity <= 0
                  ))
            ORDER BY g.gtin, b.inwardedOn
        """;


        Query nativeQuery = entityManager.createQuery(sqlQuery);
        return nativeQuery.getResultList();
    }
}
