package ru.nessing.lesson_4;

public interface TwoSideLinkedList<E>  extends LinkedList<E> {

    void insertLast(E value);

    E removeLast();

    void displayInversion();

    E getLast();
}