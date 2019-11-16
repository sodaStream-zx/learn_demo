package pri.zxx.learndemo.designmodels.bridgemodel.imp;

import pri.zxx.learndemo.designmodels.bridgemodel.interfaces.DrawAPI;

public class Color implements DrawAPI {

    @Override
    public void drawColor(String colorName) {
        // TODO Auto-generated method stub
        System.out.println("正在画【" + colorName + "】 ");
    }

}
