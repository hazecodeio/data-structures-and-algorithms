package org.hsmak.datastructures.linkedlist;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.function.Consumer;

public class SinglyLinkedList<E> {

    private Node head;
    private Node tail;

    private int size;

    public static void main(String[] args) {
        SinglyLinkedList<String> sll = new SinglyLinkedList<>();
        sll.addFirst("A");
        System.out.println(sll.removeLast());
        sll.addFirst("B");
        sll.addFirst("Z");
        sll.addFirst("E");

        System.out.println(sll.get("Z"));
        sll.forEach(System.out::print);
        System.out.println("\n");

        SinglyLinkedList<String> sll2 = new SinglyLinkedList<>();
        sll2.addLast("A");
        sll2.addLast("B");
        sll2.addLast("Z");
        sll2.addLast("E");

        sll2.forEach(System.out::print);
        System.out.println();

        System.out.println(sll2.remove("B"));

        sll2.forEach(System.out::print);
        System.out.println();

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty())
            return null;

        return head.e;
    }

    public void addFirst(E e) {
        Node newNode = new Node(e);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            newNode.next = head;
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
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public E removeFirst() {
        if (head == null)
            return null;

        Node n = head;
        head = head.next;

        if (head == null)//If all there was is one element
            tail = null;

        size--;

        return n.e;
    }

    /**
     * inefficient because we have to traverse the whole list in order to get hold of the element before the last
     *
     * @return
     */
    public E removeLast() {
        if (head == null)
            return null;

        if (head.next == null) { //If all there is one element
            E e = head.e;
            head = null;
            tail = null;
            size--;
            return e;

        }

        Node tempN = head;
        while (tempN.next.next != null) {
            tempN = tempN.next;
        }

        E e = tail.e;
        tail = tempN;

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

    public E remove(E e) {
        if (head == null)
            return null;

        for (Node n = head; n != null; n = n.next) {
            if (n.e.equals(e) && n == head) {//if matches head
                return removeFirst();//it will decrement size
            } else {
                Node peekedN = peek(n);
                if (peekedN == null)//not match
                    return null;
                else if (peekedN.e.equals(e)) {
                    if (n.next == tail) {// if matches tail
                        E tempE = tail.e;
                        tail = n;
                        size--;
                        return tempE;
                    } else {//if in the middle
                        size--;
                        n.next = n.next.next;
                        return peekedN.e;
                    }
                }

            }
        }
        return null;
    }

    private Node peek(Node n) {
        if (n == null)
            return null;

        return n.next;
    }

    public int size() {
        return size;
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
        E e;
        Node next;

        Node(E e) {// always specify what NextNode will be for this Node
            this.e = e;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("e", e)
//                    .append("next", next)
                    .toString();
        }
    }
}


