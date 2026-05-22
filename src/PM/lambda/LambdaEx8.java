package PM.lambda;

@FunctionalInterface
interface Compare {
    int compare(String a, String b);
}

public class LambdaEx8 {
    public static void main(String[] args) {
        Compare c1 = (a, b) -> a.compareTo(b);
        System.out.println(c1.compare("A", "B"));

        Compare c2 = String::compareTo;
        System.out.println(c2.compare("B", "A"));


    }
}
