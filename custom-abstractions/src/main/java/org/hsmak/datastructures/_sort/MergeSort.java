package org.hsmak.datastructures._sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * MergeSort is analogous to traversing a Binary Tree in PostOrdder
 * @param <K>
 */
public class MergeSort<K extends Comparable<K>> {
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
        while(i < l.length) // in case there are any element left in l
            s[i + j] = l[i++];
        while(j < r.length) // in case there are any element left in r
            s[i + j] = r[j++];

    }

    public static void main(String[] args) {
        Integer[] ints = Stream.generate(() -> ThreadLocalRandom.current().nextInt(0, 50)).limit(20).collect(Collectors.toList()).toArray(new Integer[]{});
        System.out.println(Arrays.stream(ints).map(String::valueOf).collect(Collectors.joining(", ","[","]")));
        new MergeSort<Integer>().mergeSort(ints);
        System.out.println(Arrays.stream(ints).map(String::valueOf).collect(Collectors.joining(", ","[","]")));
    }
}
