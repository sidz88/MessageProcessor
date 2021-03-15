package com.interview.message.processor.service;

import com.interview.message.processor.MessageConstants;
import com.interview.message.processor.model.Product;

import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class MessageParser {
    /**
     * @param file
     * @return Scanner
     * @throws FileNotFoundException
     */
    public abstract Scanner parseInput(String file) throws FileNotFoundException;

    /**
     * @param message
     * @return Product
     * Return Product by pasing message
     */
    public Product parseMessage(String message) {
        if (message == null || message.isEmpty()) {
            return null;
        }
        String[] splitMessage = message.trim().split(MessageConstants.MESSAGE_SPLIT_PATTERN);
        String firstWord = splitMessage[0];

        if (splitMessage.length == 3 && splitMessage[1].contains(MessageConstants.AT)) {
            return parseMessageTypeOne(splitMessage);
        } else if (splitMessage.length == 7 && firstWord.matches(MessageConstants.NUMBER_MATCH_PATTERN)) {
            return parseMessageTypeTwo(splitMessage);
        } else if (splitMessage.length == 3 && firstWord.matches(MessageConstants.OPERATION)) {
            return parseMessageTypeThree(splitMessage);
        }

        return null;
    }

    /**
     * @param messageArray
     * @return Product
     * Parsing message of Type 1
     */
    private Product parseMessageTypeOne(String[] messageArray) {
        Product parsedRecord = new Product();

        parsedRecord.setType(messageArray[0]);
        parsedRecord.setValue(parsePrice(messageArray[2]));
        parsedRecord.setQuantity(1);
        parsedRecord.setOperation(null);

        return parsedRecord;
    }

    /**
     * @param messageArray
     * @return Product
     * Parsing message of Type 2
     */
    private Product parseMessageTypeTwo(String[] messageArray) {
        Product parsedRecord = new Product();

        parsedRecord.setType(messageArray[3]);
        parsedRecord.setValue(parsePrice(messageArray[5]));
        parsedRecord.setQuantity(Integer.parseInt(messageArray[0]));
        parsedRecord.setOperation(null);

        return parsedRecord;
    }

    /**
     * @param messageArray
     * @return Product
     * Parsing message of Type 3
     */
    private Product parseMessageTypeThree(String[] messageArray) {
        Product parsedRecord = new Product();

        parsedRecord.setType(messageArray[2]);
        parsedRecord.setQuantity(0);
        parsedRecord.setValue(parsePrice(messageArray[1]));
        parsedRecord.setOperation(Product.Operations.valueOf(messageArray[0]));

        return parsedRecord;
    }

    /**
     * @param pence
     * @return double
     * Return price converted from string to double
     */
    public double parsePrice(String pence) {
        double pound = Double.parseDouble(pence.replaceAll(MessageConstants.REMOVE_CURRENCY_PATTERN,
                MessageConstants.EMPTY_STRING));
        if (!pence.contains(MessageConstants.DOT)) {
            pound = Double.valueOf(Double.valueOf(pound) / Double.valueOf(MessageConstants.HUNDRED));
        }
        return pound;
    }
}
