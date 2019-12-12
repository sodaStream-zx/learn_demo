package pri.zxx.learndemo.lambdaandstream.Lanbda_stream;

import org.junit.Test;
import pri.zxx.learndemo.lambdaandstream.entity.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-03-21-20:48
 */
public class ColletorToMap {
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

    public static Stream<String> col(Employee employee) {
        ArrayList<String> list = new ArrayList<>();
        list.add(String.valueOf(employee.getAge()));
        list.add(employee.getName());
        list.add(String.valueOf(employee.getSalary()));
        list.add(String.valueOf(employee.getStatus()));
        return list.stream();
    }

    @Test
    public void Colletor() {
        String list = "name:zxx,age:13,addr:china,sex:男,love:sleep";
        String[] keyValue = list.split(",");
        Arrays.stream(keyValue)
                .flatMap(x -> Stream.of(x.split(":")))
                .forEach(System.out::println);
        System.out.println("-----------------");
        Arrays.stream(keyValue)
                .map(x -> x.replace(":", ""))
                .forEach(System.out::println);
        System.out.println("-----------------");
        String str = Stream.of(keyValue).reduce(String::concat).orElse("");
        System.out.println(str);
        System.out.println("-----------------");
        Stream.of(list.split(","))
                .map(x -> x.split(":"))
                .collect(Collectors.toMap(o -> o[0], o -> o[1]))
                .forEach((s, s2) -> System.out.println(s + ":" + s2));
    }

    /**
     * flatMap 把 Stream<Collection/map/> 转化为Stream<String/Integer等类型>
     **/
    @Test
    public void create() {
        employees.stream().flatMap(employee -> Stream.of(employee.getAge())).forEach(System.out::println);
        employees.stream().flatMap(ColletorToMap::col).forEach(System.out::println);
        Stream.iterate(1, integer -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return integer + 2;
        }).forEach(System.out::println);
    }
}
