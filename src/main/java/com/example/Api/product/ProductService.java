package com.example.Api.product;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product){

        return productRepository.save(product);
    }

    public boolean checkDuplicatedProduct(String productName){
        boolean result = false;
        Optional<Product> optionalProduct = productRepository.findByProductName(productName);
        if(optionalProduct.isPresent()){
            result = true;
        }
        return result;
    }


}
