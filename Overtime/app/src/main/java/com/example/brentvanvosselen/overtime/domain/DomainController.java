package com.example.brentvanvosselen.overtime.domain;

import java.util.Date;
import java.util.List;

/**
 * Created by brentvanvosselen on 10/08/2017.
 */

public class DomainController {
    private ProductRepository productRepository;
    private static DomainController domainController = new DomainController();
    private DomainController(){
        productRepository = new ProductRepository();
    }

    public static DomainController getInstance(){
        return domainController;
    }

    public void addProduct(String name, int quantity, Date expirationDate,int id){
        productRepository.addProduct(name,quantity,expirationDate,id);
    }

    public List<String> getProductNames() {
        return productRepository.getProductNames();
    }

    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }
}
