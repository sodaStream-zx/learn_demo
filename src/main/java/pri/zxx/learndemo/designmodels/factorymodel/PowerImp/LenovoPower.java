package pri.zxx.learndemo.designmodels.factorymodel.PowerImp;


import pri.zxx.learndemo.designmodels.factorymodel.interfaces.Power;

public class LenovoPower implements Power {

    @Override
    public void ShowPower() {
        // TODO Auto-generated method stub
        System.out.println("联想电源");
    }

}
