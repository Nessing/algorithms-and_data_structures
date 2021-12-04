package ru.nessing.lesson_2;

public class Notebook {

    private int position;
    private String name;
    private int memory;
    private int price;

    public Notebook(int pos, String name, int memory, int price) {
        this.position = pos;
        this.name = name;
        this.memory = memory;
        this.price = price;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public int getMemory() {
        return memory;
    }

    public int getPrice() {
        return price;
    }
}
