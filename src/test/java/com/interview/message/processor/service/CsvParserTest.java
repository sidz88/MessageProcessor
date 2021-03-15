package com.interview.message.processor.service;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.assertNotNull;

public class CsvParserTest {

    MessageParser csvParser = new CsvParser();

    @Test
    public void givenValidFileWhenFileIsPresentThenReturnScanner() {

        Scanner scanner = null;
        try {
            scanner = csvParser.parseInput("src/test/resources/SalesRecords.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertNotNull(scanner);

    }

    @Test(expected = FileNotFoundException.class)
    public void givenInValidFileWhenFileIsNotPresentThenReturnScanner() throws IOException {
        Scanner scanner = csvParser.parseInput("src/test/resources/SalesRecords1.csv");
    }
}
