package com.basejava.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Position {
    private final LocalDate start;
    private final LocalDate finish;
    private final String position;
    private final String description;

    public Position(LocalDate start, LocalDate finish, String position, String description) {
        this.start = start;
        this.finish = finish;
        this.position = position;
        this.description = description;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return Objects.equals(start, position1.start) && Objects.equals(finish, position1.finish) && Objects.equals(position, position1.position) && Objects.equals(description, position1.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, finish, position, description);
    }

    @Override
    public String toString() {
        return "Position{" +
                "start=" + start +
                ", finish=" + finish +
                ", position='" + position + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
