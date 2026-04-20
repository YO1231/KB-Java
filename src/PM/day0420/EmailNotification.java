package PM.day0420;

public class EmailNotification extends Notification {
    public EmailNotification() {
    }

    @Override
    public void send() {
        System.out.println("email notification");
    }
}
