package PM.lambda;

interface Calc {
    int calc(int x, int y);
}

public class LambdaEx5 {
    public static void main(String[] args) {
//        Calc c = new Calc() {
//            @Override
//            public int calc(int x, int y) {
//                return x+y;
//            }
//        };

        Calc c = Math::max;
        System.out.println(c.calc(10,50));
    }
}
