package PM.lambda;

public class LambdaEx3 {

    public static void main(String[] args) {
//        LambdaEx3 lambdaEx3 = new LambdaEx3();
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Thread Setting");
//            }
//        });
//        t.run();

        Thread t = new Thread(() -> System.out.println("Thread run~~"));
        t.run();
    }
}
