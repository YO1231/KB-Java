package PM.collection;

import java.util.TreeMap;

public class CollectionEx8 {
    public static void main(String[] args) {

        TreeMap<String, Integer> map = new TreeMap<>();

        map.put("banana", 2000);
        map.put("apple", 3000);
        map.put("orange", 4000);
        map.put("melon", 8000);

        System.out.println("전체 출력");
        System.out.println(map);

        System.out.println();

        System.out.println("첫 번째 Key: " + map.firstKey());
        System.out.println("마지막 Key: " + map.lastKey());

        System.out.println();

        System.out.println("banana보다 작은 Key: " + map.lowerKey("banana"));
        System.out.println("banana보다 큰 Key: " + map.higherKey("banana"));

        System.out.println();

        System.out.println("banana 이하 Key: " + map.floorKey("banana"));
        System.out.println("banana 이상 Key: " + map.ceilingKey("banana"));
    }
}
