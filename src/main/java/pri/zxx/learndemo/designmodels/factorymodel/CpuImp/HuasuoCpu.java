package pri.zxx.learndemo.designmodels.factorymodel.CpuImp;

import pri.zxx.learndemo.designmodels.factorymodel.interfaces.Cpu;

public class HuasuoCpu implements Cpu {

    @Override
    public void showCpu() {
        // TODO Auto-generated method stub
        System.out.println("华硕cpu");
    }

}
