package lt.igorl.helloworld.app;

import lt.igorl.helloworld.beans.HelloWorld;
import lt.igorl.helloworld.configuration.JavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class appJava {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        HelloWorld message = context.getBean("helloWorld", HelloWorld.class);
        System.out.println(message.getMessage());

        context.close();
    }
}
