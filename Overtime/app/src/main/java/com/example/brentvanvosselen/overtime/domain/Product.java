package com.example.brentvanvosselen.overtime.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by brentvanvosselen on 10/08/2017.
 */

public class Product {
    private String name;
    private int quantity;
    private Date expirationDate;

    public Product(String name, int quantity, Date expirationDate) {
        checkName(name);
        this.name = name;
        checkQuantity(quantity);
        this.quantity = quantity;
        checkExpirationDate(expirationDate);
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        checkName(name);
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        checkQuantity(quantity);
        this.quantity = quantity;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        checkExpirationDate(expirationDate);
        this.expirationDate = expirationDate;
    }

    /*check functions*/
    private void checkQuantity(int quantity){
        if(quantity <= 0)
            throw new IllegalArgumentException("The quantity can't be 0 or lower");
    }

    private void checkExpirationDate(Date expirationDate){
        Date now = new Date();
        if(now.after(expirationDate)){
            throw new IllegalArgumentException("The expirationdate must be tomorrow or later");
        }
    }

    private void checkName(String name){
       if (name.isEmpty() || name.trim().isEmpty())
                throw new IllegalArgumentException("The name can't be empty");
    }
}
