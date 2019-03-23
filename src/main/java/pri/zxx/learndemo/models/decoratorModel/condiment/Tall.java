package pri.zxx.learndemo.models.decoratorModel.condiment;


import pri.zxx.learndemo.models.decoratorModel.abstractClass.Condiment;
import pri.zxx.learndemo.models.decoratorModel.abstractClass.NowBeverage;

/**
 * desc: 调料
 *
 * @author 一杯咖啡
 */
public class Tall extends Condiment {

    private NowBeverage nowBeverage;

    public Tall(double price, NowBeverage beverage) {
        this.setPrice(price);
        this.nowBeverage = beverage;
    }

    @Override
    public String getDescription() {
        return nowBeverage.getDescription() + "+【Tall】" + getPrice();
    }

    @Override
    public double cost() {
        return getPrice() + nowBeverage.cost();
    }

}
