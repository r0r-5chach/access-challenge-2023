package xyz.r0r5chach.db;

import org.bson.Document;

public class WritableDBHandler extends DBHandler{

    public WritableDBHandler(String collection) {
        super(collection);
    }
    
    public void insertOne(Document doc) {
        collection.insertOne(doc);
    }
}
