package PM.generics;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Stack<T> {
    private List<T> elements = new ArrayList<>();

    public void push(T ele) {
        elements.add(ele);
    }

    public T pop() {
        if (elements.isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.remove(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }

    public static void main(String[] args) {
        // 사용 예시
        Stack<String> stringStack = new Stack<>();
        stringStack.push("Java");
        stringStack.push("Generics");
        System.out.println(stringStack.pop());  // Generics
        System.out.println(stringStack.pop());  // Java

        Stack<Integer> intStack = new Stack<>();
        intStack.push(1);
        intStack.push(2);
        System.out.println(intStack.pop());     // 2
        System.out.println(intStack.pop());     // 1

    }
}
