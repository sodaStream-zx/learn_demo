package pri.zxx.learndemo.models.commandModel.core;


import pri.zxx.learndemo.models.commandModel.core.abstractObj.ICommand;
import pri.zxx.learndemo.models.commandModel.core.abstractObj.Revicer;

/**
 * @author 一杯咖啡
 * @desc 具体命令
 * @createTime 2018-12-23-3:02
 */
public class OnCommand implements ICommand {
    private Revicer revicer;


    public OnCommand(Revicer revicer) {
        this.revicer = revicer;
    }

    public void setRevicer(Revicer revicer) {
        this.revicer = revicer;
    }

    @Override
    public void execute() {
        revicer.action();
    }

    @Override
    public void undo() {
        revicer.undo();
    }
}
