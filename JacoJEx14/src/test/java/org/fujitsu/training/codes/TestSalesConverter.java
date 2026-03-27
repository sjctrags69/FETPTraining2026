package org.fujitsu.training.codes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSalesConverter {

    private static final String OUTPUT_PATH = "src/main/resources/files/sales.json";

    private SalesConverter converter;
    private List<SalesRecord> records;

    @BeforeEach
    public void setUp() {
        converter = new SalesConverter();
        records = List.of(
            new SalesRecord("Smith",    16753.00, "UK",  "Qtr 3"),
            new SalesRecord("Johnson",  14808.00, "USA", "Qtr 4"),
            new SalesRecord("Williams", 10644.00, "UK",  "Qtr 2"),
            new SalesRecord("Jones",     1390.00, "USA", "Qtr 3"),
            new SalesRecord("Brown",     4865.00, "USA", "Qtr 4"),
            new SalesRecord("Williams", 12438.00, "UK",  "Qtr 1"),
            new SalesRecord("Johnson",   9339.00, "UK",  "Qtr 2"),
            new SalesRecord("Smith",    18919.00, "USA", "Qtr 3"),
            new SalesRecord("Jones",     9213.00, "USA", "Qtr 4"),
            new SalesRecord("Jones",     7433.00, "UK",  "Qtr 1"),
            new SalesRecord("Brown",     3255.00, "USA", "Qtr 2"),
            new SalesRecord("Williams", 14867.00, "USA", "Qtr 3"),
            new SalesRecord("Williams", 19302.00, "UK",  "Qtr 4"),
            new SalesRecord("Smith",     9698.00, "USA", "Qtr 1")
        );
    }

    @Test
    public void testOutputFileIsCreated() {
        converter.convertToJson(records);
        assertTrue(new File(OUTPUT_PATH).exists());
    }

    @Test
    public void testCorrectNumberOfRecords() {
        converter.convertToJson(records);
        List<SalesRecord> result = converter.readFromJson();
        assertEquals(14, result.size());
    }

    @Test
    public void testFirstRecordValues() {
        converter.convertToJson(records);
        List<SalesRecord> result = converter.readFromJson();
        SalesRecord first = result.get(0);

        assertEquals("Smith",     first.getLastName());
        assertEquals("$16753.00", first.getSales());
        assertEquals("UK",        first.getCountry());
        assertEquals("Qtr 3",     first.getQuarter());
    }

    @Test
    public void testSalesHasDollarSign() {
        converter.convertToJson(records);
        List<SalesRecord> result = converter.readFromJson();
        result.forEach(r -> assertTrue(r.getSales().startsWith("$")));
    }

    @Test
    public void testAllFieldsNotNull() {
        converter.convertToJson(records);
        List<SalesRecord> result = converter.readFromJson();
        assertNotNull(result);
        result.forEach(r -> {
            assertNotNull(r.getLastName());
            assertNotNull(r.getSales());
            assertNotNull(r.getCountry());
            assertNotNull(r.getQuarter());
        });
    }
}