package com.example.brentvanvosselen.overtime.domain;

import android.content.res.Resources;

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

        /*fakedate*/
        products.add(new Product("cheese",2,new Date(117,9,2),0));
        products.add(new Product("bacon",5,new Date(118,6,21),1));
    }

    public void addProduct(String name, int quantity, Date expirationDate,int id){
        products.add(new Product(name,quantity,expirationDate,id));
    }

    public List<String> getProductNames() {
        List<String> pn = new ArrayList<>();
        for (Product p:products) {
            pn.add(p.getName());
        }
        return pn;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(int id) {
        boolean found = false;
        for (Product p:products) {
            if (p.getId() == id)
                found = true;
                return p;
        }
         //if(!found)throw new Resources.NotFoundException("The product does not exist");
        return null;
    }
}
