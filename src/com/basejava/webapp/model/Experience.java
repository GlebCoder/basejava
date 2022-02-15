package com.basejava.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Experience {
    private final String companyName;
    private final LocalDate start;
    private final LocalDate finish;
    private final String position;
    private final String description;

    public Experience(String companyName, LocalDate start, LocalDate finish, String position, String description) {
        this.companyName = companyName;
        this.start = start;
        this.finish = finish;
        this.position = position;
        this.description = description;
    }

    public String getCompanyName() {
        return companyName;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getFinish() {
        return finish;
    }

    public String getPosition() {
        return position;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "companyName='" + companyName + '\'' +
                ", start=" + start +
                ", finish=" + finish +
                ", position='" + position + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Experience that = (Experience) o;
        return Objects.equals(companyName, that.companyName) && Objects.equals(start, that.start) && Objects.equals(finish, that.finish) && Objects.equals(position, that.position) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, start, finish, position, description);
    }
}
