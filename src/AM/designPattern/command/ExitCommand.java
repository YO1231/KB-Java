package AM.designPattern.command;

import java.util.Scanner;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("종료할까요?(Y/n) ");
        String answer = scanner.nextLine();
        scanner.close();
        if(answer.isEmpty() || answer.equalsIgnoreCase("Y") ) {
            System.exit(0);
        }
    }
}
