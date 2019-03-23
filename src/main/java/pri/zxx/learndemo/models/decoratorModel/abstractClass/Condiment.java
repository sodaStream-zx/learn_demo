package pri.zxx.learndemo.models.decoratorModel.abstractClass;

/**
 * desc: 调料抽象类
 **/
public abstract class Condiment extends NowBeverage {
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
