package com.example.phamducminh.service;

import com.example.phamducminh.entity.Product;
import com.example.phamducminh.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Iterable<Product> findAll(){
        return productRepository.findAll();
    }

    public Optional<Product> findById(Integer id){
        return productRepository.findById(id);
    }

    public Product save(Product product){
        return  productRepository.save(product);
    }
}
