package pri.zxx.learndemo.designmodels.flyweightModel.core;

import pri.zxx.learndemo.designmodels.flyweightModel.unit.UnChanged;

import java.util.logging.Logger;

/**
 * @author 一杯咖啡
 * @desc 具体产品
 * @createTime 2018-12-25-22:39
 */
public class ConcreteFlyWeight extends FlyWeight {
    private static final Logger log = Logger.getLogger(ConcreteFlyWeight.class.getName());

    protected ConcreteFlyWeight(UnChanged unChanged) {
        super(unChanged);
    }

    @Override
    public void operate() {
        log.info("具体产品业务逻辑");
    }
}
