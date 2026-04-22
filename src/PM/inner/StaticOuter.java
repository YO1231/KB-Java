package PM.inner;

public class StaticOuter {
    private int outerStatic;

    public void outerMethod() {
//            private int staticValue;
//            static int sValue;
    }

    public static class StaticInner {
        private static int innerValue;

        public StaticInner() {
//            outerStatic=100; staticInnerClass는 외부 클래스에 인스턴스로 접근 불가
        }
    }

    public static void main(String[] args) {
        new StaticOuter.StaticInner();
    }
}
