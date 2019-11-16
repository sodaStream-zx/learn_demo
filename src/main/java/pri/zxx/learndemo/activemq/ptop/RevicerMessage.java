package pri.zxx.learndemo.activemq.ptop;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class RevicerMessage {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String URL = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void getMessage(Session session, MessageConsumer producer) {

    }

    public static void main(String[] args) {
        ConnectionFactory connectionFactory;//连接工厂
        Connection connection;//连接
        Session session;//发送和接收的事务
        Destination destination;//目的地
        MessageConsumer consumer;//消费者


        connectionFactory = new ActiveMQConnectionFactory(RevicerMessage.USERNAME, RevicerMessage.PASSWORD, RevicerMessage.URL);
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);//参数2 消息确认方式。
            destination = session.createQueue("MyQueue_1");//创建消息队列
            consumer = session.createConsumer(destination);//消费者
            consumer.setMessageListener(new Listener());
            //getMessage(session, consumer);
            //session.commit();
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
