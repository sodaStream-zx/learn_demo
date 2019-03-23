package pri.zxx.learndemo.LambdaAndStream.Lanbda_stream;

import LambdaAndStream.entity.Employee;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-01-16-0:02
 */
public class StreamProblemTest {
    private List<Employee> employees = Arrays.asList(
            new Employee("ZHANSAN ", 18, 1000.0, Employee.Status.FREE),
            new Employee("LISI ", 26, 6000.0, Employee.Status.VOCATION),
            new Employee("ella ", 38, 2000.0, Employee.Status.BUSY),
            new Employee("WANGER ", 54, 5000.0, Employee.Status.FREE),
            new Employee("WANGER ", 54, 5000.0, Employee.Status.BUSY),
            new Employee("WANGER ", 54, 5000.0, Employee.Status.FREE),
            new Employee("WANGER ", 54, 5000.0, Employee.Status.FREE),
            new Employee("WANGER ", 54, 5000.0, Employee.Status.FREE),
            new Employee("WANGER ", 54, 5000.0, Employee.Status.FREE)
    );

    @Test
    public void test1() {
        Integer[] arr = new Integer[]{1, 2, 3, 5, 6, 7};
        Stream.of(arr).map(x -> x * x).forEach(System.out::println);
        // Stream.of(arr).reduce((x)->x*x);
    }

    @Test
    public void test2() {
        Optional<Integer> count = employees.stream().map((e) -> 1).reduce(Integer::sum);
        System.out.println(count);
    }

    @Test
    public void test3() {
        Instant start = Instant.now();
        Long sum = LongStream.range(0, 1000000000L).parallel().reduce(0, Long::sum);
        Instant end = Instant.now();
        System.out.println("time : " + Duration.between(start, end).toMillis() + "mills,result : " + sum);
    }
}
