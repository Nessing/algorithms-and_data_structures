package ru.nessing.lesson_2;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        final int SIZE = 50000;
        final int MAX_PRICE = 3000;
        final int STEP_PRICE = 50;

        ArrayList<Notebook> array = new ArrayList<>();
        String[] vendors = {"Lenuvo", "Asos", "MacNote", "Eser", "Xamiou"};

        fillArray(SIZE, MAX_PRICE, STEP_PRICE, array, vendors);

        Notebook[] newArray = array.toArray(new Notebook[array.size()]);

        CombSort.sortPrice(newArray);
        CombSort.sortMemory(newArray);
        CombSort.sortName(newArray);

        for (Notebook note : newArray) {
            System.out.println(note.getName() + " " + note.getPrice() + " " + note.getMemory());
        }
    }

    private static void fillArray(int SIZE, int maxPrice, int stepPrice, ArrayList<Notebook> array, String[] vendors) {
        Random random = new Random();
        int price;
        int vendor;
        int memory;
        for (int i = 0; i < SIZE; i++) {
            price = random.nextInt((maxPrice) + 1) * stepPrice;
            memory = random.nextInt((6) + 1) * 4;
            vendor = random.nextInt(vendors.length);

            price = price < 500 ? 500 : price;
            memory = memory < 4 ? 4 : memory;
            memory = memory == 20 ? 24 : memory;

            array.add(new Notebook(vendor, vendors[vendor], memory, price));
        }
    }

}
