package PM.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaEx10 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry");
//        for (String l : list) {
//            System.out.println(l);
//        }
//
//        list.forEach(x -> System.out.println(x));
//        list.forEach(System.out::println);

        List<String> upperList = list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        upperList.forEach(System.out::println);
    }
}
