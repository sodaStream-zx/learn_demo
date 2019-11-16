package pri.zxx.learndemo.designmodels.factorymodel.factorys;


import pri.zxx.learndemo.designmodels.factorymodel.DisplayImp.DellDispaly;
import pri.zxx.learndemo.designmodels.factorymodel.DisplayImp.HuasuoDisp;
import pri.zxx.learndemo.designmodels.factorymodel.DisplayImp.LenovoDisp;
import pri.zxx.learndemo.designmodels.factorymodel.interfaces.AbDisp;
import pri.zxx.learndemo.designmodels.factorymodel.interfaces.Display;

public class DisplayFactory implements AbDisp {
    public Display createDisp(String name) {
        switch (name.toLowerCase()) {
            case "lenovo":
                return new LenovoDisp();
            case "dell":
                return new DellDispaly();
            case "huasuo":
                return new HuasuoDisp();
            default:
                return null;
        }
    }
}
