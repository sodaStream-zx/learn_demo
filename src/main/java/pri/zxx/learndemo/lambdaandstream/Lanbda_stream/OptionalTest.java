package pri.zxx.learndemo.lambdaandstream.Lanbda_stream;

import org.junit.Test;
import pri.zxx.learndemo.lambdaandstream.entity.Employee;

import java.util.Optional;
import java.util.logging.Logger;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-01-17-0:50
 */
public class OptionalTest {

    private static final Logger log = Logger.getLogger(OptionalTest.class.getName());

    @Test
    public void test() {
        log.info("optional----------------");
        Optional<Employee> op = Optional.of(new Employee());
        Employee emp = op.get();
        log.info("emp:" + emp);

        Optional<Employee> op2 = Optional.empty();
        log.info("emp = " + op2.isPresent());

        Optional<Employee> op3 = Optional.ofNullable(null);
        log.info("op3:" + op3.isPresent());

        Optional<Employee> op4 = Optional.ofNullable(null);
        if (op4.isPresent()) {
            log.info("op4:" + op4.get());
        } else {
            log.info("no value");
        }

        Optional<Employee> op5 = Optional.ofNullable(null);
        Employee eo = op5.orElse(new Employee());
        System.out.println("eo" + eo);
    }
}
