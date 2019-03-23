package pri.zxx.learndemo.models.mediatorModel.core;

/**
 * @author 一杯咖啡
 * @desc
 * @createTime 2018-12-24-20:25
 */
public class Man extends Person {

    public Man(String name, int condition, Mediator mediator) {
        super(name, condition, mediator);
    }

    @Override
    public void getPartner(Person person) {
        this.getMediator().setMan(this);
        this.getMediator().getPartner(person);
    }
}
