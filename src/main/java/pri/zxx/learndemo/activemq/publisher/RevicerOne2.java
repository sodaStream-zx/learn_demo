package pri.zxx.learndemo.activemq.publisher;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import pri.zxx.learndemo.activemq.ptop.Listener;

import javax.jms.*;

public class RevicerOne2 {
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


        connectionFactory = new ActiveMQConnectionFactory(RevicerOne2.USERNAME, RevicerOne2.PASSWORD, RevicerOne2.URL);
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);//参数2 消息确认方式。
            destination = session.createTopic("FIRST");
            consumer = session.createConsumer(destination);//消费者
            consumer.setMessageListener(new Listener());
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
