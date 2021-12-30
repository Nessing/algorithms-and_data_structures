package ru.nessing.graphs;

public class Tracker {
    int location;
    int index;
    int size;

    public Tracker(int location, int size) {
        this.location = location;   // В какой точке мы находимся
        this.index = 0;             // указатель по направлениям в данной точке
        this.size = size;           // Значение для контороля указателя
    }

    public int getIndex() {
        return index;
    }

    public int getLocation() {
        return location;
    }

    public int next() {
        return index++;
    }

    public boolean isActive() {
        if(index < size) return true;
        return false;
    }
}
