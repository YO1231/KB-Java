package PM.generics;

import java.util.Arrays;
import java.util.List;

public class WildcardExample {
    public static void printList(List<? extends Number> list) {
        for (Number num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    //public static <T> List<T> asList(T... a)
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);

        printList(intList);       // 1 2 3
        printList(doubleList);    // 1.1 2.2 3.3
    }
}

