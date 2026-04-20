package AM.ch08.sec11.exam02;

import java.util.Scanner;

public class DriverExample {
    public static void main(String[] args) {
        int v;
        Vehicle[] cars = {
                new Taxi(),
                new Bus(),
                new Truck()
        };
        Scanner sc = new Scanner(System.in);
        Driver driver = new Driver();

        System.out.println("운전할 차를 선택하세요.");
        System.out.println("1) Taxi 2) Bus 3) Truck");

        v = sc.nextInt();

//        cars[v-1].run();
        driver.drive(cars[v-1]);
    }
}
