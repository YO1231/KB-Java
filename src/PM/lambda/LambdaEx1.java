package PM.lambda;

public class LambdaEx1 {
    public static void main(String[] args) {
//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("작업실행");
//            }
//        };
//        r.run();

        Runnable r = () -> System.out.println("작업실행");
        r.run();

    }
}
