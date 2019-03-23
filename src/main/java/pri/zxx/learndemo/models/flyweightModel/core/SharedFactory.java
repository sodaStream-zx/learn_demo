package pri.zxx.learndemo.models.flyweightModel.core;

import org.apache.log4j.Logger;
import pri.zxx.learndemo.models.flyweightModel.unit.UnChanged;

import java.util.HashMap;

/**
 * @author 一杯咖啡
 * @desc 共享单元工厂
 * @createTime 2018-12-25-22:55
 */
public class SharedFactory {
    private static final Logger log = Logger.getLogger(SharedFactory.class);
    private static HashMap<String, FlyWeight> pool = new HashMap<>();

    //获取可共享单元实例
    public static FlyWeight getFlyWeight(String unitName) {
        FlyWeight flyWeight;
        if (pool.containsKey(unitName)) {
            flyWeight = pool.get(unitName);
        } else {
            log.info("没有可用共享单元,初始化并返回实例");
            flyWeight = new ConcreteFlyWeight(new UnChanged(unitName, "初始化不可变单元-" + unitName));
            pool.put(unitName, flyWeight);
        }
        return flyWeight;
    }
}
