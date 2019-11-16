package pri.zxx.learndemo.designmodels.factorymodel.interfaces;

public interface ComputerFactory {
    Cpu getCpu(String name);

    Display getDisplay(String name);

    Disk getDisk(String name);

    Power getPower(String name);
}
