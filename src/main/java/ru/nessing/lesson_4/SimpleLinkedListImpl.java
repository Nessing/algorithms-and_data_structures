package ru.nessing.lesson_4;


import java.util.Iterator;

public class SimpleLinkedListImpl<E> implements LinkedList<E>, Iterable<E> {

    protected Node<E> first;
    protected Node<E> last;
    protected int size;

    @Override
    public void insertFirst(E value) {
        first = new Node<>(value, first);
        if (first == null)
            last = first;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removeNode = first;
        first = removeNode.next;
        removeNode.next = null;
        size--;
        return removeNode.item;
    }

    @Override
    public E getFirst() {
        return first.item;
    }

    public E getLast() {
        return last.item;
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
        }

        prev.next = current.next;
        current.next = null;
        size--;

        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = first;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = first;
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.append("]").toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {

        Node<E> temp = first;

        @Override
        public boolean hasNext() {
            return temp != null;
        }

        @Override
        public E next() {
            Node<E> current = temp;
            if (hasNext()) {
                temp = temp.next;
                return current.item;
            }
            return null;
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }

        public void reset() {

        }
    }
}
