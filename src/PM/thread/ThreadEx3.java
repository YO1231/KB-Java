package PM.thread;

public class ThreadEx3 implements Runnable {
    @Override
    public void run() {
        System.out.println("ThreadEx3 Run");
        Thread.currentThread();
        }

    public static void main(String[] args) {
        ThreadEx3 t1 = new ThreadEx3();
        Thread thread = new Thread(t1);
        thread.start();
    }
}

