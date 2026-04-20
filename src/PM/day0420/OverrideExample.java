package PM.day0420;

public class OverrideExample {
    public static void main(String[] args) {
        Notification notification = new SmsNotification();
        notification.send();

        notification = new EmailNotification();
        notification.send();
    }
}
