package com.basejava.webapp.model;

import java.util.List;
import java.util.Objects;

public class CompanySection implements Section{
    private final List<Experience> experiences;

    public CompanySection(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    @Override
    public String toString() {
        return experiences.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanySection that = (CompanySection) o;
        return experiences.equals(that.experiences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(experiences);
    }
}
