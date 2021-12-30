package ru.nessing.graphs;

import java.util.Objects;

public class Vertex {
    private final String label;
    private boolean isVisited;
    private int distance;

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public Vertex(String label) {
        this.label = label;
    }

    public Vertex(String label, int distance) {
        this.label = label;
        this.distance = distance;
    }

    public String getLabel() {
        return label;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vertex vertex = (Vertex) o;
        return Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return label;
    }
}
