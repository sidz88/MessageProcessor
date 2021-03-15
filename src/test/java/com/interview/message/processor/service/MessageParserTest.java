package com.interview.message.processor.service;

import com.interview.message.processor.model.Product;
import org.junit.Test;

import static org.junit.Assert.*;

public class MessageParserTest {
    MessageParser csvParser = new CsvParser();

    @Test
    public void givenMessageType1WhenIsValidThenReturnProduct(){
        Product expectedProduct = TestProducts.getProductForMessageTypeOne();
        Product product = csvParser.parseMessage("apple at 10p");
        assertNotNull(product);
        assertEquals(expectedProduct, product);
    }

    @Test
    public void givenMessageType2WhenIsValidThenReturnProduct(){
        Product expectedProduct = TestProducts.getProductForMessageTypeTwo();
        Product product = csvParser.parseMessage("10 sales of apple at 10p each");
        assertNotNull(product);
        assertEquals(expectedProduct, product);
    }

    @Test
    public void givenMessageType3WhenIsValidThenReturnProduct(){
        Product expectedProduct = TestProducts.getProductForMessageTypeThree();
        Product product = csvParser.parseMessage("Add 20p apple");
        assertNotNull(product);
        assertEquals(expectedProduct, product);
    }

    @Test
    public void givenMessageWhenIsInValidThenReturnNull(){
        Product product = csvParser.parseMessage("Please Add 20p apple");
        assertNull(product);
    }


}
