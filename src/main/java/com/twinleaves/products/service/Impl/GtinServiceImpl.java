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
            JOIN Product p ON g.id = p.productId
            JOIN Batch b ON b.batchId = p.productId
            WHERE b.available_quantity > 0
               OR (b.available_quantity <= 0 AND b.inwarded_on = (
                    SELECT MAX(b2.inwarded_on)
                    FROM batch b2
                    WHERE b2.product_id = p.product_id AND b2.available_quantity <= 0
                  ))
            ORDER BY g.gtin, b.inwarded_on
        """;

        Query nativeQuery = entityManager.createQuery(sqlQuery);
        return nativeQuery.getResultList();
    }
}
