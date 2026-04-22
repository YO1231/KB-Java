package PM.Inheritance;

public class EmailNotification extends Notification {
    public EmailNotification() {
    }

    @Override
    public void send() {
        System.out.println("email notification");
    }
}
