package com.example.phamducminh.controller;


import com.example.phamducminh.entity.Product;
import com.example.phamducminh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(path = "/api/v1/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Product>> getAllProducts(){
        return ResponseEntity.ok(productService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addProduct(@RequestBody Product p){
        return ResponseEntity.ok(productService.save(p));
    }

    @RequestMapping(method = RequestMethod.PUT,path = "{productId}")
    public ResponseEntity<?> sellProduct(@RequestBody int quantity,@PathVariable int productId){
        Optional<Product> optionalProduct = productService.findById(productId);
        if (!optionalProduct.isPresent()){
            ResponseEntity.badRequest().build();
        }
        Product product = optionalProduct.get();
        product.setQuantity(quantity);
        return ResponseEntity.ok(productService.save(product));
    }
}
