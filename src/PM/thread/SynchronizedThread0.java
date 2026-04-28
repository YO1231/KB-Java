package PM.thread;

public class SynchronizedThread0 implements Runnable {
    private int money = 10000;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void drawMoney(int howmoney) {
        if (getMoney() <= 0) {
            return;
        } else {
            this.money -= howmoney;
            System.out.println(Thread.currentThread().getName() + "잔액: " + this.getMoney());
        }
    }

    @Override
    public void run() {
        synchronized (this) {
            for(int i=1;i<=10;i++) {
                try {
                    Thread.sleep(1000);
                    drawMoney(1000);
                    if(getMoney()==8000||getMoney()==6000||getMoney()==4000||getMoney()==2000) {
                        this.wait(); // ㅣlock을 해제하고 waitPool로 이동한다
                    }else {
                        this.notify(); //waitPool에 있는 객체를 lockPool로 이동한다
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedThread0 atm = new SynchronizedThread0();
        Thread mother = new Thread(atm, "엄마");
        Thread son = new Thread(atm, "아들");
        mother.start();
        son.start();
    }
}