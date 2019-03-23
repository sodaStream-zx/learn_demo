package pri.zxx.learndemo.models.builder.componet;

import models.builder.componet.IComponet.IComputerBuilder;

/**
 * @author 一杯咖啡
 * @desc builder 内部类实例化对象
 * @createTime 2018-12-23-17:06
 */
public class Computer {
    private String comName = "未知电脑型号";
    private String Factory = "未知品牌";
    private Double ComPrices = 0.0;
    private KeyBoard keyBoard;
    private Moniter moniter;
    private Mouse mouse;
    private Ram ram;

    public Computer() {
    }

    @Override
    public String toString() {
        return "Computer{" +
                " \n   comName='" + comName + '\'' +
                ",\n   Factory='" + Factory + '\'' +
                ",\n   ComPrices= ￥" + ComPrices +
                " \n   配置清单如下 :: " +
                " \n   keyBoard=" + keyBoard +
                ",\n   moniter=" + moniter +
                ",\n   mouse=" + mouse +
                ",\n   ram=" + ram +
                '}';
    }

    public String getFactory() {
        return Factory;
    }

    private void setFactory(String factory) {
        Factory = factory;
    }

    public String getComName() {
        return comName;
    }

    private void setComName(String comName) {
        this.comName = comName;
    }

    /*外部无法设置以下配置*/
    public Double getPrices() {
        return ComPrices;
    }

    private void setPrices(Double prices) {
        this.ComPrices += prices;
    }

    private void setKeyBoard(KeyBoard keyBoard) {
        this.keyBoard = keyBoard;
    }

    private void setMoniter(Moniter moniter) {
        this.moniter = moniter;
    }

    private void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    private void setRam(Ram ram) {
        this.ram = ram;
    }

    public static class Builder implements IComputerBuilder {
        private Computer computer;
        private String defauleName = "外星人";
        private String defComFactory = "外星人品牌";

        public Builder() {
            computer = new Computer();
            computer.setComName(defauleName);
            computer.setFactory(defComFactory);
        }

        @Override
        public IComputerBuilder setKeyBoard(KeyBoard keyBoard) {
            computer.setKeyBoard(keyBoard);
            computer.setPrices(keyBoard.getPrice());
            return this;
        }

        @Override
        public IComputerBuilder setMoniter(Moniter moniter) {
            computer.setMoniter(moniter);
            computer.setPrices(moniter.getPrice());
            return this;
        }

        @Override
        public IComputerBuilder setMouse(Mouse mouse) {
            computer.setPrices(mouse.getPrice());
            computer.setMouse(mouse);
            return this;
        }

        @Override
        public IComputerBuilder setRam(Ram ram) {
            computer.setRam(ram);
            computer.setPrices(ram.getPrice());
            return this;
        }

        @Override
        public Computer Build() {
            return this.computer;
        }
    }
}
