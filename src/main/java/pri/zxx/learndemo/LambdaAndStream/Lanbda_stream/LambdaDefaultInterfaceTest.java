package pri.zxx.learndemo.LambdaAndStream.Lanbda_stream;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @author Twilight
 * @desc java8 内置函数式接口
 * 1.Comsumer<T> :消费型接口
 * void accept(T t)
 * 2.Supplier<T> :供给型接口
 * T get
 * 3. Function<T ,R> :函数新接口
 * R apply（T t）
 * 4.Predicate<T> :断言型接口
 * boolean test(T t )
 * @createTime 2019-01-13-16:28
 */
public class LambdaDefaultInterfaceTest {

    @Test
    public void test1() {
        happy(100.0, (m) -> System.out.println("消费" + m));
    }

    public void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }
}
