package sec03;

import app.Database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class FindOneTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("todo");
        String id = "6a222b6c16293701621a8796";
        Bson query = Filters.eq((String)"_id", (Object)new ObjectId(id));
        Document doc = (Document)collection.find(query).first();
        System.out.println("==> findByIdResult : " + doc);
        Database.close();
    }
}
