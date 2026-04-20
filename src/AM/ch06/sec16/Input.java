package AM.ch06.sec16;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    String str = scanner.nextLine();

    String read(String title) {
        System.out.print(title);
        return str;
    }

    String read(String title, String defaultValue) {
        System.out.print(title);
        return str;
    }
}
