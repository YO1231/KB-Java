package PM.Interfaces.solid;

public abstract class AbstractDisplay {

    // 자식이 반드시 구현해야 하는 메서드
    public abstract void open();
    public abstract void print();
    public abstract void close();

    // 템플릿 메서드 (핵심)
    public final void display() {

// 1단계
        open();

// 2단계 (반복)
        for (int i=0;i<5;i++) {
            print();
        }

// 3단계
        close();
    }
}