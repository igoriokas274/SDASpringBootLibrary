package lt.igorl.halloworld.beans;

import lt.igorl.halloworld.interfaces.Message;

public class HalloWorld implements Message {

    public HalloWorld() {
        System.out.println("HalloWorld empty constructor was called");
    }

    public String getCustomMessage() {
        return "Hello World!";
    }
}
