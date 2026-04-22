package PM.avg.day0422.ch11.sec02.exam01;

public class ExceptionHandlingExample1 {
    public static void printLength(String data) {
        int result = data.length(); // data가 null이면 NullPointerException
        System.out.println("문자 수: " + result);
    }

    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsJava");
        printLength(null);
        System.out.println("[프로그램 종료]");
    }

    /* 문제점: 예외 처리가 되어있지 않아서, 에러 발생 시 프로그램이 강제로 종료되어 다음 코드가 실행될 수 없습니다.
    따라서, 이 프로그램의 경우 그 다음 코드인 [프로그램 종료]가 실행될 수 없습니다.
     */

}
