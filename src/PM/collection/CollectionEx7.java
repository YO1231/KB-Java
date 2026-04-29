package PM.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CollectionEx7 {
    public static void main(String[] args) {
        HashMap<Integer, String> map1 = new HashMap<>();
        map1.put(1, "윤아");
        map1.put(2, "윤아");
        map1.put(3, "윤아");
        map1.put(3, "민주");
//        System.out.println(map1);

        Iterator<Integer> iterator = map1.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println("key="+key+" value="+ map1.get(key));
        }

        System.out.println();

        Iterator<Map.Entry<Integer, String>> iterator1 = map1.entrySet().iterator();

        while (iterator1.hasNext()) {
            Map.Entry<Integer, String> entry = iterator1.next();
            System.out.println(entry.getValue());
        }

    }
}
