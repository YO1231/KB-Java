package PM.stream;

import java.util.Arrays;
import java.util.List;

public class StreamFilterSortExample {
    public static void main(String[] args) {
        List<Course> courses = Arrays.asList(
                new Course("Java", "backend", 90, 150000),
                new Course("Spring", "backend", 95, 220000),
                new Course("React", "frontend", 88, 180000),
                new Course("Docker", "devops", 91, 200000),
                new Course("Java", "backend", 90, 150000)
        );

        System.out.println("1. 중복 제거");

        courses.stream()
                .distinct()
                .forEach(course -> System.out.println(course.getTitle()));

        System.out.println("\n2. 점수 높은순 정렬");

        courses.stream()
                .sorted((c1, c2) -> Integer.compare(c2.getScore(), c1.getScore()))
                .forEach(course -> System.out.println(course.getTitle() + " : " + course.getScore()));

        System.out.println("\n3. peek으로 중간 확인");

        int totalPrice = courses.stream()
                .filter(course -> course.getPrice() >= 180000)
                .peek(course -> System.out.println("필터 통과: " + course.getTitle()))
                .mapToInt(course -> course.getPrice())
                .sum();

        System.out.println("총 가격: " + totalPrice);
    }
}
