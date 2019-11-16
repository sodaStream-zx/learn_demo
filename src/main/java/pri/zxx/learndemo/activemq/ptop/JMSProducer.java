package pri.zxx.learndemo.activemq.ptop;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.TimeUnit;

public class JMSProducer {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String URL = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void sendMessage(Session session, MessageProducer producer) {
        for (int i = 1; i <= 30; i++) {

            try {
                Message message = session.createTextMessage("消息条数_" + i);
                producer.send(message);
                TimeUnit.SECONDS.sleep(1);
            } catch (JMSException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println("发送第 " + i + " 消息");
        }
    }

    public static void main(String[] args) {
        ConnectionFactory connectionFactory;//连接工厂
        Connection connection;//连接
        Session session;//发送和接收的事务
        Destination destination;//目的地
        MessageProducer messageProducer;//发送者

        connectionFactory = new ActiveMQConnectionFactory(JMSProducer.USERNAME, JMSProducer.PASSWORD, JMSProducer.URL);
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);//参数1 开启事务，参数2 消息确认方式。
            destination = session.createQueue("MyQueue_1");//创建消息队列
            messageProducer = session.createProducer(destination);
            sendMessage(session, messageProducer);
            session.commit();
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
