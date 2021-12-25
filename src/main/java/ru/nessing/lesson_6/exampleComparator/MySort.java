package ru.nessing.lesson_6.exampleComparator;

import java.util.Comparator;

public class MySort implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {

        int p1 = o1.getPrice();
        int p2 = o2.getPrice();
        if (p1 > p2) return 1;
        else if (p1 < p2) return -1;
        else return 0;
    }
}
