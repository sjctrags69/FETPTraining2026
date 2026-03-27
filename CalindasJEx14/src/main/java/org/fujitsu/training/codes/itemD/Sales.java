package org.fujitsu.training.codes.itemD;

import java.util.List;

public class Sales {
    private List<SalesRecord> records;

    public Sales(List<SalesRecord> records) {
        this.records = records;
    }

    public List<SalesRecord> getRecords() {
        return records;
    }
}