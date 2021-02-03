package org.hsmak.datastructures._sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * MergeSort is analogous to traversing a Binary Tree in PostOrdder
 *
 * @param <K>
 */
public class MergeSort<K extends Comparable<K>> {
    public static void main(String[] args) {
        Integer[] ints = Stream.generate(() -> ThreadLocalRandom.current().nextInt(0, 50)).limit(20).collect(Collectors.toList()).toArray(new Integer[]{});
        System.out.println(Arrays.stream(ints).map(String::valueOf).collect(Collectors.joining(", ", "[", "]")));
        new MergeSort<Integer>().mergeSort(ints);
        System.out.println(Arrays.stream(ints).map(String::valueOf).collect(Collectors.joining(", ", "[", "]")));
    }

    public void mergeSort(K[] s) {
        int n = s.length;
        if (n < 2)
            return;

        int mid = n / 2;
        K[] l = Arrays.copyOfRange(s, 0, mid);
        K[] r = Arrays.copyOfRange(s, mid, n);
        mergeSort(l);
        mergeSort(r);

        merge(l, r, s);
    }

    private void merge(K[] l, K[] r, K[] s) {
        int i = 0, j = 0;
        while (i < l.length && j < r.length) {
            if (l[i].compareTo(r[j]) < 0)
                s[i + j] = l[i++];
            else
                s[i + j] = r[j++];
        }
        while (i < l.length) // move any elements that remain in l
            s[i + j] = l[i++];
        while (j < r.length) // move any elements that remain in r
            s[i + j] = r[j++];
    }
}

class MergeSortWithQueue<K extends Comparable<K>> {
    public static void main(String[] args) {
        LinkedList<Integer> ints = Stream.generate(() -> ThreadLocalRandom.current().nextInt(0, 50)).limit(20).collect(Collectors.toCollection(LinkedList::new));
        System.out.println(ints.stream().map(String::valueOf).collect(Collectors.joining(", ", "[", "]")));
        new MergeSortWithQueue<Integer>().mergeSort(ints);
        System.out.println(ints.stream().map(String::valueOf).collect(Collectors.joining(", ", "[", "]")));
    }

    void mergeSort(Queue<K> s) {
        int n = s.size();
        if (n < 2)
            return;

        int mid = n / 2;

        Queue<K> l = new LinkedList<>();
        Queue<K> r = new LinkedList<>();
        while (l.size() < mid)
            l.add(s.remove());
        while (!s.isEmpty())
            r.add(s.remove());

        mergeSort(l);
        mergeSort(r);

        merge(l, r, s);

    }

    private void merge(Queue<K> l, Queue<K> r, Queue<K> s) {
        while (!l.isEmpty() && !r.isEmpty()) {
            if (l.peek().compareTo(r.peek()) < 0)
                s.add(l.remove());
            else
                s.add(r.remove());
        }

        while (!l.isEmpty()) // move any elements that remain in l
            s.add(l.remove());
        while (!r.isEmpty()) // move any elements that remain in r
            s.add(r.remove());
    }
}