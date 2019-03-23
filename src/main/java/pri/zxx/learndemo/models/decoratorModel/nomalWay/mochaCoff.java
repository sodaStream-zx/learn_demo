package pri.zxx.learndemo.models.decoratorModel.nomalWay;


/**
 * desc: 非装饰者模式
 **/
public class mochaCoff extends Beverage {

    public mochaCoff() {
        setDescription("this is mocha coffee");
    }

    public static void main(String[] args) {
        mochaCoff coff = new mochaCoff();
        coff.setMilk(true);
        coff.setMocha(true);
        System.out.println(coff.getDescription());
        System.out.println(coff.cost());
    }

    @Override
    public double cost() {
        return 1.99 + super.cost();
    }
}
