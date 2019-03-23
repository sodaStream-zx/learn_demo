package pri.zxx.learndemo.models.flyweightModel.unit;

/**
 * @author 一杯咖啡
 * @desc 共享单元 不可变
 * @createTime 2018-12-25-22:50
 */
public class UnChanged {
    private String name;
    private String desc;

    public UnChanged(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    /*@Override
    public String toString() {
        return "Changed{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
