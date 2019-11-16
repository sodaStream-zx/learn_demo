package pri.zxx.learndemo.designmodels.factorymodel.factorys;


import pri.zxx.learndemo.designmodels.factorymodel.CpuImp.DellCpu;
import pri.zxx.learndemo.designmodels.factorymodel.CpuImp.HuasuoCpu;
import pri.zxx.learndemo.designmodels.factorymodel.CpuImp.LenovoCpu;
import pri.zxx.learndemo.designmodels.factorymodel.interfaces.AbCpu;
import pri.zxx.learndemo.designmodels.factorymodel.interfaces.Cpu;

public class CpuFactory implements AbCpu {
    public Cpu createCpu(String name) {
        switch (name.toLowerCase()) {
            case "lenovo":
                return new LenovoCpu();
            case "dell":
                return new DellCpu();
            case "huasuo":
                return new HuasuoCpu();
            default:
                return null;
        }
    }
}
