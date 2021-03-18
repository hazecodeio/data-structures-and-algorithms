package org.hsmak.datastructures.stack;

import java.util.Arrays;

public class StackOps {
    public static void main(String... args) {

        System.out.println(Arrays.toString(reverse(new String[]{"A", "B", "C"})));
    }

    /**
     * Mutating the same array
     *
     * @param data
     * @param <E>
     * @return
     */
    public static <E> E[] reverse(E[] data) {
        ArrayStack<E> jas = new ArrayStack<>(data.length);
        for (E e : data) {
            jas.push(e);
        }
        for (int i = 0; i < data.length; i++) {
            data[i] = jas.pop();
        }
        return data;
    }
}
