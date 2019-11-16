package pri.zxx.learndemo.activemq.ptop;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class Listener implements MessageListener {

    @Override
    public void onMessage(Message arg0) {
        // TODO Auto-generated method stub
        try {
            System.out.println("收到消息内容：" + ((TextMessage) arg0).getText());
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
