package PM.inner;

public class Outer extends SuperOuter {
    private int outer;
    public Outer() {

    }

    public class Inner {
        private int inner;
        private int outer;
        public Inner() {
            outer = 100; // 내부의 outer 접근
            Outer.this.outer = 1000;
            protectedValue = 100;
//            privateValue = 100;
            System.out.println(outer);
            System.out.println(Outer.this.outer);
        }
    }

    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
    }
}
