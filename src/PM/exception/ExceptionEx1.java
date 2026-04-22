package PM.exception;

public class ExceptionEx1 {
    public void arrayIndex() {
        int[] m = new int[5];
        for (int i = 0; i <= m.length; i++) {

        }
    }

    public void cloneNot() {
        ExceptionEx1 e1 = new ExceptionEx1();
        try {
            Object e2 = e1.clone();
            System.out.println(e2);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
