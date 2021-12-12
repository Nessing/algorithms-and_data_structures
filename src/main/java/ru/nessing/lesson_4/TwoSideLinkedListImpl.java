package ru.nessing.lesson_4;

import java.util.NoSuchElementException;

public class TwoSideLinkedListImpl<E> extends SimpleLinkedListImpl<E> implements TwoSideLinkedList<E> {

    protected Node<E> last;

    @Override
    public void insertFirst(E value) {
        Node<E> first = this.first;
        Node<E> newNode = new Node<>(value, first, null);
        this.first = newNode;
        if (first == null)
            last = newNode;
        else
            first.prev = newNode;
        size++;

        if (size == 1) {
            last = this.first;
        }
    }

    @Override
    public void insertLast(E value) {
        if (isEmpty()) {
            insertFirst(value);
            return;
        }

        Node<E> newNode = new Node<>(value, null);

        last.next = newNode;
//        last = last.next;
        last = newNode;
        size++;
    }

    @Override
    public E removeFirst() {
        E removedValue = super.removeFirst();

        if (isEmpty()) {
            last = null;
        }

        return removedValue;
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removeNode = last;
        size--;

        if (removeNode == null)
            throw new NoSuchElementException();
        Node<E> prev = removeNode.prev;
        removeNode.prev = null; // help GC
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        return removeNode.item;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = first;
        Node<E> prev = null;

        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        } else if (current == first) {
            removeFirst();
            return true;
        } else if (current == last) {
            last = prev;
            last.next = null;
        }

        prev.next = current.next;
        current.next = null;
        size--;

        return true;
    }

    @Override
    public E getFirst() {
        return first.item;
    }

    @Override
    public E getLast() {
        return last.item;
    }

    public void displayInversion() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = last;
        while (current != null) {
            sb.append(current.item);
            if (current.prev != null) {
                sb.append(" -> ");
            }
            current = current.prev;
        }
        sb.append("]");

        System.out.println(sb);
    }
}
