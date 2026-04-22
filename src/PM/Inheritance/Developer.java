package PM.Inheritance;

public class Developer extends Employee {
    String mainLanguage;
    public void coding() {
        System.out.println(this.name + "님이 " + this.mainLanguage + "를 개발합니다." );
    }
}
