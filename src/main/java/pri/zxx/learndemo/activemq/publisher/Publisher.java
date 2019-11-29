package pri.zxx.learndemo.activemq.publisher;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.TimeUnit;

public class Publisher {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String URL = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void sendMessage(Session session, MessageProducer producer) {
        for (int i = 1; i <= 10; i++) {

            try {
                Message message = session.createTextMessage("消息条数_" + i);
                producer.send(message);
                TimeUnit.SECONDS.sleep(1);
            } catch (JMSException | InterruptedException e) {
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

        connectionFactory = new ActiveMQConnectionFactory(Publisher.USERNAME, Publisher.PASSWORD, Publisher.URL);
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);//参数1 开启事务，参数2 消息确认方式。
            destination = session.createTopic("FIRST"); //创建主题
            messageProducer = session.createProducer(destination);
            sendMessage(session, messageProducer);
            session.commit();
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
