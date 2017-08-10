package com.example.brentvanvosselen.overtime.domain;

import java.util.Date;

/**
 * Created by brentvanvosselen on 10/08/2017.
 */

public class DomainController {
    private ProductRepository productRepository;
    public DomainController(){
        productRepository = new ProductRepository();
    }

    public void addProduct(String name, int quantity, Date expirationDate){
        productRepository.addProduct(name,quantity,expirationDate);
    }
}
