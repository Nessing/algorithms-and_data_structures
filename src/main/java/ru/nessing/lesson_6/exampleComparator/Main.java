package ru.nessing.lesson_6.exampleComparator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Product productOne = new Product("Milk", 32);
        Product productTwo = new Product("Aea", 22);

        Product[] products = {productOne, productTwo};

        for (Product product : products) {
            System.out.println(product.toString());
        }
        Arrays.sort(products, new MySort());
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }
}
