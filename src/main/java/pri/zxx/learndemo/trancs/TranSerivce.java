package pri.zxx.learndemo.trancs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Twilight
 * @desc 服务
 * @createTime 2019-05-12-22:19
 */
@Service
public class TranSerivce {
    private static final Logger log = LoggerFactory.getLogger(TranSerivce.class);
    @Autowired
    private Confirmed confirmed;

    public void notifyStatus(String str) throws InterruptedException {
        log.warn(str + "1状态修改服务");
        TimeUnit.SECONDS.sleep(2);
        this.transferToTranc(true);
        while (confirmed.getServicesNum() <= 3) {
            if (confirmed.getServicesNum() == 3) {
                if (confirmed.getFlag()) {
                    log.warn("任务都完成提交事务");
                    break;
                } else {
                    log.warn("任务未全部完成 服务1 回滚事务");
                    break;
                }
            }
        }
    }

    public void notufyData(String str) throws InterruptedException {
        log.warn(str + "2修改数据服务");
        TimeUnit.SECONDS.sleep(1);
        this.transferToTranc(true);
        while (confirmed.getServicesNum() <= 3) {
            if (confirmed.getServicesNum() == 3) {
                if (confirmed.getFlag()) {
                    log.warn("任务都完成提交事务");
                    break;
                } else {
                    log.warn("任务未全部完成 服务2 回滚事务");
                    break;
                }
            }
        }
    }

    public void boundData(String str) throws InterruptedException {
        log.warn(str + "3绑定数据服务");
        TimeUnit.SECONDS.sleep(2);
        this.transferToTranc(true);
        while (confirmed.getServicesNum() <= 3) {
            if (confirmed.getServicesNum() == 3) {
                if (confirmed.getFlag()) {
                    log.warn("任务都完成提交事务");
                    break;
                } else {
                    log.warn("任务未全部完成 服务3 回滚事务");
                    break;
                }
            }
        }
    }

    public void transferToTranc(Boolean flag) {
        confirmed.notifyTranc(flag);
    }
}
