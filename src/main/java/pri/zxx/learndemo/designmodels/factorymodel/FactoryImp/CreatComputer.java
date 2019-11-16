package pri.zxx.learndemo.designmodels.factorymodel.FactoryImp;


import pri.zxx.learndemo.designmodels.factorymodel.factorys.CpuFactory;
import pri.zxx.learndemo.designmodels.factorymodel.factorys.DiskFactory;
import pri.zxx.learndemo.designmodels.factorymodel.factorys.DisplayFactory;
import pri.zxx.learndemo.designmodels.factorymodel.factorys.PowerFactory;
import pri.zxx.learndemo.designmodels.factorymodel.interfaces.Cpu;
import pri.zxx.learndemo.designmodels.factorymodel.interfaces.Disk;
import pri.zxx.learndemo.designmodels.factorymodel.interfaces.Display;
import pri.zxx.learndemo.designmodels.factorymodel.interfaces.Power;

public class CreatComputer {
    private Cpu cpu;
    private Display display;
    private Disk disk;
    private Power power;

    public CreatComputer(String cpu, String power, String disp, String disk) {
        // TODO Auto-generated constructor stub
        this.cpu = new CpuFactory().createCpu(cpu);
        this.display = new DisplayFactory().createDisp(disp);
        this.disk = new DiskFactory().createDisk(disk);
        this.power = new PowerFactory().createPower(power);

    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public Disk getDisk() {
        return disk;
    }

    public void setDisk(Disk disk) {
        this.disk = disk;
    }

    public Power getPower() {
        return power;
    }

    public void setPower(Power power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "CreatComputer [cpu=" + cpu + ", display=" + display + ", disk=" + disk + ", power=" + power + "]";
    }

}
