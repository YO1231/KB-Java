package PM.Inheritance;

public class OverrideExample {
    public static void main(String[] args) {
        Notification notification = new SmsNotification();
        notification.send();

        notification = new EmailNotification();
        notification.send();
    }
}
