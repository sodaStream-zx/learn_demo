package pri.zxx.learndemo.designmodels.factorymodel;


import pri.zxx.learndemo.designmodels.factorymodel.FactoryImp.CreatComputer;

public class Test {
    public static void main(String[] args) {
        CreatComputer creatComputer = new CreatComputer("lenovo", "dell", "huasuo", "lenovo");
        creatComputer.getCpu().showCpu();
        creatComputer.getDisk().ShowDisk();
        creatComputer.getDisplay().ShowDisplay();
        creatComputer.getPower().ShowPower();
        System.out.println(creatComputer.toString());
    }
}
