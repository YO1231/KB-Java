package PM.avg.ch15.sec05.exam03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExample {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("홍길동", 35));
        personList.add(new Person("김자바", 25));
        personList.add(new Person("박지원", 31));

        Collections.sort(personList);

        for (Person p : personList) {
            System.out.printf("%s : %d\n", p.name, p.age);
        }
    }
}
