package pri.zxx.learndemo.models.decoratorModel;

import pri.zxx.learndemo.models.decoratorModel.abstractClass.NowBeverage;
import pri.zxx.learndemo.models.decoratorModel.coffee.Espresso;
import pri.zxx.learndemo.models.decoratorModel.coffee.HouseBlend;
import pri.zxx.learndemo.models.decoratorModel.condiment.Mocha;
import pri.zxx.learndemo.models.decoratorModel.condiment.Soy;
import pri.zxx.learndemo.models.decoratorModel.condiment.Tall;
import pri.zxx.learndemo.models.decoratorModel.condiment.Whip;

/**
 * desc: 装饰着模式 测试类
 **/
public class DecoratorTest {

    public static void main(String[] args) {
        DecoratorTest decoratorTest = new DecoratorTest();
        decoratorTest.createEspresso();
        decoratorTest.creatHouse();
    }

    public void createEspresso() {
        NowBeverage nowBeverage;
        nowBeverage = new Espresso();
        nowBeverage.showDetail();
        nowBeverage = new Mocha(3.5, nowBeverage);
        nowBeverage.showDetail();
        nowBeverage = new Soy(6.2, nowBeverage);
        nowBeverage.showDetail();
        nowBeverage = new Tall(5.2, nowBeverage);
        nowBeverage.showDetail();
        System.out.println("  ");
    }

    public void creatHouse() {
        NowBeverage nowBeverage;
        //houseBlend 咖啡不加调料
        nowBeverage = new HouseBlend();
        nowBeverage.showDetail();
        //houseBlend 咖啡 加soy调料
        nowBeverage = new Soy(2.5, nowBeverage);
        nowBeverage.showDetail();
        //houseBlend 咖啡加soy调料,mocha调料
        nowBeverage = new Mocha(2.5, nowBeverage);
        nowBeverage.showDetail();
        //houseBlend 咖啡加 全部调料
        nowBeverage = new Whip(3.0, nowBeverage);
        nowBeverage.showDetail();
        //houseBlend 咖啡加 全部调料 小杯
        nowBeverage = new Tall(1.0, nowBeverage);
        nowBeverage.showDetail();
    }
}
