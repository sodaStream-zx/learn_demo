package pri.zxx.learndemo.designmodels.factorymodel.CpuImp;

import pri.zxx.learndemo.designmodels.factorymodel.interfaces.Cpu;

public class LenovoCpu implements Cpu {

    @Override
    public void showCpu() {
        // TODO Auto-generated method stub
        System.out.println("联想cpu");
    }
}
