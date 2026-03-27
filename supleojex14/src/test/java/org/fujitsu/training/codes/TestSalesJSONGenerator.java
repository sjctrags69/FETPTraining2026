package org.fujitsu.training.codes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSalesJSONGenerator {
    private SalesJSONGenerator generator;

    @BeforeEach
    public void setup() {
        generator = new SalesJSONGenerator();
    }

    @AfterEach
    public void teardown() {
        generator = null;
    }

    @Test
    public void testCreateSalesJson() {
        String filename = "./src/main/resources/files/sales.json";
        generator.createSalesJson(filename);
    }
}