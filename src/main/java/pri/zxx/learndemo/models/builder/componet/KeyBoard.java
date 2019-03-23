package pri.zxx.learndemo.models.builder.componet;


import org.apache.log4j.Logger;
import pri.zxx.learndemo.models.builder.componet.IComponet.AbstractComponent;

/**
 * @author 一杯咖啡
 * @desc
 * @createTime 2018-12-23-17:07
 */
public class KeyBoard extends AbstractComponent {
    private static final Logger log = Logger.getLogger(KeyBoard.class);

    public KeyBoard(String name, Double price, String from) {
        super(name, price, from);
    }

    @Override
    public void showDi() {
        log.info("keysBoard : " + this.toString());
    }
}
