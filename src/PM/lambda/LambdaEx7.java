package PM.lambda;

class Computer {
    public int multiply(int x, int y) {
        return x * y; // 두 값을 곱해서 반환
    }
}

@FunctionalInterface
interface Calc4 {
    int calc(int x, int y);
}

public class LambdaEx7 {
    public static void main(String[] args) {
        Computer c = new Computer();
        Calc4 c1 = (x, y) -> c.multiply(x, y);
        Calc4 c2 = c::multiply;
        System.out.println(c1.calc(10, 20));
        System.out.println(c2.calc(10,20));
    }
}
