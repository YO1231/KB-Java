package PM.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaEx6 {

    public static void main(String[] args) {
//        Consumer<String> consumer =
//        Supplier<String> supplier = () -> "Hi";
//        System.out.println(supplier.get());
//        Function<Integer, String> function = x -> "값:" + x;
//        String result = function.apply(10);
//        System.out.println(result);

        Predicate<Integer> predicate = xx -> xx > 10;
        System.out.println(predicate.test(15));
    }

}
