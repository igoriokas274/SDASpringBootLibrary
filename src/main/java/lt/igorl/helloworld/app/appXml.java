package lt.igorl.helloworld.app;

import lt.igorl.helloworld.beans.HelloWorld;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class appXml {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        HelloWorld message = context.getBean("myHelloWorld", HelloWorld.class);

        System.out.println(message.getCustomMessage());
        System.out.println(message.getMessage());

        context.close();
    }
}
