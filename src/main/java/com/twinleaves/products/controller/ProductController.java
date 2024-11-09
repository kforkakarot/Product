package com.twinleaves.products.controller;

import com.twinleaves.products.dto.ErrorResponse;
import com.twinleaves.products.dto.ProductDTO;
import com.twinleaves.products.entity.Batch;
import com.twinleaves.products.entity.Gtin;
import com.twinleaves.products.entity.Product;
import com.twinleaves.products.exceptions.BatchNotFoundException;
import com.twinleaves.products.exceptions.GtinNotFoundException;
import com.twinleaves.products.exceptions.ProductNotFoundException;
import com.twinleaves.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @RequestMapping(path = "/product", method = POST)
    public ResponseEntity<Product> addProduct(@RequestBody ProductDTO productdto){
        return new ResponseEntity(productService.addProduct(productdto), HttpStatus.CREATED);
    }


    @RequestMapping(path = "/batch", method = POST)
    public ResponseEntity<Batch> addBatch(@RequestBody Batch batch){
        return new ResponseEntity(productService.addBatch(batch), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/gtin", method = POST)
    public ResponseEntity<Gtin> addGtin(@RequestBody Gtin gtin){
        return new ResponseEntity(productService.addGtin(gtin), HttpStatus.CREATED);
    }



    @RequestMapping(path = "/product", method = GET)
    public ResponseEntity<?> getProductById(@RequestParam String id){
        try{
            return new ResponseEntity(productService.getProductById(id), HttpStatus.OK);
        }catch(ProductNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }



    @RequestMapping(path = "/batch", method = GET)
    public ResponseEntity<?> getBatchById(@RequestParam String id){
        try{
            return new ResponseEntity(productService.getBatchById(id), HttpStatus.OK);
        }catch(BatchNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(path = "/gtin", method = GET)
    public ResponseEntity<?> getGtinById(@RequestParam String id){
        try{
            return new ResponseEntity(productService.getGtinById(id), HttpStatus.OK);
        }catch(GtinNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
