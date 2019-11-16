package pri.zxx.learndemo.designmodels.builder.componet.IComponet;


import pri.zxx.learndemo.designmodels.builder.componet.*;

/**
 * @author 一杯咖啡
 * @desc 内部类接口
 * @createTime 2018-12-23-17:18
 */
public interface IComputerBuilder {
    IComputerBuilder setKeyBoard(KeyBoard keyBoard);

    IComputerBuilder setMoniter(Moniter moniter);

    IComputerBuilder setMouse(Mouse mouse);

    IComputerBuilder setRam(Ram ram);

    Computer Build();
}
