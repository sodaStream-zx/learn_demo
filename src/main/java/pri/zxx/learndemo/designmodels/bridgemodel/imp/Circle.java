package pri.zxx.learndemo.designmodels.bridgemodel.imp;

import pri.zxx.learndemo.designmodels.bridgemodel.interfaces.Shape;

public class Circle extends Shape {

    @Override
    public void draw(String colorName) {
        // TODO Auto-generated method stub
        System.out.println("draw Type :" + getName());
        getDrawAPI().drawColor(colorName);
    }

}
