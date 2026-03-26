package org.fujitsu.training.codes;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class SalesJSONGenerator {

    public boolean createSalesJson(String filename) {
        SalesTable table = new SalesTable();
        table.setSales(Arrays.asList(
            new Sales("Smith",    usd(16753.00), "UK",  "Qtr 3"),
            new Sales("Johnson",  usd(14808.00), "USA", "Qtr 4"),
            new Sales("Williams", usd(10644.00), "UK",  "Qtr 2"),
            new Sales("Jones",    usd(1390.00),  "USA", "Qtr 3"),
            new Sales("Brown",    usd(4865.00),  "USA", "Qtr 4"),
            new Sales("Williams", usd(12438.00), "UK",  "Qtr 1"),
            new Sales("Johnson",  usd(9339.00),  "UK",  "Qtr 2"),
            new Sales("Smith",    usd(18919.00), "USA", "Qtr 3"),
            new Sales("Jones",    usd(9213.00),  "USA", "Qtr 4"),
            new Sales("Jones",    usd(7433.00),  "UK",  "Qtr 1"),
            new Sales("Brown",    usd(3255.00),  "USA", "Qtr 2"),
            new Sales("Williams", usd(14867.00), "USA", "Qtr 3"),
            new Sales("Williams", usd(19302.00), "UK",  "Qtr 4"),
            new Sales("Smith",    usd(9698.00),  "USA", "Qtr 1")
        ));

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File(filename), table);
            return true;
        } 
        catch (IOException e) {
            System.err.println("Failed to write sales JSON file: " + filename + " | " + e.getMessage());
            return false;
        }
    }

    private String usd(double amount) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        return nf.format(amount);
    }
}