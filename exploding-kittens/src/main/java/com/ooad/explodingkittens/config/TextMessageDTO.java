package com.ooad.explodingkittens.config;

public class TextMessageDTO {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "TextMessageDTO{" +
                "message='" + message + '\'' +
                '}';
    }
}
