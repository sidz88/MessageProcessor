package com.interview.message.processor.model;

import java.util.Objects;

public class Product {
    private String type;
    private double value;
    private int quantity;
    private Operations operation;
    private int totalQuantity;
    private double totalValue;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Operations getOperation() {
        return operation;
    }

    public void setOperation(Operations operation) {
        this.operation = operation;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public enum Operations {
        Add {
            public double apply(double a, double b) {
                return a + b;
            }
        },
        Subtract {
            public double apply(double a, double b) {
                return a - b;
            }
        },
        Multiply {
            public double apply(double a, double b) {
                return a * b;
            }
        },
        ;

        public abstract double apply(double a, double b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.value, value) == 0 && quantity ==
                product.quantity && totalQuantity == product.totalQuantity &&
                Double.compare(product.totalValue, totalValue) == 0 &&
                type.equals(product.type) && operation == product.operation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value, quantity, operation, totalQuantity, totalValue);
    }

    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", value=" + value +
                ", quantity=" + quantity +
                ", operation=" + operation +
                ", totalQuantity=" + totalQuantity +
                ", totalValue=" + totalValue +
                '}';
    }
}
