package org.hsmak.datastructures.stack;

public interface IStack<E> {
    int size();
    boolean isEmpty();
    void push(E e);
    E top();
    E pop();
}
