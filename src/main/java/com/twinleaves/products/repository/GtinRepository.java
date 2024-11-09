package com.twinleaves.products.repository;

import com.twinleaves.products.entity.Gtin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GtinRepository extends JpaRepository<Gtin, Integer> {

    Optional<Gtin> findByGtin(String gtin);
}
