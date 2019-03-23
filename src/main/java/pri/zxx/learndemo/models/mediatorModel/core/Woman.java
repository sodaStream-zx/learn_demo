package pri.zxx.learndemo.models.mediatorModel.core;

/**
 * @author 一杯咖啡
 * @desc
 * @createTime 2018-12-24-20:25
 */
public class Woman extends Person {


    public Woman(String name, int condition, Mediator mediator) {
        super(name, condition, mediator);
    }

    @Override
    public void getPartner(Person person) {
        this.getMediator().setWoman(this);
        this.getMediator().getPartner(person);
    }
}
