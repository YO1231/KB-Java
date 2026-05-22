package PM.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollectExample {
    public static void main(String[] args) {
        List<Course> courses = Arrays.asList(
                new Course("Java", "backend", 90, 150000),
                new Course("Spring", "backend", 95, 220000),
                new Course("React", "frontend", 88, 180000),
                new Course("Vue", "frontend", 82, 160000),
                new Course("Docker", "devops", 91, 200000)
        );

        System.out.println("1. backend 강의명만 List로 수집");

        List<String> backendTitles = courses.stream()
                .filter(course -> course.getCategory().equals("backend"))
                .map(course -> course.getTitle())
                .collect(Collectors.toList());

        System.out.println(backendTitles);

        System.out.println("\n2. 강의명과 점수를 Map으로 수집");

        Map<String, Integer> scoreMap = courses.stream()
                .collect(Collectors.toMap(
                        course -> course.getTitle(), // key
                        course -> course.getScore()  // value
                ));

        System.out.println(scoreMap);

        System.out.println("\n3. 카테고리별 그룹핑");

        Map<String, List<Course>> groupMap = courses.stream()
                .collect(Collectors.groupingBy(
                        course -> course.getCategory() // 그룹 기준
                ));

        // 그룹별 출력
        groupMap.forEach((category, list) -> {
            System.out.println("카테고리: " + category);

            list.forEach(course ->
                    System.out.println(" - " + course.getTitle())
            );
        });

        System.out.println("\n4. 카테고리별 점수 총합");

        Map<String, Integer> scoreSumMap = courses.stream()
                .collect(Collectors.groupingBy(
                        course -> course.getCategory(), // 카테고리로 묶고
                        Collectors.summingInt(course -> course.getScore()) // 점수 합계 계산
                ));

        System.out.println(scoreSumMap);

        System.out.println("\n5. 카테고리별 점수 평균");

        Map<String, Double> scoreAvgMap = courses.stream()
                .collect(Collectors.groupingBy(
                   course -> course.getCategory(),
                   Collectors.averagingInt(course -> course.getScore())
                ));

        System.out.println(scoreAvgMap);
    }
}
