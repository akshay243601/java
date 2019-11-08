package com.java.notification.model;

public enum NotificationType {
    MAIL("mail"),
    SMS("sms"),
    PUSH("push");
    private String type;

    NotificationType(String type) {
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
