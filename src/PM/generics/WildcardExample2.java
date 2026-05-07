package PM.generics;

import java.util.Arrays;
import java.util.List;

public class WildcardExample2 {
    public static void printList(List<?> list) {
        for (Object element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    //public static <T> List<T> asList(T... a)
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<String> doubleList = Arrays.asList("Hello", "World");

        printList(intList);       // 1 2 3
        printList(doubleList);    // 1.1 2.2 3.3
    }
}

