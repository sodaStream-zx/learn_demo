package pri.zxx.learndemo.designmodels.factorymodel.factorys;


import pri.zxx.learndemo.designmodels.factorymodel.PowerImp.DellPower;
import pri.zxx.learndemo.designmodels.factorymodel.PowerImp.HuasuoPower;
import pri.zxx.learndemo.designmodels.factorymodel.PowerImp.LenovoPower;
import pri.zxx.learndemo.designmodels.factorymodel.interfaces.AbPower;
import pri.zxx.learndemo.designmodels.factorymodel.interfaces.Power;

public class PowerFactory implements AbPower {
    public Power createPower(String name) {
        switch (name.toLowerCase()) {
            case "lenovo":
                return new LenovoPower();
            case "dell":
                return new DellPower();
            case "huasuo":
                return new HuasuoPower();
            default:
                return null;
        }
    }
}
