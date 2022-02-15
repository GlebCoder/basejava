package com.basejava.webapp.model;

public enum SectionType {
    OBJECTIVE("Позиция"),
    PERSONAL("Личные качества"),
    ACHIEVEMENTS("Достижения"),
    QUALIFICATIONS("Квалификация"),
    EXPERIENCE("Опыт работы"),
    EDUCATION("Образование");

    private String type;

    SectionType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
