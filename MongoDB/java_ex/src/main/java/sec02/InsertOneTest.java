package sec02;

import app.Database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;

public class InsertOneTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("todo");
        Document document = new Document();
        document.append("title", (Object)"MongoDB");
        document.append("desc", (Object)"MongoDB \uacf5\ubd80\ud558\uae30");
        document.append("done", (Object)false);
        InsertOneResult result = collection.insertOne(document);
        System.out.println("==> InsertOneResult : " + result.getInsertedId());
        Database.close();
    }
}
