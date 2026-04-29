package PM.lambda;

public class LambdaEx4 {
    public static void main(String[] args) {
        Calc1 c = ((x, y) -> System.out.println(x + y));
        c.calc(100, 200);
    }
}
