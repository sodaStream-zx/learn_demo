package pri.zxx.learndemo.xmlpaser;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Saxdom extends DefaultHandler {
    private List<User> users = new ArrayList<>();
    private User user;
    private String flag = "";

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(new File("xml/user.xml"), new Saxdom());

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    @Override
    public void startDocument() {
        // TODO Auto-generated method stub
        user = new User();
        System.out.println("开始解析文档");
    }

    @Override
    public void endDocument() {
        // TODO Auto-generated method stub
        prinlist(users);
        System.out.println("结束解析文档");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        // TODO Auto-generated method stub
        //开始打印节点名
        System.out.print("<" + qName + " ");
        flag = qName.trim();
        //开始打印节点中的属性 attribute Qname 属性名字，value 属性值
        if (attributes.getLength() != 0) {
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.print(attributes.getQName(i) + "=" + attributes.getValue(i) + ",");
                if (attributes.getQName(i).equals("id")) {
                    user.setId(Integer.parseInt(attributes.getValue(i)));
                }
            }
        }
        System.out.print(">");
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        // TODO Auto-generated method stub
        System.out.println("<" + qName + ">");
        if (qName.equals(user.getName())) {
            users.add(user);
        }
        flag = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        // TODO Auto-generated method stub
        String text = String.copyValueOf(ch, start, length).trim();
        switch (flag) {
            case "age":
                user.setAge(Integer.parseInt(text));
                break;
            case "sex":
                user.setSex(text);
                break;
            case "name":
                user.setName(text);
                break;
        }

        System.out.print(text);
    }

    public void prinlist(List<User> list) {
        for (User value : list) {
            System.out.println(value.toString());
        }
    }
}
