package AM.designPattern.command;

public class OpenCommand implements Command {
    @Override
    public void execute() {
        System.out.println("===============");
        System.out.println("Open command");
        System.out.println("===============");
        System.out.println();
    }
}
