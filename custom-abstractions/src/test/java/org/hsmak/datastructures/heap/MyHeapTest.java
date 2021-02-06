package org.hsmak.datastructures.heap;

import org.junit.Test;

import java.util.Comparator;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class MyHeapTest {


    
    @Test
    public void testMaxHeap(){
        MyHeap<Integer> heap = new MyHeap<>();
        heap.insert(70);
        heap.insert(40);
        heap.insert(50);
        heap.insert(20);
        heap.insert(60);
        heap.insert(100);
        heap.insert(80);
        heap.insert(30);
        heap.insert(10);
        heap.insert(90);

        String collect = heap.data.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);
        assertThat(heap.data.toArray(new Integer[]{})).containsExactly(new Integer[]{100,90,80,30,60,50,70,20,10,40});

        heap.remove();
        collect = heap.data.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);

        heap.remove();
        collect = heap.data.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);

        heap.remove();
        collect = heap.data.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);

        heap.remove();
        collect = heap.data.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);

        heap.remove();
        collect = heap.data.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);

        heap.remove();
        collect = heap.data.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);

        heap.remove();
        collect = heap.data.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);

        heap.remove();
        collect = heap.data.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);

        heap.remove();
        collect = heap.data.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);

        heap.remove();
        collect = heap.data.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);

    }

    @Test
    public void testMinHeap(){
        MyHeap<Integer> heap = new MyHeap<>(Comparator.<Integer>reverseOrder());

        heap.insert(70);
        heap.insert(40);
        heap.insert(50);
        heap.insert(20);
        heap.insert(60);
        heap.insert(100);
        heap.insert(80);
        heap.insert(30);
        heap.insert(10);
        heap.insert(90);

        String collect = heap.data.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);
        assertThat(heap.data.toArray(new Integer[]{})).containsExactly(new Integer[]{10,20,50,30,60,100,80,70,40,90});

        heap.remove();
        collect = heap.data.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);

        heap.remove();
        collect = heap.data.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);

        heap.remove();
        collect = heap.data.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);

        heap.remove();
        collect = heap.data.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);

        heap.remove();
        collect = heap.data.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);

        heap.remove();
        collect = heap.data.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);

        heap.remove();
        collect = heap.data.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);

        heap.remove();
        collect = heap.data.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);

        heap.remove();
        collect = heap.data.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);

        heap.remove();
        collect = heap.data.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);
    }

}