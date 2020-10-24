package lt.igorl.halloworld.app;

import lt.igorl.halloworld.interfaces.Message;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class appXml {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Message message = context.getBean("halloWorld", Message.class);

        System.out.println(message.getCustomMessage());

        context.close();


    }
}
