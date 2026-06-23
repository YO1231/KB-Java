package sec03;

import app.Database;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

public class FindTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("todo");
        FindIterable doc = collection.find();
        MongoCursor itr = doc.iterator();
        while (itr.hasNext()) {
            System.out.println("==> findResultRow : " + itr.next());
        }
        Database.close();
    }
}
