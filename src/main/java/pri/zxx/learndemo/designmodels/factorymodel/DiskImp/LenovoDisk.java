package pri.zxx.learndemo.designmodels.factorymodel.DiskImp;

import pri.zxx.learndemo.designmodels.factorymodel.interfaces.Disk;

public class LenovoDisk implements Disk {

    @Override
    public void ShowDisk() {
        // TODO Auto-generated method stub
        System.out.println("联想内存条");
    }

}
