package org.fujitsu.training.codes.itemD;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SalesJSONGenerator {

    public static void main(String[] args) {
        try {
            List<SalesRecord> list = new ArrayList<>();

            list.add(new SalesRecord("Williams", 12438.00, "UK", "Qtr 1"));
            list.add(new SalesRecord("Johnson", 9339.00, "UK", "Qtr 2"));
            list.add(new SalesRecord("Smith", 18919.00, "USA", "Qtr 3"));

            Sales sales = new Sales(list);

            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter()
                  .writeValue(new File("sales.json"), sales);

            System.out.println("JSON generated!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}