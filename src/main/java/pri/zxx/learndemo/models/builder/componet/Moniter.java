package pri.zxx.learndemo.models.builder.componet;

import org.apache.log4j.Logger;
import pri.zxx.learndemo.models.builder.componet.IComponet.AbstractComponent;

/**
 * @author 一杯咖啡
 * @desc
 * @createTime 2018-12-23-17:07
 */
public class Moniter extends AbstractComponent {
    private static final Logger log = Logger.getLogger(Moniter.class);

    public Moniter(String name, Double price, String from) {
        super(name, price, from);
    }

    @Override
    public void showDi() {
        log.info("Moniter : " + this.toString());
    }
}
