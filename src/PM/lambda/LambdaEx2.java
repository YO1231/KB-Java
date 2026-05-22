package PM.lambda;

public class LambdaEx2 {
    public static void main(String[] args) {
        Task t = () -> {
            System.out.println("Task~");
        };
        t.run();
    }
}
