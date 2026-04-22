package PM.Interfaces.solid;

public class CashPayment implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("현금 결제: " + amount);
    }
}
