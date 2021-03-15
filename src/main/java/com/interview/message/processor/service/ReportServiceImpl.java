package com.interview.message.processor.service;

import com.interview.message.processor.MessageConstants;
import com.interview.message.processor.model.Product;
import com.interview.message.processor.model.ProductAdjustment;

import java.util.HashMap;
import java.util.List;

public class ReportServiceImpl implements ReportService {

    public void generateSalesReport(HashMap<String, Product> productDetails) {
        System.out.println("Application has processed 10 Sales Records.");
        System.out.println("|--------------------------|");
        System.out.println("|       SALES REPORT       |");
        System.out.println("|--------------------------|");
        System.out.println(String.format(MessageConstants.SALES_REPORT_HEADER_FORMAT,
                MessageConstants.PRODUCT, MessageConstants.QTY, MessageConstants.PRICE));
        System.out.println("|..........................|");
        double totalSale = 0;
        for (String key : productDetails.keySet()) {
            totalSale = totalSale + productDetails.get(key).getTotalValue();
            System.out.println(String.format(MessageConstants.SALES_REPORT_FORMAT, key,
                    productDetails.get(key).getTotalQuantity(), productDetails.get(key).getTotalValue()));
        }
        System.out.println("|--------------------------|");
        System.out.println("| Total sales : "
                + String.format(MessageConstants.DOUBLE_TWO_DECIMAL_PRECISION_PATTERN, totalSale) + "      |");
        System.out.println("|xxxxxxxxxxxxxxxxxxxxxxxxxx|");
        System.out.println("\n");
    }

    public void generateAdjustmentReport(List<ProductAdjustment> adjustedProductsList) {
        System.out.println("|--------------------------------------------------------------------------|");
        System.out.println("|                           ADJUSTMENT REPORT                              |");
        System.out.println("|--------------------------------------------------------------------------|");
        System.out.println(String.format(MessageConstants.ADJUSTMENT_REPORT_HEADER_FORMAT,
                MessageConstants.PRODUCT, MessageConstants.OPERATION_HEADER,
                MessageConstants.ADJUSTMENT_FACTOR, MessageConstants.QTY,
                MessageConstants.PRICE_BEFORE_ADJUSTMENT, MessageConstants.PRICE_AFTER_ADJUSTMENT));
        System.out.println("|--------------------------------------------------------------------------|");
        for (ProductAdjustment adjustedProduct : adjustedProductsList) {
            System.out.println(String.format(MessageConstants.ADJUSTMENT_REPORT_FORMAT,
                    adjustedProduct.getAdjustmentProductType(), adjustedProduct.getAdjustmentOperation(),
                    adjustedProduct.getAdjustmentValue(), adjustedProduct.getAdjustmentQuantity(),
                    adjustedProduct.getValueBeforeAdjustment(), adjustedProduct.getValueAfterAdjustment()));
        }
        System.out.println("|---------------------------------- END -----------------------------------|");
    }
}
