package PM.collection;

import java.util.TreeSet;

public class CollectionEx6 {
    public static void main(String[] args) {
        TreeSet<Integer> scores = new TreeSet<>();

        scores.add(80);
        scores.add(100);
        scores.add(70);
        scores.add(90);
        scores.add(80);

        System.out.println("TreeSet 전체 출력");
        System.out.println(scores);

        System.out.println("가장 낮은 점수: " + scores.first());
        System.out.println("가장 높은 점수: " + scores.last());

        System.out.println("90보다 낮은 점수: " + scores.lower(90));
        System.out.println("90보다 높은 점수: " + scores.higher(90));

        System.out.println("90 이하 점수: " + scores.floor(90));
        System.out.println("90 이상 점수: " + scores.ceiling(90));
    }
}
