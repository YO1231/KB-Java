package PM.generics;

public class Box<T>{
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.setItem("딸기");
        Box<Integer> intBox = new Box<>();
        intBox.setItem(123);
    }
}
