package pri.zxx.learndemo.models.decoratorModel.coffee;


import pri.zxx.learndemo.models.decoratorModel.abstractClass.NowBeverage;

/**
 * @author 一杯咖啡
 */
public class HouseBlend extends NowBeverage {

    public HouseBlend() {
        this.setDescription("【house-blend-coffee】2.3");
    }

    @Override
    public double cost() {
        return 2.3;
    }

}
