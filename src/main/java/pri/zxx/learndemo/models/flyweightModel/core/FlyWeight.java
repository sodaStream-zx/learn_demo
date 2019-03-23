package pri.zxx.learndemo.models.flyweightModel.core;

import models.flyweightModel.unit.Changed;
import models.flyweightModel.unit.UnChanged;

/**
 * @author 一杯咖啡
 * @desc 产品抽象类
 * @createTime 2018-12-25-22:37
 */
public abstract class FlyWeight {
    /**
     * tips: 外部状态(不可变) protected 未提供public 方法，仅仅子类可用
     * 如果是private，未提供public 方法，其他类无法使用 不可改变共享单元
     **/
    protected final UnChanged unChanged;
    /**
     * tips: 内部状态，可变，每个产品实例拥有不同的 【可变非共享单元】。可随意修改
     **/
    private Changed changed;

    protected FlyWeight(UnChanged unChanged) {
        this.unChanged = unChanged;
    }

    public abstract void operate();

    public Changed getChanged() {
        return changed;
    }

    public void setChanged(Changed changed) {
        this.changed = changed;
    }

    @Override
    public String toString() {
        return "\nFlyWeight = {" +
                "changed=" + (changed == null ? "null" : changed.toString()) +
                ", unChanged=" + unChanged.toString() +
                '}';
    }
}
