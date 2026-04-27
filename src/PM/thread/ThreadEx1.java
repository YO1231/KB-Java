package PM.thread;

public class ThreadEx1 {
    public void forEx() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i+"for");
        }
    }

    public void whileEx() {
        int i=0;
        while (i < 100) {
            System.out.println(i++ + "while");
        }
    }

    public void run() {
        System.out.println("run");
        forEx();
        whileEx();
    }

    public static void main(String[] args) {
        ThreadEx1 t = new ThreadEx1();
        t.run();
    }
}
