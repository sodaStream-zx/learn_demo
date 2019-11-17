package pri.zxx.learndemo.xmlpaser;


import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DomPares {
    public static void printAttrs(Node node) {
        NamedNodeMap attrs = node.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            Node currentnode = attrs.item(i);
            System.out.print(" " + currentnode.getNodeName() + " = " + currentnode.getNodeValue() + "");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("xml/user.xml");
            NodeList users = document.getElementsByTagName("users");
            Element userNode = (Element) users.item(0);
            System.out.print(userNode.getNodeName());
            printAttrs(userNode);
            NodeList user = userNode.getElementsByTagName("user");
            for (int i = 0; i < user.getLength(); i++) {
                Element element = (Element) user.item(i);
                System.out.println("-----------------------------------");
                System.out.print(element.getNodeName() + i);
                printAttrs(element);
                System.out.println("name:" + element.getElementsByTagName("name").item(0).getFirstChild().getNodeValue());
                System.out.println("age:" + element.getElementsByTagName("age").item(0).getFirstChild().getNodeValue());
                System.out.println("sex:" + element.getElementsByTagName("sex").item(0).getFirstChild().getNodeValue());

            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
