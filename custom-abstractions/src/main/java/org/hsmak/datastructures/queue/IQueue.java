package org.hsmak.datastructures.queue;

public interface IQueue<E> {
    int size();
    boolean isEmpty();
    E first();
    void enqueue(E e);
    E dequeue();
}
