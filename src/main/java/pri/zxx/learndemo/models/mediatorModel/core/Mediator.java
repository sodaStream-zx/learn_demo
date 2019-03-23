package pri.zxx.learndemo.models.mediatorModel.core;

/**
 * @author 一杯咖啡
 * @desc
 * @createTime 2018-12-24-20:35
 */
public class Mediator {
    private Man man;
    private Woman woman;


    public void setMan(Man man) {
        this.man = man;
    }

    public void setWoman(Woman woman) {
        this.woman = woman;
    }

    public void getPartner(Person person) {
        if (person instanceof Man) {
            this.setMan((Man) person);
        } else {
            this.setWoman((Woman) person);
        }
        if (man.getCondition() == woman.getCondition()) {
            System.out.println(this.man.getName() + "可以的" + this.woman.getName());
        } else {
            System.out.println(this.man.getName() + "不可以的" + this.woman.getName());
        }
    }
}