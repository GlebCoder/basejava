package com.basejava.webapp.model;

import java.util.List;
import java.util.Objects;

public class Experience {
    private final String companyName;
    private List<Position> positions;

    public Experience(String companyName, List<Position> positions) {
        this.companyName = companyName;
        this.positions = positions;
    }

    public String getCompanyName() {
        return companyName;
    }

    public List<Position> getPositions() {
        return positions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Experience that = (Experience) o;
        return Objects.equals(companyName, that.companyName) && Objects.equals(positions, that.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, positions);
    }

    @Override
    public String toString() {
        return "Experience{" +
                "companyName='" + companyName + '\'' +
                ", positions=" + positions +
                '}';
    }
}
