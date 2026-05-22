package PM.stream;

import java.util.Objects;

/*
 * Course 클래스
 *
 * 강의 정보를 저장하는 데이터 클래스입니다.
 *
 * Stream 예제에서는 보통 문자열이나 숫자만 다루는 것보다
 * 이렇게 객체를 사용하면 실무에 더 가까운 연습을 할 수 있습니다.
 *
 * 하나의 Course 객체는 강의 하나를 의미합니다.
 */
public class Course {

    // 강의명입니다. 예: Java, Spring, React
    private String title;

    // 강의 분야입니다. 예: backend, frontend, devops
    private String category;

    // 강의 점수입니다. 예: 90, 95
    private int score;

    // 강의 가격입니다. 예: 150000
    private int price;

    /*
     * 생성자입니다.
     *
     * Course 객체를 만들 때 필요한 값을 한 번에 넣습니다.
     *
     * 예:
     * new Course("Java", "backend", 90, 150000)
     */
    public Course(String title, String category, int score, int price) {
        this.title = title;
        this.category = category;
        this.score = score;
        this.price = price;
    }

    /*
     * getter 메서드입니다.
     *
     * 필드가 private이기 때문에 외부에서 직접 접근할 수 없습니다.
     * 그래서 getTitle(), getScore() 같은 메서드를 통해 값을 꺼냅니다.
     */
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public int getScore() {
        return score;
    }

    public int getPrice() {
        return price;
    }

    /*
     * equals()
     *
     * 두 Course 객체가 같은지 비교하는 기준을 정합니다.
     *
     * distinct()로 객체 중복을 제거하려면 equals()가 필요합니다.
     * 여기서는 title, category, score, price가 모두 같으면
     * 같은 Course라고 판단합니다.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Course)) {
            return false;
        }

        Course course = (Course) o;

        return score == course.score
                && price == course.price
                && Objects.equals(title, course.title)
                && Objects.equals(category, course.category);
    }

    /*
     * hashCode()
     *
     * equals()를 재정의하면 hashCode()도 같이 재정의해야 합니다.
     *
     * HashSet, HashMap, distinct() 같은 기능은
     * 객체를 비교할 때 equals()와 hashCode()를 함께 사용합니다.
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, category, score, price);
    }

    /*
     * toString()
     *
     * 객체를 출력할 때 보기 좋게 문자열로 바꿔주는 메서드입니다.
     *
     * 이 메서드가 없으면 Course@3f99bd52 같은 형태로 출력됩니다.
     */
    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", score=" + score +
                ", price=" + price +
                '}';
    }
}