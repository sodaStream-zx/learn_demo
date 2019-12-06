package pri.zxx.learndemo.LambdaAndStream.Lanbda_stream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pri.zxx.learndemo.LambdaAndStream.entity.Employee;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Twilight
 * @desc java 8 streamAPi 操作 流
 * @createTime 2019-01-13-20:31
 */
public class StreamOperationsTest {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
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
    private List<String> list = Arrays.asList("ssf", "edr", "efe", "sxd", "ghk", "sewd", "sadas", "scd");

    //流转换
    public static Stream<Character> convertToChars(String str) {
        List<Character> characters = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            characters.add(aChar);
        }
        return characters.stream();
    }

    /**
     * desc:流创建方式
     **/
    @Test
    public void createTest() {
        //1.collections  default method stream,paralluelstream
        List<Integer> myList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        myList.forEach(System.out::print);
        System.out.println("-------------------");
        myList.stream().filter(s -> s > 3).peek(System.out::print).forEach(System.out::print);
        System.out.println("-----------------");
        String[] array = new String[]{"hello", "hi", "congradution", "tradition", "consumer", "you"};
        //2. Stream  method
        Stream<String> strtream = Stream.of(array);
        strtream.forEach(System.out::print);
        System.out.println(" 无限流---------------");
        Stream.iterate(1, s -> {
            this.pause(1, 0);
            return s + 2;
        }).limit(10).forEach(System.out::println);

        Stream.generate(() -> {
            pause(1, 0);
            return Math.random();
        }).limit(10).forEach(System.out::println);

    }

    /**
     * desc:切片（过滤）
     **/
    @Test
    public void filterOpe() {
        System.out.println("stream 切片操作-----------------");
        System.out.println("过滤--------------------");
        employees.stream().filter(s -> s.getAge() > 18).forEach(System.out::println);
        System.out.println("短路操作--------------------");
        employees.stream().filter((e) -> e.getSalary() > 1000.0).limit(2).forEach(System.out::println);
        System.out.println("扔掉前2个--------------------");
        employees.stream().skip(2).forEach(System.out::println);
        System.out.println("去重--------------------");
        employees.stream().distinct().forEach(System.out::println);
    }

    /**
     * desc:映射
     **/
    @Test
    public void mapOpe() {
        System.out.println("stream 映射操作-----------------");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        System.out.println("获取emp name ----------------");
        employees.stream().map(Employee::getName).forEach(System.out::println);
        System.out.println("字符串流转字符流 嵌套流 ----------------");
        //{aaa,bbb,ccc,ddd}->｛｛a,a,a｝，｛b,b,b｝，｛c,c,c｝，｛d,d,d｝｝
        list.stream().map(StreamOperationsTest::convertToChars).forEach((c) -> c.forEach(System.out::println));
        System.out.println("字符串流转字符流 ，并合并流 ----------------");
        //{aaa,bbb,ccc,ddd}->｛｛a,a,a｝，｛b,b,b｝，｛c,c,c｝，｛d,d,d｝｝->{a,a,a,b,b,b,c,c,c,d,d,d}
        list.stream().flatMap(StreamOperationsTest::convertToChars).forEach(System.out::println);
    }

    /**
     * desc:排序
     **/
    @Test
    public void sortOpe() {
        System.out.println("stream 排序操作-----------------");
        System.out.println("自然排序----------------");
        list.stream().sorted().forEach(System.out::println);
        System.out.println("自定义排序----------------");
        employees.stream().sorted((e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return -String.valueOf(e1.getAge()).compareTo(String.valueOf(e2.getAge()));
            }
        }).forEach(System.out::println);
    }

    /**
     * desc:终止
     **/
    @Test
    public void stopOpe() {
        System.out.println("------------stream 终止操作-----------------");
        boolean allMatch = employees.stream().allMatch((s) -> s.getStatus().equals(Employee.Status.BUSY));
        System.out.println("匹配所有 : " + allMatch);
        boolean anyMatch = employees.stream().anyMatch((s) -> s.getStatus().equals(Employee.Status.BUSY));
        System.out.println("至少匹配一个 : " + anyMatch);
        boolean noneMath = employees.stream().noneMatch((s) -> s.getStatus().equals(Employee.Status.BUSY));
        System.out.println("没有匹配 : " + noneMath);
        //Optional 容器类
        Optional<Employee> first = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).findFirst();
        System.out.println("返回第一个:" + first.orElseGet(Employee::new).toString());
        long totalNum = employees.size();
        System.out.println("返回数量 : " + totalNum);
        Optional<Double> max = employees.stream().map(Employee::getSalary).max(Double::compare);
        Optional<Double> min = employees.stream().map(Employee::getSalary).min(Double::compare);
        System.out.println("返回sanry max/min : " + max.orElse(0.0) + "/" + min.orElse(0.0));

    }

    /**
     * desc:归约
     **/
    @Test
    public void reduceOpe() {
        System.out.println("stream 归约操作-----------------");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println("--------reduce(ope)---------");
        int sum = list.stream().reduce(0, Integer::sum);
        System.out.println("reduce(seed,ope) with seeds : " + sum);
        OptionalDouble total = employees.stream().mapToDouble(Employee::getSalary).reduce(Double::sum);
        System.out.println("reduce(ope) total no seeds : " + total.orElse(0.0));

        System.out.println("---------- collector 收集器---------");
        System.out.println("---------- collector.toList---------");
        employees.stream().map(Employee::getName).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("---------- collector.toset---------");
        employees.stream().map(Employee::getName).collect(Collectors.toSet()).forEach(System.out::println);
        System.out.println("---------- collector.toCollection(LinkedHashMap)---------");
        employees.stream().map(Employee::getName).collect(Collectors.toCollection(LinkedHashSet::new)).forEach(System.out::println);
        long totalNum = employees.stream().map(Employee::getName).count();
        System.out.println("---------- collector.counting() = " + totalNum + "---------");
        //averaging* 平均值
        //Summing* 总和
        System.out.println("---------- collector.grouping && partitioningBy---------");
        Map<Employee.Status, List<Employee>> groupMap = employees.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(groupMap.toString());
        Map<Boolean, List<Employee>> partinGroup = employees.stream().collect(Collectors.partitioningBy((e) -> e.getAge() > 20));
        System.out.println(partinGroup.toString());

    }

    /**
     * desc: 休眠
     **/
    public void pause(int second, long mills) {
        try {
            TimeUnit.SECONDS.sleep(second);
            TimeUnit.MILLISECONDS.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
