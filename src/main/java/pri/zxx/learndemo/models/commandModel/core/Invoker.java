package pri.zxx.learndemo.models.commandModel.core;


import pri.zxx.learndemo.models.commandModel.core.abstractObj.ICommand;

/**
 * @author 一杯咖啡
 * @desc
 * @createTime 2018-12-23-3:00
 */
public class Invoker {
    private ICommand iCommand;

    public Invoker(ICommand iCommand) {
        this.iCommand = iCommand;
    }

    public ICommand getiCommand() {
        return iCommand;
    }

    public void setiCommand(ICommand iCommand) {
        this.iCommand = iCommand;
    }

    public void call() {
        iCommand.execute();
    }

    public void undo() {
        iCommand.undo();
    }
}
