package PM.thread;

public class Message {
    private int x, y;
    private String msg;

    public Message() {
        super();
    }

    public Message(int x, int y, String msg) {
        this.x = x;
        this.y = y;
        this.msg = msg;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Message{" +
                "x=" + x +
                ", y=" + y +
                ", msg='" + msg + '\'' +
                '}';
    }
}
