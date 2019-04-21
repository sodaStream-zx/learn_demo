package pri.zxx.learndemo.collectionDemo;

import org.junit.Test;
import pri.zxx.learndemo.LambdaAndStream.entity.Employee;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-04-21-22:05
 */
public class CollectionsTest {
    @Test
    public void en() {
        Enumeration enumeration = new StringTokenizer("A-B-C", "-");
        while (((StringTokenizer) enumeration).hasMoreTokens()) {
            System.out.println(((StringTokenizer) enumeration).nextToken());
        }
    }

    @Test
    public void myTest() {
        /*删除list中的元素时使用CopyOnWriteArrayList*/
        CopyOnWriteArrayList<String> my = new CopyOnWriteArrayList<>();
        Stream.generate(() -> UUID.randomUUID().toString()).limit(10).forEach(my::add);
        my.forEach(System.out::println);
        for (String x : my) {
            if (x.startsWith("3")) {
                my.remove(x);
            }
        }
        System.out.println("-------------------");
        my.forEach(System.out::println);
    }

    @Test
    public void myTest2() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.sort(Comparator.comparingInt(Employee::getAge).thenComparing(Employee::getName).reversed());

    }
}
