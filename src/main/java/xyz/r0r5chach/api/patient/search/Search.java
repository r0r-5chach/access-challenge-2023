package xyz.r0r5chach.api.patient.search;

import java.time.LocalDateTime;
import java.util.List;

public class Search {
    private String resourceType, type;
    private LocalDateTime timestamp;
    private int total;
    private List<Entry> entries;
    public Search(String resourceType, String type, LocalDateTime timestamp, int total, List<Entry> entries) {
        this.resourceType = resourceType;
        this.type = type;
        this.timestamp = timestamp;
        this.total = total;
        this.entries = entries;
    }
    public String getResourceType() {
        return resourceType;
    }
    public String getType() {
        return type;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public int getTotal() {
        return total;
    }
    public List<Entry> getEntries() {
        return entries;
    }
}
