package com.interview.message.processor;

import com.interview.message.processor.service.*;

import java.io.IOException;
import java.util.Scanner;

public class MessageProcessor {
    public static void main(String[] args) {

        SalesProcessor salesProcessor = null;

        try {
            MessageParser csvParser = new CsvParser();
            Scanner scanner = csvParser.parseInput("src/main/resources/SalesRecords.csv");
            ReportService reportService = new ReportServiceImpl();
            salesProcessor = new SalesProcessorImpl(csvParser, reportService);
            boolean continueFlag;

            while (scanner.hasNextLine()) {
                String message = scanner.nextLine();
                continueFlag = salesProcessor.processSales(message);
                if(!continueFlag){
                    break;
                }
            }

            if (scanner.ioException() != null) {
                throw scanner.ioException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
