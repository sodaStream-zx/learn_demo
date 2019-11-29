package pri.zxx.learndemo.designmodels.bridgemodel.interfaces;

public abstract class Shape {

    private String name;
    private DrawAPI drawAPI;

    public Shape() {

    }
    public Shape(String name) {
        this.name = name;
    }

    public void draw(String colorName) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DrawAPI getDrawAPI() {
        return drawAPI;
    }

    public void setDrawAPI(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

}
