package lt.igorl.helloworld.beans;

import lt.igorl.helloworld.interfaces.Message;

public class HelloWorld implements Message {

    private String message;

    public HelloWorld() {

    }

    public String getCustomMessage() {

        return "Interface was called";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
