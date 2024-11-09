package com.twinleaves.products.controller;

import com.twinleaves.products.service.GtinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/gtin")
public class GtinController {

    private final GtinService gtinService;

    @RequestMapping(path = "/product", method = GET)
    ResponseEntity<?> getGtinWithBatches(){
        return new ResponseEntity(gtinService.getGtinWithBatches(), HttpStatus.OK);
    }
}
