package sec02;

import app.Database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertManyResult;
import java.util.ArrayList;
import org.bson.Document;

public class InsertManyTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("todo");
        ArrayList<Document> insertList = new ArrayList<Document>();
        Document document1 = new Document();
        Document document2 = new Document();
        document1.append("title", (Object)"Dune2 \uc601\ud654\ubcf4\uae30");
        document1.append("desc", (Object)"\uc774\ubc88 \uc8fc\ub9d0 IMAX\ub85c Dune2 \uc601\ud654\ubcf4\uae30");
        document1.append("done", (Object)false);
        document2.append("title", (Object)"Java MongoDB \uc5f0\ub3d9");
        document2.append("desc", (Object)"Java\ub85c MongoDB \uc5f0\ub3d9 \ud504\ub85c\uadf8\ub798\ubc0d \uc5f0\uc2b5\ud558\uae30");
        document2.append("done", (Object)false);
        insertList.add(document1);
        insertList.add(document2);
        InsertManyResult result = collection.insertMany(insertList);
        System.out.println("==> InsertManyResult : " + result.getInsertedIds());
        Database.close();
    }
}
