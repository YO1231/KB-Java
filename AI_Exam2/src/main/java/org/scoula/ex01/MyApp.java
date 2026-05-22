package org.scoula.ex01;

import org.scoula.cli.App;

public class MyApp extends App {

    @Override
    public void init() {
        register("인사", () -> System.out.println("안녕하세요!"));
        register("날짜", () -> System.out.println("현재 날짜: " + java.time.LocalDate.now()));
        register("종료", () -> {
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        });
    }

    public static void main(String[] args) {
        new MyApp().run();
    }
}
