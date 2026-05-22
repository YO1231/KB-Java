package PM.stream;

import java.util.Arrays;
import java.util.List;

public class StreamMappingExample {
    public static void main(String[] args) {
        List<Course> courses = Arrays.asList(
                new Course("Java", "backend", 90, 150000),
                new Course("Spring", "backend", 95, 220000),
                new Course("React", "frontend", 88, 180000),
                new Course("Vue", "frontend", 82, 160000)
        );
        int sum = courses.stream()
                .mapToInt(course -> course.getScore())
                .sum();

        double avg = courses.stream()
                .mapToInt(course -> course.getScore())
                .average().orElse(0.0);

        int max = courses.stream()
                .mapToInt(course -> course.getScore()).max().orElse(0);

        int min = courses.stream()
                .mapToInt(course -> course.getScore()).min().orElse(0);

        System.out.println("점수 합계: " + sum);
        System.out.println("점수 평균: " + avg);
        System.out.println("최고 점수: " + max);
        System.out.println("최저 점수: " + min);
    }
}
