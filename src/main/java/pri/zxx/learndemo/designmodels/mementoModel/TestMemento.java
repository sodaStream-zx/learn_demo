package pri.zxx.learndemo.designmodels.mementoModel;

import pri.zxx.learndemo.designmodels.mementoModel.core.CareTaker;
import pri.zxx.learndemo.designmodels.mementoModel.core.Originator;

import java.util.logging.Logger;


/**
 * @author 一杯咖啡
 * @desc 备忘录模式 测试类
 * @createTime 2018-12-23-23:41
 */
public class TestMemento {
    private static final Logger log = Logger.getLogger(TestMemento.class.getName());

    public static void main(String[] args) {
        Originator originator = new Originator("zxx", "1234", true);
        CareTaker careTaker = new CareTaker();
        //第一次备份
        careTaker.addMemento("or_1", originator.createMemento());
        originator.setRunning(false);
        //第二次备份
        careTaker.addMemento("or_2", originator.createMemento());
        originator.setoName("zxx3");
        //第三次备份
        careTaker.addMemento("or_3", originator.createMemento());
        log.info("now the orign is ：" + originator);
        originator.roolBack(careTaker.getMemento("or_1"));
        log.info("roolback to initializer ：" + originator);

        //备份表
        careTaker.showAllMemento();
    }
}
