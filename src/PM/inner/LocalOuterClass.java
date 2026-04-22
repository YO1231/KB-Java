package PM.inner;

import javax.swing.*;

public class LocalOuterClass extends JFrame {
    private int outerValue;

    public LocalOuterClass() {
//        this.
    }

    public void method() {
        int localValue = 100;
        class LocalInner {
            public LocalInner() {
                outerValue = 100; // 외부클래스 속성에 접근 가능
            }
        }
    }
}
