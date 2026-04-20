package PM.day0420;

public class Employee {
    String name;
    int employeeId;

    public void goToWork() {
        System.out.println(this.name + "님 출근합니다.");
    }

    public void showInfo() {
        System.out.println("이름: " + this.name);
        System.out.println("사번 " + this.employeeId);
    }

}
