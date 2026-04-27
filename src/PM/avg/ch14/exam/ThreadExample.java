package PM.avg.ch14.exam;

public class ThreadExample {
    public static void main(String[] args) {
        Thread movieThread = new MovieThread();
        movieThread.start();

        Thread musicRunnable = new Thread(new MusicRunnable());
        musicRunnable.start();
    }
}
