package PM.Inheritance;

public class InheritanceBasicExample {
    public static void main(String[] args) {
        Developer dev = new Developer();

        dev.name = "민수";
        dev.employeeId = 101;
        dev.mainLanguage = "JAVA";

        dev.goToWork();
        dev.showInfo();
        dev.coding();
    }
}
