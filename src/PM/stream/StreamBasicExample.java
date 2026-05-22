package PM.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class StreamBasicExample {
    public static void main(String[] args) {
        List<Course> courses = Arrays.asList(
                new Course("Java", "backend", 90, 150000),
                new Course("Spring", "backend", 95, 220000),
                new Course("React", "frontend", 88, 180000),
                new Course("Vue", "frontend", 82, 160000)
        );

        System.out.println("1. 전체 강의명 출력");
//        for (Course c : courses) {
//            System.out.println(c.getTitle());
//        }
        courses.stream().forEach(course -> System.out.println(course.getTitle()));
//        Consumer<String> action = course -> System.out.println(course);
//        action.accept("hi");

        System.out.println("\n2. 90점 이상 강의만 출력");
        courses.stream().filter(course -> course.getScore() >= 90)
                .forEach(course -> System.out.println(course.getTitle()));
    }
}
