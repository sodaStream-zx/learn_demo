package pri.zxx.learndemo.models.mementoModel.core;

import org.apache.log4j.Logger;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 一杯咖啡
 * @desc 备份管理
 * @createTime 2018-12-23-23:37
 */
public class CareTaker {
    private static final Logger log = Logger.getLogger(CareTaker.class);
    private final Map<String, Memento> mementoMap = new HashMap<>(2);

    public void addMemento(String mementoTip, Memento memento) {
        this.mementoMap.put(mementoTip, memento);
    }

    public Memento getMemento(String mementoTip) {
        return this.mementoMap.get(mementoTip);
    }

    public void showAllMemento() {
        Set<Map.Entry<String, Memento>> key = this.mementoMap.entrySet();
        for (Map.Entry<String, Memento> k : key) {
            log.info(k.getKey() + " : " + k.getValue().toString());
        }
        log.info("--------------不同遍历方式测试----------");
        iterator(this.mementoMap);
    }

    public void iterator(Map<String, Memento> map) {
        map.forEach((s, memento) -> log.info(s + " :: " + memento.toString()));

        log.info("-------------分别打印key 和value---------------");
        //只需要key 或者 value
        Set<String> keys = map.keySet();
        for (String k : keys) {
            log.info("key = " + k);
        }
        Collection<Memento> mementos = map.values();
        for (Memento m : mementos) {
            log.info("memento = " + m.toString());
        }
    }
}
