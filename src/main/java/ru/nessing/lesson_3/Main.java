package ru.nessing.lesson_3;

import ru.nessing.lesson_3.first.BinarySearch;
import ru.nessing.lesson_3.second.Deque;
import ru.nessing.lesson_3.second.DequeImpl;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16};
        int[] arr2 = {1, 2, 4, 5, 6};
        int[] arr3 = {};

        System.out.println(BinarySearch.binarySearchMissedElement(arr));
        System.out.println(BinarySearch.binarySearchMissedElement(arr2));
        System.out.println(BinarySearch.binarySearchMissedElement(arr3));


        Deque<Integer> queue = new DequeImpl<>(5);

        System.out.println("add element to left: " + queue.insertLeft(34));
        System.out.println("add element to left: " + queue.insertLeft(12));
        System.out.println("add element to left: " + queue.insertLeft(20));
        System.out.println("add element to left: " + queue.insertLeft(16));
        System.out.println("add element to left: " + queue.insertLeft(14));
        System.out.println("add element to left: " + queue.insertLeft(17));

        queue.display();
        System.out.println("remove left: " + queue.removeLeft());
        queue.display();

        System.out.println("remove right: " + queue.removeRight());
//        System.out.println("add element to right: " + queue.insertRight(22));
        queue.display();


//        BinarySearch.binarySearch(arr, 6);
//        BinarySearch.interpolationSearch(arr, 6);
    }
}
