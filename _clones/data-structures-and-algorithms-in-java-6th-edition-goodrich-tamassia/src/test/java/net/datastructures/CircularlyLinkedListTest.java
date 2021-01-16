package net.datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class CircularlyLinkedListTest {
    CircularlyLinkedList<Integer> circularlyLinkedList = new CircularlyLinkedList<>();

    @Test
    public void testAddFirst(){
        circularlyLinkedList.addFirst(1);
        circularlyLinkedList.addFirst(2);
        circularlyLinkedList.addFirst(3);
        circularlyLinkedList.addFirst(4);

        System.out.println(circularlyLinkedList);
        circularlyLinkedList.rotate();
        System.out.println(circularlyLinkedList);
    }

}