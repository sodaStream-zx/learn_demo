package pri.zxx.learndemo.models.mediatorModel;

import pri.zxx.learndemo.models.mediatorModel.core.Man;
import pri.zxx.learndemo.models.mediatorModel.core.Mediator;
import pri.zxx.learndemo.models.mediatorModel.core.Person;
import pri.zxx.learndemo.models.mediatorModel.core.Woman;

/**
 * @author 一杯咖啡
 * @desc 中介者模式 测试类
 * @createTime 2018-12-24-20:29
 */
public class MediatorTest {
    public static void main(String[] args) {
        // 创建中介
        Mediator mediator = new Mediator();
        //每个人到中介处登记
        Person za = new Man("张三", 1, mediator);
        Person xf = new Woman("xiaofang", 3, mediator);
        Person ls = new Man("lisi", 3, mediator);
        xf.getPartner(za);
        xf.getPartner(ls);
        za.getPartner(ls);
    }
}
