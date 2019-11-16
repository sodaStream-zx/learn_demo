package pri.zxx.learndemo.designmodels.factorymodel.factorys;


import pri.zxx.learndemo.designmodels.factorymodel.DiskImp.DellDisk;
import pri.zxx.learndemo.designmodels.factorymodel.DiskImp.HuaSuoDisk;
import pri.zxx.learndemo.designmodels.factorymodel.DiskImp.LenovoDisk;
import pri.zxx.learndemo.designmodels.factorymodel.interfaces.AbDisk;
import pri.zxx.learndemo.designmodels.factorymodel.interfaces.Disk;

public class DiskFactory implements AbDisk {
    public Disk createDisk(String name) {
        switch (name.toLowerCase()) {
            case "lenovo":
                return new LenovoDisk();
            case "dell":
                return new DellDisk();
            case "huasuo":
                return new HuaSuoDisk();
            default:
                return null;
        }
    }
}
