package AM.ch15.sec05.exam04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompareExample2 {
    public static void main(String[] args) {
        List<Fruit> list = new ArrayList<Fruit>();

        list.add(new Fruit("포도", 3000));
        list.add(new Fruit("수박", 10000));
        list.add(new Fruit("딸기", 6000));

        list.sort(new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {
                return o1.price - o2.price;
            }
        });

        for (Fruit fruit : list) {
            System.out.println(fruit.name + ":" + fruit.price);
        }
    }
}
