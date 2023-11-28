package xyz.r0r5chach.api.patch;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

public class Patch {
    private Operation op;
    private String path;
    private Document value;
    
    public Patch(Operation op, String path, Document value) {
        this.op = op;
        this.path = path;
        this.value = value;
    }

    public Operation getOp() {
        return op;
    }

    public String getPath() {
        return path;
    }

    public Document getValue() {
        return value;
    }

    public Document toDoc() {
        return new Document()
            .append("op", op.toString())
            .append("path", path)
            .append("value", value);
    }

    public static List<Document> listToDoc(List<Patch> list) {
        List<Document> out = new ArrayList<>();

        for (Patch item : list) {
            out.add(item.toDoc());
        }

        return out;
    }
}
