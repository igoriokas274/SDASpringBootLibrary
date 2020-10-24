package lt.igorl.helloworld.app;

import lt.igorl.helloworld.interfaces.Message;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class appXml {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Message message = context.getBean("helloWorld", Message.class);

        System.out.println(message.getCustomMessage());

        context.close();


    }
}
