package pri.zxx.learndemo.designmodels.factorymodel.DiskImp;

import pri.zxx.learndemo.designmodels.factorymodel.interfaces.Disk;

public class DellDisk implements Disk {

    @Override
    public void ShowDisk() {
        // TODO Auto-generated method stub
        System.out.println("戴尔内存条");
    }

}
