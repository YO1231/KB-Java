package PM.collection;

import java.util.HashSet;

public class CollectionEx5 {

    public static void main(String[] args) {
        String[] students = {"안건호", "엄성현", "안건호", "김주훈"};
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();

        for (int i = 0; i < students.length; i++) {
            if(!set1.add(students[i])) set2.add(students[i]);
        }
        System.out.println(set1);
        System.out.println(set2);
    }
}
