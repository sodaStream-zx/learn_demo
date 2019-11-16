package pri.zxx.learndemo.designmodels.commandModel.core.abstractObj;

/**
 * @author 一杯咖啡
 * @desc
 * @createTime 2018-12-23-2:58
 */
public interface ICommand {
    void execute();

    void undo();
}
