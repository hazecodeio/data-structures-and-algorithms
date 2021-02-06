package org.hsmak.datastructures.heap;

import org.junit.Test;

import java.util.Comparator;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class MyHeapTest {


    
    @Test
    public void testMaxHeap(){
        MyHeap<Integer> maxHeap = new MyHeap<>();
        maxHeap.insert(70);
        maxHeap.insert(40);
        maxHeap.insert(50);
        maxHeap.insert(20);
        maxHeap.insert(60);
        maxHeap.insert(100);
        maxHeap.insert(80);
        maxHeap.insert(30);
        maxHeap.insert(10);
        maxHeap.insert(90);

        String collect = maxHeap.data.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);
        assertThat(maxHeap.data.toArray(new Integer[]{})).containsExactly(new Integer[]{100,90,80,30,60,50,70,20,10,40});

        while(!maxHeap.isEmpty()) {
            maxHeap.remove();
            collect = maxHeap.data.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
            System.out.println(collect);
        }
    }

    @Test
    public void testMinHeap(){
        MyHeap<Integer> minHeap = new MyHeap<>(Comparator.<Integer>reverseOrder());

        minHeap.insert(70);
        minHeap.insert(40);
        minHeap.insert(50);
        minHeap.insert(20);
        minHeap.insert(60);
        minHeap.insert(100);
        minHeap.insert(80);
        minHeap.insert(30);
        minHeap.insert(10);
        minHeap.insert(90);

        String collect = minHeap.data.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);
        assertThat(minHeap.data.toArray(new Integer[]{})).containsExactly(new Integer[]{10,20,50,30,60,100,80,70,40,90});

        while(!minHeap.isEmpty()) {
            minHeap.remove();
            collect = minHeap.data.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
            System.out.println(collect);
        }
    }
}