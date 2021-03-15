package com.interview.message.processor.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CsvParser extends MessageParser {

    @Override
    public Scanner parseInput(String file) throws FileNotFoundException {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(file));
        } catch (FileNotFoundException e) {
            throw e;
        }
        return scanner;
    }
}
