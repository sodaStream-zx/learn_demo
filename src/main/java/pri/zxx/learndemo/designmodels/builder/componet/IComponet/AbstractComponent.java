package pri.zxx.learndemo.designmodels.builder.componet.IComponet;

/**
 * @author 一杯咖啡
 * @desc
 * @createTime 2018-12-23-17:08
 */
public abstract class AbstractComponent {
    private String name;
    private Double price;
    private String from;

    public AbstractComponent(String name, Double price, String from) {
        this.name = name;
        this.price = price;
        this.from = from;
    }

    public abstract void showDi();

    @Override
    public String toString() {
        return "Component{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", from='" + from + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
