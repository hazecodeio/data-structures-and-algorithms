package org.hsmak.datastructures.stack;

import org.hsmak.datastructures.linkedlist.SinglyLinkedList;

/**
 * Adapter Pattern
 *
 * @param <E>
 */
public class LinkedStack<E> implements IStack<E> {

    private SinglyLinkedList<E> data = new SinglyLinkedList<>();

    public static void main(String... args) {
        LinkedStack<String> ls = new LinkedStack<>();
        ls.push("A");
        ls.push("B");
        ls.push("C");
        System.out.println(ls.pop());

    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void push(E e) {
        data.addFirst(e);

    }

    @Override
    public E top() {
        return data.first();
    }

    @Override
    public E pop() {
        return data.removeFirst();
    }
}
