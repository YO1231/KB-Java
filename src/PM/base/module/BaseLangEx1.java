package PM.base.module;

public class BaseLangEx1 {
    public void objectMethod1() {
        Object obj = new Object();
        System.out.println(obj.equals(new Object())); // false
        System.out.println(obj.equals(obj)); // true

        System.out.println(obj.hashCode());
        System.out.println(new Object().hashCode());
        System.out.println(obj.toString());
    }

    public void objectMethod2(Object data) {
        if (data instanceof String)
            System.out.println(((String) (data)).charAt(0));
        if (data instanceof Integer)
            System.out.println(((Integer) (data)).intValue());
        if (data instanceof Double)
            System.out.println(((Double)(data)).doubleValue());
    }

    public void objectMethod3() {
        String str1 = new String("abc");
        String str2 = new String("abc");
        System.out.println(str1 == str2);
        System.out.println(str1.hashCode() == str2.hashCode()); // 덮어씀
        String str3 = "java";
        String str4 = "spring";
        System.out.println(str3.startsWith("j"));
        System.out.println(str4.startsWith("j"));
        System.out.println(str3.equals(str3));
        System.out.println(str3.equals("java"));
    }

    public static void main(String[] args) {
        BaseLangEx1 base = new BaseLangEx1();
//        base.objectMethod2("Hello");
//        base.objectMethod2(10);
    base.objectMethod3();
    }

}
