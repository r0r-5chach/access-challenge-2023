package xyz.r0r5chach.db;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;

public class ReadableDBHandler extends DBHandler {
    public ReadableDBHandler(String collection) {
        super(collection);
    }

    public Document getFirstResult(Document query) {
        return collection.find(query).first();
    }

    public List<Document> getResults(Document query) {
        List<Document> results = new ArrayList<>();
        FindIterable<Document> queryResults;

        if (query != null) {
            queryResults = collection.find(query);
            
        }
        else {
            queryResults = collection.find();
        }

        for (Document result : queryResults)  {
                results.add(result);
        }

        return results;
    }

    public List<Document> getAll() {
        return getResults(null);
    }
}
