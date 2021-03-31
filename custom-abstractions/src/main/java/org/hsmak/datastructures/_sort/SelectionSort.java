package org.hsmak.datastructures._sort;

public class SelectionSort {

    public static <T extends Comparable<T>> void selectionSort(T[] data) {
        int n = data.length;

        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++)
                if (data[j].compareTo(data[min]) < 0)
                    min = j;
            swap(data, i, min);
        }
    }


    private static <T extends Comparable<T>> void swap(T[] data, int i, int j) {
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        Character[] a = {'C', 'E', 'B', 'D', 'A', 'I', 'J', 'L', 'K', 'H', 'G', 'F'};
        System.out.println(java.util.Arrays.toString(a));
        selectionSort(a);
        System.out.println(java.util.Arrays.toString(a));
    }  // end main()

}