package org.hsmak.datastructures.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyHeap<E extends Comparable<E>> {
    List<E> data = new ArrayList<>();
    Comparator<E> comp;

    public MyHeap() {
        comp = new DefaultComparator();
    }

    public MyHeap(Comparator<E> comp) {
        this.comp = comp;
    }

    void insert(E e) {
        data.add(e);
        int bottomIndex = data.size() - 1;
        trickleUp(bottomIndex);
    }

    boolean isEmpty() {
        return data.isEmpty();
    }

    boolean isRoot(int index) {
        return index == 0;
    }

    boolean isValidIndex(int index) {
        return index < data.size();
    }

    int leftIndex(int index) {
        return 2 * index + 1;
    }

    int rightIndex(int index) {
        return 2 * index + 2;
    }

    int parentIndex(int index) {
        return (index - 1) / 2;
    }

    void trickleUp(int bottomIndex) {
        int parentIndex = parentIndex(bottomIndex);
        E bottomElement = data.get(bottomIndex);

        while (bottomIndex > 0 && comp.compare(data.get(parentIndex),bottomElement) < 0) {

            data.set(bottomIndex, data.get(parentIndex));  // move it down

            bottomIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        data.set(bottomIndex, bottomElement);
    }

    public E remove() {
        if(data.size() == 1)
            return data.remove(0);

        E root = data.get(0);
        E bottomElement = data.remove(data.size() - 1);
        data.set(0, bottomElement);

        trickleDown(0);

        return root;
    }

    public void trickleDown(int index) {
        int largerChild;
        E top = data.get(index);

        while (index < data.size() / 2) {
            int leftChild = leftIndex(index);
            int rightChild = rightIndex(index);

            // find larger child
            if (rightChild < data.size() && comp.compare(data.get(leftChild),data.get(rightChild)) < 0)
                largerChild = rightChild;
            else
                largerChild = leftChild;

            // top >= largerChild?
            if (comp.compare(top,data.get(largerChild)) >= 0)
                break;

            // shift child up
            data.set(index, data.get(largerChild));
            index = largerChild;            // go down
        }
        data.set(index, top);            // root to index
    }

    class DefaultComparator implements Comparator<E> {
        @Override
        public int compare(E o1, E o2) {
            return o1.compareTo(o2);
        }
    }
}

