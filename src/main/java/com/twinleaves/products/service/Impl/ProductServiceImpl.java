package com.twinleaves.products.service.Impl;

import com.twinleaves.products.dto.ProductDTO;
import com.twinleaves.products.entity.Batch;
import com.twinleaves.products.entity.Gtin;
import com.twinleaves.products.entity.Product;
import com.twinleaves.products.exceptions.BatchNotFoundException;
import com.twinleaves.products.exceptions.GtinNotFoundException;
import com.twinleaves.products.exceptions.ProductNotFoundException;
import com.twinleaves.products.repository.BatchRepository;
import com.twinleaves.products.repository.GtinRepository;
import com.twinleaves.products.repository.ProductRepository;
import com.twinleaves.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final BatchRepository batchRepository;
    private final GtinRepository gtinRepository;

    @Override
    public Product addProduct(ProductDTO productdto) {
         Product product= new Product();
         product.setProductName(productdto.getProductName());
         product.setCreatedOn(LocalDate.now());
         return productRepository.save(product);
    }

    @Override
    public Product getProductById(Integer id) throws ProductNotFoundException {
        if(productRepository.findById(id).isPresent()) return productRepository.findById(id).get();
        throw new ProductNotFoundException("No such Product found");
    }

    @Override
    public Batch addBatch(Batch batch) {
        return batchRepository.save(batch);
    }

    @Override
    public Batch getBatchById(String id)  throws BatchNotFoundException {
        if(batchRepository.findById(id).isPresent()) return batchRepository.findById(id).get();
        throw new BatchNotFoundException("No such Batch found");
    }

    @Override
    public Gtin addGtin(Gtin gtin) {
        return gtinRepository.save(gtin);
    }

    @Override
    public Gtin getGtinById(Integer id) throws GtinNotFoundException{
        if(gtinRepository.findById(id).isPresent())return gtinRepository.findById(id).get();
        throw new GtinNotFoundException("No such Gtin found");
    }
}
