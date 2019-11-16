package pri.zxx.learndemo.designmodels.builder.componet;

import pri.zxx.learndemo.designmodels.builder.componet.IComponet.AbstractComponent;

import java.util.logging.Logger;

/**
 * @author 一杯咖啡
 * @desc
 * @createTime 2018-12-23-17:07
 */
public class Ram extends AbstractComponent {
    private static final Logger log = Logger.getLogger(Ram.class.getName());

    public Ram(String name, Double price, String from) {
        super(name, price, from);
    }

    @Override
    public void showDi() {
        log.info("Ram : " + this.toString());
    }
}
