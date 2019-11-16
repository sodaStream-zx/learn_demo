package pri.zxx.learndemo.designmodels.factorymodel.FactoryImp;

import pri.zxx.learndemo.designmodels.factorymodel.factorys.CpuFactory;
import pri.zxx.learndemo.designmodels.factorymodel.factorys.DiskFactory;
import pri.zxx.learndemo.designmodels.factorymodel.factorys.DisplayFactory;
import pri.zxx.learndemo.designmodels.factorymodel.factorys.PowerFactory;
import pri.zxx.learndemo.designmodels.factorymodel.interfaces.*;

public class LenovoComputer implements ComputerFactory {

    @Override
    public Cpu getCpu(String name) {
        // TODO Auto-generated method stub
        return new CpuFactory().createCpu(name);
    }

    @Override
    public Display getDisplay(String name) {
        // TODO Auto-generated method stub
        return new DisplayFactory().createDisp(name);
    }

    @Override
    public Disk getDisk(String name) {
        // TODO Auto-generated method stub
        return new DiskFactory().createDisk(name);
    }

    @Override
    public Power getPower(String name) {
        // TODO Auto-generated method stub
        return new PowerFactory().createPower(name);
    }

}
