package sec04;

import app.Database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class UpdateOneTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("users");
        String id = "6a222b6c16293701621a8796";
        Bson query = Filters.eq((String)"_id", (Object)new ObjectId(id));
        Bson updates = Updates.combine((Bson[])new Bson[]{Updates.set((String)"name", (Object)"modify name")});
    }
}
