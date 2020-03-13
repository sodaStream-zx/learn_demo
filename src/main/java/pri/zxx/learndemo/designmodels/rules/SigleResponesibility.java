package pri.zxx.learndemo.designmodels.rules;

/**
 * @author Twilight
 * @desc 单一职责原则
 * @createTime 2020-03-13-22:28
 */
public class SigleResponesibility {
    public static void main(String[] args) {
        MachineRun machineRun = new MachineRun();
        machineRun.run("飞机");
        machineRun.run("火箭");
        machineRun.run("汽车");
    }

}

class MachineRun {
    /**
     * 在方法级别上遵守单一职责原则
     * 但是在需要单独处理某种情况需要改动该方法
     */
    public void run(String name) {
        System.out.println(name + "开始运行");
    }
}