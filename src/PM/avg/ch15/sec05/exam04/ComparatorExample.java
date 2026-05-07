package PM.avg.ch15.sec05.exam04;

import java.util.ArrayList;
import java.util.List;

public class ComparatorExample {
    public static void main(String[] args) {
        List<Fruit> fruits = new ArrayList<>();

        fruits.add(new Fruit("포도", 3000));
        fruits.add(new Fruit("수박", 10000));
        fruits.add(new Fruit("딸기", 6000));

        fruits.sort(new FruitComparator());

        for (Fruit f : fruits) {
            System.out.printf("%s : %d\n", f.name, f.price);
        }
    }
}
