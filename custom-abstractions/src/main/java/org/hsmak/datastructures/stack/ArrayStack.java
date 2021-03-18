package org.hsmak.datastructures.stack;

public class ArrayStack<E> implements IStack<E> {

    public static final int capacity = 1000;
    private E[] data;
    private int t = -1;

    public ArrayStack() {
        this(capacity);
    }

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];//ToDo - notice the downcast
    }

    public static void main(String... args) {
        ArrayStack<String> as = new ArrayStack<>();
        as.push("A");
        as.push("B");
        as.push("C");
        System.out.println(as.size());
        System.out.println(as.top());
        System.out.println(as.pop());
        System.out.println(as.size());
    }

    @Override
    public int size() {
        return t + 1;
    }

    @Override
    public boolean isEmpty() {
        return t == -1;
    }

    @Override
    public void push(E e) {
        if (size() == data.length)
            throw new IllegalStateException("Stack is full");

        data[++t] = e;
    }

    @Override
    public E top() {
        if (isEmpty())
            return null;

        return data[t];
    }

    @Override
    public E pop() {
        if (isEmpty())
            return null;

        E elem = data[t];
        data[t--] = null;// deference to help garbage collection, then decrement t

        return elem;
    }

}
