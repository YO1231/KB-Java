package PM.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person<T extends Comparable<T>> implements Comparable<Person<T>> {
    private T age;

    public Person(T age) {
        this.age = age;
    }

    public T getAge() {
        return age;
    }

    @Override
    public int compareTo(Person<T> other) {
        return this.age.compareTo(other.getAge());
    }

    @Override
    public String toString() {
        return "Person(age=" + age + ")";
    }

    public static void main(String[] args) {
        Person<Integer> p1 = new Person<>(25);
        Person<Integer> p2 = new Person<>(30);

        if (p1.compareTo(p2) < 0) {
            System.out.println("p1이 p2보다 나이가 적습니다.");
        } else {
            System.out.println("p1이 p2보다 나이가 많거나 같습니다.");
        }

        System.out.println();

        List<Person<Integer>> list = new ArrayList<>();
        list.add(new Person<>(40));
        list.add(new Person<>(20));
        list.add(new Person<>(30));

        System.out.println("정렬 전:");
        System.out.println(list);

        Collections.sort(list);

        System.out.println("정렬 후:");
        System.out.println(list);

        System.out.println();

        // 내림차순
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("내림차순 정렬:");
        System.out.println(list);

        System.out.println();

        Person<Double> d1 = new Person<>(5.5);
        Person<Double> d2 = new Person<>(3.3);

        if (d1.compareTo(d2) > 0) {
            System.out.println("d1이 d2보다 나이가 많습니다");
        } else {
            System.out.println("d1이 d2보다 나이가 적거나 같습니다");
        }

        System.out.println();

        // 4. 다양한 타입 리스트 테스트
        List<Person<Double>> doubleList = new ArrayList<>();
        doubleList.add(new Person<>(2.2));
        doubleList.add(new Person<>(1.1));
        doubleList.add(new Person<>(3.3));

        System.out.println("Double 리스트 정렬 전:");
        System.out.println(doubleList);

        Collections.sort(doubleList);

        System.out.println("Double 리스트 정렬 후:");
        System.out.println(doubleList);
    }
}
