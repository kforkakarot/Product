package com.twinleaves.products.service;

import com.twinleaves.products.dto.ProductDTO;
import com.twinleaves.products.entity.Batch;
import com.twinleaves.products.entity.Gtin;
import com.twinleaves.products.entity.Product;

public interface ProductService {

    Product addProduct(ProductDTO productdto);
    Product getProductById(Integer id);


    Batch addBatch(Batch batch);
    Batch getBatchById(String id);


    Gtin addGtin(Gtin gtin);
    Gtin getGtinById(Integer id);

}
