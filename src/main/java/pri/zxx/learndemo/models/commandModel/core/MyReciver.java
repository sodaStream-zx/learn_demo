package pri.zxx.learndemo.models.commandModel.core;

import org.apache.log4j.Logger;
import pri.zxx.learndemo.models.commandModel.core.abstractObj.Revicer;

/**
 * @author 一杯咖啡
 * @desc
 * @createTime 2018-12-23-3:02
 */
public class MyReciver implements Revicer {
    private static final Logger log = Logger.getLogger(MyReciver.class);

    @Override
    public void action() {
        log.info("revicer action!!");
    }

    @Override
    public void undo() {
        log.info("revicer undo");
    }
}
