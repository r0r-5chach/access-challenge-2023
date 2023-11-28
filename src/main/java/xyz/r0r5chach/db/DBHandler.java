package xyz.r0r5chach.db;

import org.bson.Document;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DBHandler {
    protected static final MongoDatabase client = MongoClients.create().getDatabase("personal-website");
    protected MongoCollection<Document> collection;

    public DBHandler(String collection) {
        this.collection = client.getCollection(collection);
    }
}
