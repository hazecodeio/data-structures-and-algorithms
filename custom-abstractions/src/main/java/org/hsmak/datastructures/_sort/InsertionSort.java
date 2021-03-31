package org.hsmak.datastructures._sort;

/**
 * Observations:
 *      - InsertionSort does not swap values instead it does shifting to the right; it inserts values one by one in a sorted subsequence
 *      - Swapping takes place in Bubble and Selection sorts.
 */
public class InsertionSort {
    public static void main(String[] args) {
        Character[] a = {'C', 'E', 'B', 'D', 'A', 'I', 'J', 'L', 'K', 'H', 'G', 'F'};
        System.out.println(java.util.Arrays.toString(a));
        insertionSort(a);
        System.out.println(java.util.Arrays.toString(a));
    }

    public static <T extends Comparable<T>> void insertionSort(T[] data) {

        int n = data.length;
        for (int k = 1; k < n; k++) {                           // begin with second character
            T cur = data[k];                                    // fetch cur=data[k] since we'll shift to the right
            int j = k;
            while (j > 0 && data[j - 1].compareTo(cur) > 0) {   // keep shifting as long as prev > curr
                data[j] = data[j - 1];                          // shift data to the right
                j--;                                            // and consider previous j for cur
            }
            data[j] = cur;                                      // this is the proper place for cur
        }
    }
}
