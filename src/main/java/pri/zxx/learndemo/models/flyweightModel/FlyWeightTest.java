package pri.zxx.learndemo.models.flyweightModel;

import pri.zxx.learndemo.models.flyweightModel.core.FlyWeight;
import pri.zxx.learndemo.models.flyweightModel.core.SharedFactory;
import pri.zxx.learndemo.models.flyweightModel.unit.Changed;

import java.util.logging.Logger;

/**
 * @author 一杯咖啡
 * @desc 享元模式 测试类
 * @createTime 2018-12-25-23:04
 */
public class FlyWeightTest {
    private static final Logger log = Logger.getLogger(FlyWeightTest.class.getName());

    public static void main(String[] args) {

        String unitName = "unchanged";

        //获取带有共享单元的类
        FlyWeight f1 = SharedFactory.getFlyWeight(unitName);
        Changed c1 = new Changed("change_1", "可变内容1");
        f1.setChanged(c1);
        log.info(f1.toString());

        //第二次获取共享单元
        FlyWeight f2 = SharedFactory.getFlyWeight(unitName);
        Changed c2 = new Changed("change_2", "可变内容2");
        f2.setChanged(c2);
        log.info(f2.toString());

        //第三次获取共享单元
        FlyWeight f3 = SharedFactory.getFlyWeight(unitName);
        Changed c3 = new Changed("change_3", "可变内容3");
        f3.setChanged(c3);
        log.info(f3.toString());
    }
}
