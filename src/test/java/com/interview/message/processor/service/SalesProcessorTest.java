package com.interview.message.processor.service;

import com.interview.message.processor.model.Product;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class SalesProcessorTest {


    @Test
    public void givenMessageWhenProductNotNullThenReturnTrue() {
        MessageParser messageParser = Mockito.mock(MessageParser.class);
        Mockito.when(messageParser.parseMessage("apple at 10p")).thenReturn(TestProducts.getProductForMessageTypeOne());

        ReportService reportService = Mockito.mock(ReportServiceImpl.class);
        Mockito.doNothing().when(reportService).generateSalesReport(Mockito.isA(HashMap.class));
        SalesProcessor csvParser = new SalesProcessorImpl(messageParser, reportService);

        boolean result = csvParser.processSales("apple at 10p");
        assertEquals(true, result);

    }

    @Test
    public void given50MessageWhenProductNotNullThenReturnFalse() {
        boolean result = true;

        MessageParser messageParser = Mockito.mock(MessageParser.class);
        Mockito.when(messageParser.parseMessage("apple at 10p")).thenReturn(TestProducts.getProductForMessageTypeOne());

        ReportService reportService = Mockito.mock(ReportServiceImpl.class);
        Mockito.doNothing().when(reportService).generateSalesReport(Mockito.isA(HashMap.class));
        SalesProcessor csvParser = new SalesProcessorImpl(messageParser, reportService);

        for (int i = 1; i <= 50; i++) {
            result = csvParser.processSales("apple at 10p");
        }
        assertEquals(false, result);
    }

    @Test
    public void given51MessageWhenProductNotNullThenReturnTrue() {
        boolean result = true;

        MessageParser messageParser = Mockito.mock(MessageParser.class);
        Mockito.when(messageParser.parseMessage("apple at 10p")).thenReturn(TestProducts.getProductForMessageTypeOne());

        ReportService reportService = Mockito.mock(ReportServiceImpl.class);
        Mockito.doNothing().when(reportService).generateSalesReport(Mockito.isA(HashMap.class));
        SalesProcessor csvParser = new SalesProcessorImpl(messageParser, reportService);

        for (int i = 1; i <= 51; i++) {
            result = csvParser.processSales("apple at 10p");
        }
        assertEquals(true, result);
    }

    @Test
    public void given51MessageWhenProductIsNullThenReturnTrue() {
        boolean result = true;

        MessageParser messageParser = Mockito.mock(MessageParser.class);
        Mockito.when(messageParser.parseMessage("Please apple at 10p")).thenReturn(null);
        ReportService reportService = Mockito.mock(ReportServiceImpl.class);
        Mockito.doNothing().when(reportService).generateSalesReport(Mockito.isA(HashMap.class));

        SalesProcessor csvParser = new SalesProcessorImpl(messageParser, reportService);

        result = csvParser.processSales("Please apple at 10p");
        assertEquals(true, result);
    }

}
