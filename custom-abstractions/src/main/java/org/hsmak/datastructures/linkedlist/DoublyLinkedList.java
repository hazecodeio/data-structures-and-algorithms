package org.hsmak.datastructures.linkedlist;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.lang.reflect.Array;
import java.util.function.Consumer;

public class DoublyLinkedList<E> {

    private Node head;
    private Node tail;

    private int size;

    public static void main(String[] args) {
        DoublyLinkedList<String> dll = new DoublyLinkedList<>();
        dll.addLast("A");
        dll.addLast("B");
        dll.addLast("Z");
        dll.addLast("E");

        dll.forEach(System.out::print);
        System.out.println();
        System.out.println(dll.remove("E"));
//        System.out.println(dll.removeFirst());
//        System.out.println(dll.removeLast());
        dll.forEach(System.out::print);

    }

    public void addFirst(E e) {
        Node newNode = new Node(e);
        if (head == null) {
            head = newNode;//next = null & prev = null
            tail = head;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(E e) {
        Node newNode = new Node(e);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public E removeFirst() {
        if (head == null)
            return null;

        E e = head.e;
        if (head == tail) { // There is only one element
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return e;
    }

    /**
     * More efficient than SinglyLinkedList
     *
     * @return
     */
    public E removeLast() {
        if (head == null)
            return null;

        E e = tail.e;

        if (head == tail) { // There is only one element
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;
        return e;
    }

    public E get(E e) {

        for (Node n = head; n != null; n = n.next) {
            if (n.e.equals(e))
                return n.e;
        }
        return null;//In FP this should be Option[Nothing]
    }

    /**
     *
     * @param e
     * @return
     */
    public E remove(E e) {
        if (head == null)
            return null;

        for (Node n = head; n != null; n = n.next) {
            if (n.e.equals(e)) {
                if (n == head) { // removeFirst()
                    head = head.next;
                    head.prev = null;

                    size--;

                    return n.e;
                } else if (n == tail) { // removeLast()
                    tail = tail.prev;
                    tail.next = null;

                    size--;

                    return n.e;
                } else { // case; in the middle
                    n.next.prev = n.prev;
                    n.prev.next = n.next;
                    n.next = null;
                    n.prev = null;

                    size--;

                    return n.e;
                }

            }
        }
        return null;
    }

    public E remove2(E e) {
        if (head == null)
            return null;

        if (head.e.equals(e))
            return removeFirst();

        if (tail.e.equals(e))
            return removeLast();

        for (Node n = head; n != null; n = n.next) {
            if (n.e.equals(e)) {
                E elem = n.e;
                Node prv = n.prev;
                Node nxt = n.next;

                prv.next = n.next;
                nxt.prev = n.prev;

                n.next = null;
                n.prev = null;

                size--;

                return elem;
            }
        }
        return null;
    }

    /**
     * Note that we're not moving the elements themselves, rather,
     * we're just changing the references such that `next` is `prev` and vice versa
     */
    public void reverse() {
        Node current = head;
        head = tail;
        tail = current;
        while (current != null) {
            Node next = current.next;
            Node prev = current.prev;
            current.next = prev;
            current.prev = next;
            current = next;
        }
    }

    public <T> T[] asArray(Class<T> clazz) {
        T[] llAsArray = (T[]) Array.newInstance(clazz, size);

        Node node = this.head;
        for (int i = 0; node != null; node = node.next)
            llAsArray[i++] = (T) node.e;

        return llAsArray;
    }

    public void forEach(Consumer<E> c) {
        if (head == null)
            return;

        for (Node n = head; n != null; n = n.next) {
            c.accept(n.e);
        }

    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("head", head.e)
                .append("tail", tail.e)
                .append("size", size)
                .toString();
    }

    class Node {
        Node prev;
        E e;
        Node next;

        public Node() {
        }

        public Node(E e) {// always specify what NextNode will be for this Node
            this.e = e;
        }

        public Node(Node prev, E e, Node next) {
            this.prev = prev;
            this.e = e;
            this.next = next;
        }
    }
}