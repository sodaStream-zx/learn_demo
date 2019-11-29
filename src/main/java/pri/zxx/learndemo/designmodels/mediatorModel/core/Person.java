package pri.zxx.learndemo.designmodels.mediatorModel.core;

/**
 * desc:
 *
 * @Return:
 **/
public abstract class Person {
    private String name;
    private int condition;
    private Mediator mediator;

    public Person(String name, int condition, Mediator mediator) {
        this.name = name;
        this.condition = condition;
        this.mediator = mediator;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", condition=" + condition +
                ", mediator=" + mediator +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void getPartner(Person person);
}
