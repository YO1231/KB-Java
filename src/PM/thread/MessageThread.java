package PM.thread;

public class MessageThread extends Thread {
    ThreadEx4 t;
    Message message; //글자 하나하나 Thread처리
    public MessageThread(ThreadEx4 t, Message message) {
        super();
        this.t = t;
        this.message = message;
    }
    public MessageThread() {
        super();
    }
    public MessageThread(ThreadEx4 t) {
        super();
        this.t = t;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(200); // 0.2초마다 휴먼상태
                message.setY(message.getY()+(int)(Math.random()*5));
                t.getPan().repaint(); //Canvas를 상속받은 pan을 repaint해서 글자가 움직인다
            } catch (Exception e) {
            }

        }
    }
}
