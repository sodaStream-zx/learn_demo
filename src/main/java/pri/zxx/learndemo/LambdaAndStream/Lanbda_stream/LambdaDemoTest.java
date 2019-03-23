package pri.zxx.learndemo.LambdaAndStream.Lanbda_stream;

import org.junit.Test;
import pri.zxx.learndemo.LambdaAndStream.entity.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Twilight
 * @desc lambda 表达式: java 8 引入了新的操作符“->”
 * 该操作符将lambda 分为2部分
 * <p>
 * 左侧：lambda 表达式的参数列表（接口功能参数）
 * 右侧：表达式所需执行的功能，lambda体（接口需实现的方法体）
 * <p>
 * 只有一个抽象方法的接口，为函数式接口 @FunctionInterface (检查该接口是否 函数式接口)
 * <p>
 * 语法1: 抽象方法无参， 无返回 ：
 * () ->System.out.println("--");
 * 语法2：有一个参数，无返回值：
 * (x) ->System.out.println("--");
 * 语法3：有一个参数，无返回值：
 * x->System.out.println("--");
 * 语法4：多个参数 有返回值,多条语句
 * （x,y）->｛sentence1，sentence2，sentence3;return sentence4;}:
 * 语法5：lambda 一条语句，有返回值 return 和｛｝ 都可以省略不写
 * 语法6：带数据类型
 * (Integer x ,String y)->{....};
 * 数据类型可以不写 java 编译器，可以通过上下文猜测数据类型，类型推断
 * </P>
 * @createTime 2019-01-13-15:14
 */
public class LambdaDemoTest {

    @Test
    public void test() {
        //jdk 1.7 以前，必须为final
        final int num = 1;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("no lambda" + num);
            }
        };
        runnable.run();
        Runnable r2 = () -> System.out.println("hello lambda" + num);
        r2.run();
    }

    @Test
    public void test2() {
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("s=" + s);
            }
        };
        Consumer<String> con2 = (x) -> System.out.println("x=" + x);
        con.accept("hello1");
        con2.accept("hello");
    }

    @Test
    public void test3() {
        List<Employee> employees = Arrays.asList(
                new Employee("ZHANSAN ", 18, 1000.0),
                new Employee("LISI ", 26, 6000.0),
                new Employee("WANGWU ", 38, 2000.0),
                new Employee("WANGER ", 54, 5000.0)
        );
        Collections.sort(employees, (o1, o2) -> {
            if (o1.getAge() == o2.getAge()) {
                return o1.getName().compareTo(o2.getName());
            } else {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });

        for (Employee e : employees) {
            System.out.println(e.toString());
        }
    }

}
