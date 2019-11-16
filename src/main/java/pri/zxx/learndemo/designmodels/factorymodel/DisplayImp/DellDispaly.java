package pri.zxx.learndemo.designmodels.factorymodel.DisplayImp;

import pri.zxx.learndemo.designmodels.factorymodel.interfaces.Display;

public class DellDispaly implements Display {

    @Override
    public void ShowDisplay() {
        // TODO Auto-generated method stub
        System.out.println("戴尔显卡");
    }

}
