package com.example.brentvanvosselen.overtime.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by brentvanvosselen on 10/08/2017.
 */

public class ProductRepository {
    private List<Product> products;
    public ProductRepository(){
        products = new ArrayList<>();
    }

    public void addProduct(String name, int quantity, Date expirationDate){
        products.add(new Product(name,quantity,expirationDate));
    }

    public List<String> getProductNames() {
        List<String> pn = new ArrayList<>();
        for (Product p:products) {
            pn.add(p.getName());
        }
        return pn;
    }
}
