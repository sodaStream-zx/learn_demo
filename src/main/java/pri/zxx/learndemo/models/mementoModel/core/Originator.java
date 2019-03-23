package pri.zxx.learndemo.models.mementoModel.core;

/**
 * @author 一杯咖啡
 * @desc 备份目标
 * @createTime 2018-12-23-23:30
 */
public class Originator {
    private String oName;
    private String oPwd;
    private Boolean isRunning = true;

    public Originator() {
    }

    public Originator(String oName, String oPwd, Boolean isRunning) {
        this.oName = oName;
        this.oPwd = oPwd;
        this.isRunning = isRunning;
    }

    @Override
    public String toString() {
        return "Originator{" +
                "oName='" + oName + '\'' +
                ", oPwd='" + oPwd + '\'' +
                ", isRunning=" + isRunning +
                '}';
    }

    public String getoName() {
        return oName;
    }

    public void setoName(String oName) {
        this.oName = oName;
    }

    public String getoPwd() {
        return oPwd;
    }

    public void setoPwd(String oPwd) {
        this.oPwd = oPwd;
    }

    public Boolean getRunning() {
        return isRunning;
    }

    public void setRunning(Boolean running) {
        isRunning = running;
    }

    /**
     * desc: 备份
     **/
    public Memento createMemento() {
        return new Memento(this.oName, this.oPwd, this.isRunning);
    }

    /**
     * desc: 恢复
     **/
    public void roolBack(Memento memento) {
        this.oName = memento.getoName();
        this.oPwd = memento.getoPwd();
        this.isRunning = memento.getRunning();
    }
}
