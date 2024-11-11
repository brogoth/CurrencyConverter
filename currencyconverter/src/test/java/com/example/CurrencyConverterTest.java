package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class CurrencyConverterTest {

    @Test
    public void testValidDollarToPoundConversion() {
        String[] args = {"100", "dollars"};
        String result = CurrencyConverter.runConversion(args);
        System.out.println("Actual Output: " + result);
        assertTrue(result.contains("Dollars"));
        assertTrue(result.contains("74"));
        assertTrue(result.contains("Pounds"));
    }

    @Test
    public void testValidDollarToEuroConversion() {
        String[] args = {"100", "dollars"};
        String result = CurrencyConverter.runConversion(args);
        System.out.println("Actual Output: " + result);
        assertTrue(result.contains("Dollars"));
        assertTrue(result.contains("88"));
        assertTrue(result.contains("Euros"));
    }

    @Test
    public void testValidPoundToDollarConversion() {
        String[] args = {"100", "pounds"};
        String result = CurrencyConverter.runConversion(args);
        System.out.println("Actual Output: " + result);
        assertTrue(result.contains("Pounds"));
        assertTrue(result.contains("136"));
        assertTrue(result.contains("Dollars"));
    }

    @Test
    public void testValidEuroToDollarConversion() {
        String[] args = {"100", "euros"};
        String result = CurrencyConverter.runConversion(args);
        System.out.println("Actual Output: " + result);
        assertTrue(result.contains("Euros"));
        assertTrue(result.contains("113"));
        assertTrue(result.contains("Dollars"));
    }

    @Test
    public void testInvalidCurrencyType() {
        String[] args = {"100", "yen"};
        String result = CurrencyConverter.runConversion(args);
        System.out.println("Actual Output: " + result);
        assertTrue(result.contains("Error"));
        assertTrue(result.contains("Unsupported currency type"));
    }

    @Test
    public void testCaseInsensitiveCurrencyInput() {
        String[] args = {"100", "DOLLARS"};
        String result = CurrencyConverter.runConversion(args);
        System.out.println("Actual Output: " + result);
        assertTrue(result.contains("Dollars"));
        assertTrue(result.contains("74"));
        assertTrue(result.contains("Pounds"));
        assertTrue(result.contains("88"));
        assertTrue(result.contains("Euros"));
    }

    @Test
    public void testInvalidAmountInput() {
        String[] args = {"abc", "dollars"};
        String result = CurrencyConverter.runConversion(args);
        System.out.println("Actual Output: " + result);
        assertTrue(result.contains("Error"));
        assertTrue(result.contains("Amount must be a valid number"));
    }

    @Test
    public void testMissingArguments() {
        String[] args = {};
        String result = CurrencyConverter.runConversion(args);
        System.out.println("Actual Output: " + result);
        assertTrue(result.contains("Error"));
        assertTrue(result.contains("provide the amount and currency type"));
    }
}
