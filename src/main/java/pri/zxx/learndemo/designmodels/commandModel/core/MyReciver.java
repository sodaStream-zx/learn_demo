package pri.zxx.learndemo.designmodels.commandModel.core;

import pri.zxx.learndemo.designmodels.commandModel.core.abstractObj.Revicer;

import java.util.logging.Logger;

/**
 * @author 一杯咖啡
 * @desc
 * @createTime 2018-12-23-3:02
 */
public class MyReciver implements Revicer {
    private static final Logger log = Logger.getLogger(MyReciver.class.getName());

    @Override
    public void action() {
        log.info("revicer action!!");
    }

    @Override
    public void undo() {
        log.info("revicer undo");
    }
}
