package com.codatics.common.utitilty;

class MessageUtil {

    private String message;

    public MessageUtil(String message) {
        super();
        this.message = message;
    }

    // prints the message
    public String printMessage() {
        System.out.println(message);
        return message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
