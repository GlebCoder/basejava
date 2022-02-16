package com.basejava.webapp.model;

public enum ContactType {
    PHONE("Тел."),
    MOBILE("Моб."),
    SKYPE("Skype"),
    TELEGRAM("Telegram"),
    WHATSAPP("Whatsapp"),
    EMAIL("Email"),
    LINKEDIN("Linkedin"),
    GITHUB("GitHub"),
    HOME_PAGE("Webpage"),
    STACKOVERFLOW("Stackoveflow");

    private final String type;

    ContactType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
