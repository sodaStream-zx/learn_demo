package pri.zxx.learndemo.designmodels.mementoModel.core;

/**
 * @author 一杯咖啡
 * @desc 备份类
 * @createTime 2018-12-23-23:31
 */
public class Memento {
    private String oName;
    private String oPwd;
    private Boolean isRunning;

    public Memento(String oName, String oPwd, Boolean isRunning) {
        this.oName = oName;
        this.oPwd = oPwd;
        this.isRunning = isRunning;
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

    @Override
    public String toString() {
        return "Memento{" +
                "oName='" + oName + '\'' +
                ", oPwd='" + oPwd + '\'' +
                ", isRunning=" + isRunning +
                '}';
    }
}
