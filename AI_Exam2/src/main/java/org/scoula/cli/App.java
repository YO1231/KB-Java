package org.scoula.cli;

import java.util.Scanner;

public abstract class App {
    protected Menu menu = new Menu();

    public void register(String title, Command command) {
        menu.add(new MenuItem(title, command));
    }

    public abstract void init();

    public void run() {
        init();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            menu.printMenu();
            System.out.print("선택> ");
            String input = scanner.nextLine();
            try {
                int choice = Integer.parseInt(input);
                Command command = menu.getCommand(choice);
                if (command != null) {
                    command.execute();
                } else {
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }
}
