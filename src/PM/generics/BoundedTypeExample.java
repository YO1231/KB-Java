package PM.generics;

public class BoundedTypeExample<T extends Number> {
    private T number;

    public BoundedTypeExample(T number) {
        this.number = number;
    }

    public double square() {
        return number.doubleValue() * number.doubleValue();
    }

    public static void main(String[] args) {
        BoundedTypeExample<Integer> intExample = new BoundedTypeExample<>(5);
        System.out.println("Square: " + intExample.square());
        BoundedTypeExample<Double> doubleExample = new BoundedTypeExample<>(5.5);
        System.out.println("Square: " + doubleExample.square());
    }
}
