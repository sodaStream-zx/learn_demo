package pri.zxx.learndemo.designmodels.decoratorModel.condiment;

import pri.zxx.learndemo.designmodels.decoratorModel.abstractClass.Condiment;
import pri.zxx.learndemo.designmodels.decoratorModel.abstractClass.NowBeverage;

/**
 * desc: 调料
 *
 * @author 一杯咖啡
 */
public class Mocha extends Condiment {

    private NowBeverage nowBeverage;

    public Mocha(double price, NowBeverage beverage) {
        this.setPrice(price);
        this.nowBeverage = beverage;
    }

    @Override
    public String getDescription() {
        return nowBeverage.getDescription() + "+【mocha】" + getPrice();
    }

    @Override
    public double cost() {
        return getPrice() + nowBeverage.cost();
    }

}
