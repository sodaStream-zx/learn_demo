package pri.zxx.learndemo.transction;

import org.springframework.stereotype.Service;

/**
 * @author Twilight
 * @desc 事务确认数据
 * @createTime 2019-05-12-22:18
 */
@Service
public class Confirmed {
    private Integer servicesNum = 0;
    private Boolean flag = true;

    public synchronized void notifyTranc(Boolean insertFlag) {
        servicesNum++;
        //如果为false 则有服务失败了，事务回滚
        if (!insertFlag) {
            this.flag = insertFlag;
        }
    }

    public synchronized Integer getServicesNum() {
        return servicesNum;
    }

    public void setServicesNum(Integer servicesNum) {
        this.servicesNum = servicesNum;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
