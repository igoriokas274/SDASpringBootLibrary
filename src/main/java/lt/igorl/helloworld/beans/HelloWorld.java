package lt.igorl.helloworld.beans;

import lt.igorl.helloworld.interfaces.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloWorld implements Message {

    @Value("${foo.message}")
    private String message;

    public HelloWorld() {

    }

    public String getCustomMessage() {

        return "getCustomMessage() from Message interface was called";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
