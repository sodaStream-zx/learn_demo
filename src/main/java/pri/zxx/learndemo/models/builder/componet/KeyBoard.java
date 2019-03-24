package pri.zxx.learndemo.models.builder.componet;


import pri.zxx.learndemo.models.builder.componet.IComponet.AbstractComponent;

import java.util.logging.Logger;

/**
 * @author 一杯咖啡
 * @desc
 * @createTime 2018-12-23-17:07
 */
public class KeyBoard extends AbstractComponent {
    private static final Logger log = Logger.getLogger(KeyBoard.class.getName());

    public KeyBoard(String name, Double price, String from) {
        super(name, price, from);
    }

    @Override
    public void showDi() {
        log.info("keysBoard : " + this.toString());
    }
}
