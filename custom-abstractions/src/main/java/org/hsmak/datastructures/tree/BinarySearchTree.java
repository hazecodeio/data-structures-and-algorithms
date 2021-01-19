package org.hsmak.datastructures.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class BinarySearchTree<E extends Comparable<E>> {

    Node root;

    public BinarySearchTree() {
    }

    public BinarySearchTree(E... es ) {
        for(E e : es)
            add(e);
    }

    /* *************************
     * ******** Addition *******
     * *************************/

    void add(E value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, E value) {
        if (current == null)
            return new Node(null, value, null);

        if (value.compareTo(current.value) < 0)
            current.left = addRecursive(current.left, value);
        else if (value.compareTo(current.value) > 0)
            current.right = addRecursive(current.right, value);
        else
            return current;

        return current;
    }

    /* ************************
     * ******* Deletion *******
     * ************************/

    public void delete(E value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, E value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Case 1: no children
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: only 1 child
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }

            // Case 3: 2 children
            E smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value.compareTo(current.value) < 0) {
            current.left = deleteRecursive(current.left, value);
            return current;
        } else {
            current.right = deleteRecursive(current.right, value);
            return current;
        }
    }

    private E findSmallestValue(Node current) {
        return current.left == null ? current.value : findSmallestValue(current.left);
    }


    /* *****************************
     * ********* Traversal *********
     * *****************************/

    public void traverseInOrder(Node node, Consumer<E> c) {
        if (node != null) {
            traverseInOrder(node.left, c);
            c.accept(node.value);
            traverseInOrder(node.right, c);
        }
    }

    public void traversePreOrder(Node node, Consumer<E> c) {
        if (node != null) {
            c.accept(node.value);
            traversePreOrder(node.left, c);
            traversePreOrder(node.right, c);
        }
    }

    public void traversePostOrder(Node node, Consumer<E> c) {
        if (node != null) {
            traversePostOrder(node.left, c);
            traversePostOrder(node.right, c);
            c.accept(node.value);
        }
    }

    public void forEachInOrder(Consumer<E> c) {
        traverseInOrder(root, c);
    }

    public void forEachPostOrder(Consumer<E> c) {
        traversePostOrder(root, c);
    }

    public void forEachPreOrder(Consumer<E> c) {
        traversePreOrder(root, c);
    }

    public List<E> asListInOrder(){
        List<E> l = new ArrayList<>();
        forEachInOrder(l::add);
        return l;
    }
    public List<E> asListPostOrder(){
        List<E> l = new ArrayList<>();
        forEachPostOrder(l::add);
        return l;
    }
    public List<E> asListPreOrder(){
        List<E> l = new ArrayList<>();
        forEachPreOrder(l::add);
        return l;
    }

    class Node {
        E value;
        Node left;
        Node right;

        public Node() {
        }

        public Node(Node left, E value, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}