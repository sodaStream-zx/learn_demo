package pri.zxx.learndemo.designmodels.bridgemodel;

import pri.zxx.learndemo.designmodels.bridgemodel.imp.Circle;
import pri.zxx.learndemo.designmodels.bridgemodel.imp.Color;
import pri.zxx.learndemo.designmodels.bridgemodel.interfaces.Shape;

public class Test {
    public static void main(String[] args) {
        Shape circle = new Circle();
        circle.setName("园");
        circle.setDrawAPI(new Color());
        circle.draw("黑色");
    }
}
