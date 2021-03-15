package com.interview.message.processor.model;

public class ProductAdjustment {
    private String adjustmentOperation;
    private String adjustmentProductType;
    private int adjustmentQuantity;
    private double adjustmentValue;
    private double valueBeforeAdjustment;
    private double valueAfterAdjustment;

    public String getAdjustmentOperation() {
        return adjustmentOperation;
    }

    public void setAdjustmentOperation(String adjustmentOperation) {
        this.adjustmentOperation = adjustmentOperation;
    }

    public String getAdjustmentProductType() {
        return adjustmentProductType;
    }

    public void setAdjustmentProductType(String adjustmentProductType) {
        this.adjustmentProductType = adjustmentProductType;
    }

    public int getAdjustmentQuantity() {
        return adjustmentQuantity;
    }

    public void setAdjustmentQuantity(int adjustmentQuantity) {
        this.adjustmentQuantity = adjustmentQuantity;
    }

    public double getAdjustmentValue() {
        return adjustmentValue;
    }

    public void setAdjustmentValue(double adjustmentValue) {
        this.adjustmentValue = adjustmentValue;
    }

    public double getValueBeforeAdjustment() {
        return valueBeforeAdjustment;
    }

    public void setValueBeforeAdjustment(double valueBeforeAdjustment) {
        this.valueBeforeAdjustment = valueBeforeAdjustment;
    }

    public double getValueAfterAdjustment() {
        return valueAfterAdjustment;
    }

    public void setValueAfterAdjustment(double valueAfterAdjustment) {
        this.valueAfterAdjustment = valueAfterAdjustment;
    }

    public static ProductAdjustment populateProductAdjustment(Product consolidatedProduct, Product product) {
        ProductAdjustment adjustedProduct = new ProductAdjustment();

        adjustedProduct.setAdjustmentOperation(product.getOperation().toString());
        adjustedProduct.setAdjustmentValue(product.getValue());
        adjustedProduct.setAdjustmentProductType(product.getType());
        adjustedProduct.setAdjustmentQuantity(consolidatedProduct.getTotalQuantity());
        adjustedProduct.setValueAfterAdjustment(consolidatedProduct.getTotalValue());

        return adjustedProduct;
    }

}
