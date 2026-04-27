package PM.thread;

public class ThreadEx2 extends Thread {
    private int[] m = new int[100];

    public ThreadEx2(String name) {
        super(name);
        for (int i = 0; i < m.length; i++) {
            m[i] = i-1;
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < m.length; i++) {
            System.out.println("run" + this.getName());
            try {
                Thread.sleep(100);
            } catch (Exception e) {

            }
        }
    }

    public static void main(String[] args) {
        ThreadEx2 thread1 = new ThreadEx2("수빈");
        ThreadEx2 thread2 = new ThreadEx2("태현");
        thread1.start();
        thread2.start();
    }
}
