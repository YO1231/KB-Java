package PM.day0420;

public class SmsNotification extends Notification {
    public SmsNotification() {
    }

    @Override
    public void send() {
//        super.send();
        System.out.println("sms notification");
    }

}
