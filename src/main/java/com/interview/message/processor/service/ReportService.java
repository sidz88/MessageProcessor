package com.interview.message.processor.service;

import com.interview.message.processor.model.Product;
import com.interview.message.processor.model.ProductAdjustment;

import java.util.HashMap;
import java.util.List;

public interface ReportService {
    /**
     * @param productDetails Generate a sales report
     */
    void generateSalesReport(HashMap<String, Product> productDetails);

    /**
     * @param adjustedProductsList Generate Adjustment Report
     */
    void generateAdjustmentReport(List<ProductAdjustment> adjustedProductsList);
}
