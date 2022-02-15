package com.basejava.webapp.model;

import java.util.List;
import java.util.Objects;

public class ComplexSection implements Section{
    private final List<String> contents;

    public ComplexSection(List<String> contents) {
        this.contents = contents;
    }

    public List<String> getContents() {
        return contents;
    }

    @Override
    public String toString() {
        return contents.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexSection that = (ComplexSection) o;
        return Objects.equals(contents, that.contents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contents);
    }
}
