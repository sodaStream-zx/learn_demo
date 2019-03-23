package pri.zxx.learndemo.models.flyweightModel.core;

import models.flyweightModel.unit.UnChanged;
import org.apache.log4j.Logger;

/**
 * @author 一杯咖啡
 * @desc 具体产品
 * @createTime 2018-12-25-22:39
 */
public class ConcreteFlyWeight extends FlyWeight {
    private static final Logger log = Logger.getLogger(ConcreteFlyWeight.class);

    protected ConcreteFlyWeight(UnChanged unChanged) {
        super(unChanged);
    }

    @Override
    public void operate() {
        log.info("具体产品业务逻辑");
    }
}
