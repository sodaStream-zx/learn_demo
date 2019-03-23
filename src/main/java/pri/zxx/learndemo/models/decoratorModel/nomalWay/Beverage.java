/**
 * @author 一杯咖啡
 */
package pri.zxx.learndemo.models.decoratorModel.nomalWay;

//饮料类 非装饰着模式

public class Beverage {
    private String description;

    //调料
    private boolean milk;
    private double milkcost = 12;
    private boolean soy;
    private double soycost = 13;
    private boolean mocha;
    private double mochacost = 42;
    private boolean whip;
    private double whipcost = 32;

    public double getMilkcost() {
        return milkcost;
    }

    public void setMilkcost(double milkcost) {
        this.milkcost = milkcost;
    }

    public double getSoycost() {
        return soycost;
    }

    public void setSoycost(double soycost) {
        this.soycost = soycost;
    }

    public double getMochacost() {
        return mochacost;
    }

    public void setMochacost(double mochacost) {
        this.mochacost = mochacost;
    }

    public double getWhipcost() {
        return whipcost;
    }

    public void setWhipcost(double whipcost) {
        this.whipcost = whipcost;
    }

    public double cost() {
        double total = 0.0;
        if (isMilk()) {
            total += milkcost;
        }
        if (isMocha()) {
            total += mochacost;
        }
        if (isSoy()) {
            total += soycost;
        }
        if (isWhip()) {
            total += whipcost;
        }
        return total;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isMilk() {
        return milk;
    }

    public void setMilk(boolean milk) {
        this.milk = milk;
    }

    public boolean isSoy() {
        return soy;
    }

    public void setSoy(boolean soy) {
        this.soy = soy;
    }

    public boolean isMocha() {
        return mocha;
    }

    public void setMocha(boolean mocha) {
        this.mocha = mocha;
    }

    public boolean isWhip() {
        return whip;
    }

    public void setWhip(boolean whip) {
        this.whip = whip;
    }


}