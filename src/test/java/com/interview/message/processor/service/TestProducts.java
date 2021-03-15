package com.interview.message.processor.service;

import com.interview.message.processor.model.Product;

public class TestProducts {

    protected static Product getProductForMessageTypeOne() {
        Product p = new Product();
        p.setType("apple");
        p.setValue(0.10);
        p.setQuantity(1);
        p.setOperation(null);
        return p;
    }

    protected static Product getProductForMessageTypeTwo() {
        Product p = new Product();
        p.setType("apple");
        p.setValue(0.10);
        p.setQuantity(10);
        p.setOperation(null);
        return p;
    }

    protected static Product getProductForMessageTypeThree() {
        Product p = new Product();
        p.setType("apple");
        p.setValue(0.20);
        p.setQuantity(0);
        p.setOperation(Product.Operations.Add);
        return p;
    }
}
