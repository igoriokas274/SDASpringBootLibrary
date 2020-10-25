package lt.igorl.helloworld.configuration;

import lt.igorl.helloworld.beans.HelloWorld;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("lt.igorl.helloworld.beans")
@PropertySource("classpath:message.properties")
public class JavaConfig {

    //
    // Code block disabled for automatic config solution
    //

/*    @Bean
    public HelloWorld helloWorld() {
        return new HelloWorld();
    }*/

}
