package com.interview.message.processor.service;

import com.interview.message.processor.model.Product;
import com.interview.message.processor.model.ProductAdjustment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SalesProcessorImpl implements SalesProcessor {

    private HashMap<String, Product> productDetails = new HashMap<>();
    List<ProductAdjustment> adjustedProductsList = new ArrayList<>();
    int recordCount = 0;

    private final MessageParser messageParser;
    private final ReportService reportService;

    public SalesProcessorImpl(MessageParser messageParser, ReportService reportService) {
        this.messageParser = messageParser;
        this.reportService = reportService;
    }

    @Override
    public boolean processSales(String message) {
        Product consolidatedProduct = null;

        Product product = messageParser.parseMessage(message);

        if (null != product) {
            recordCount = recordCount + 1;
            consolidatedProduct = productDetails.getOrDefault(product.getType(), new Product());

            if (null != product.getOperation()) {
                double valueBeforeAdjustment = consolidatedProduct.getTotalValue();

                consolidatedProduct = performAdjustment(consolidatedProduct, product);

                ProductAdjustment adjustedProduct = ProductAdjustment.populateProductAdjustment(consolidatedProduct, product);
                adjustedProduct.setValueBeforeAdjustment(valueBeforeAdjustment);
                adjustedProductsList.add(adjustedProduct);
            } else {
                consolidatedProduct.setType(product.getType());
                consolidatedProduct.setTotalValue(
                        consolidatedProduct.getTotalValue() + (product.getValue() * product.getQuantity()));
                consolidatedProduct.setTotalQuantity(consolidatedProduct.getTotalQuantity() + product.getQuantity());
            }

            productDetails.put(product.getType(), consolidatedProduct);

            if (recordCount % 10 == 0) {
                reportService.generateSalesReport(productDetails);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (recordCount == 50) {
                System.out.println("Reached 50 records, application is now pausing...");
                System.out.println("\n");
                reportService.generateAdjustmentReport(adjustedProductsList);
                return false;
            }
        }

        return true;
    }

    /**
     * @param consolidatedProduct
     * @param product
     * @return Product
     */
    private Product performAdjustment(Product consolidatedProduct, Product product) {
        double adjustment;
        adjustment = consolidatedProduct.getTotalQuantity() * product.getValue();

        Product.Operations operator = product.getOperation();
        double result = operator.apply(consolidatedProduct.getTotalValue(), adjustment);
        consolidatedProduct.setTotalValue(result);
        return consolidatedProduct;
    }

}