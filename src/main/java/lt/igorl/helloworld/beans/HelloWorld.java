package lt.igorl.helloworld.beans;

import lt.igorl.helloworld.interfaces.Message;

public class HelloWorld implements Message {

    public HelloWorld() {
        System.out.println("HalloWorld empty constructor was called");
    }

    public String getCustomMessage() {
        return "Hello World!";
    }
}
