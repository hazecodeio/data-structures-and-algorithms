package org.hsmak.datastructures.tree;

import java.util.*;
import java.util.function.Consumer;

class BinarySearchTree<E extends Comparable<E>> {

    Node root;

    public BinarySearchTree() {
    }

    public BinarySearchTree(E... es) {
        for (E e : es)
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

        if (value.compareTo(current.value) < 0)
            current.left = deleteRecursive(current.left, value);
        else if (value.compareTo(current.value) > 0)
            current.right = deleteRecursive(current.right, value);
        else { // value.compareTo(current.value) == 0
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
        }
        return current;
    }

    private E findSmallestValue(Node current) {
        return current.left == null ? current.value : findSmallestValue(current.left);
    }


    /* *****************************
     * ********* Traversal *********
     * *****************************/

    // Breadth First Traversal

    public void traverseBreadthFirst(Node root, Consumer<E> c) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.addFirst(root);

        while (!queue.isEmpty()) {
            Node n = queue.removeLast();
            c.accept(n.value);

            if (n.left != null)
                queue.addFirst(n.left);
            if (n.right != null)
                queue.addFirst(n.right);
        }
    }

    public void forEachBreadthFirst(Consumer<E> c) {
        traverseBreadthFirst(root, c);
    }

    public List<E> asListBreadthFirst() {
        List<E> l = new ArrayList<>();
        forEachBreadthFirst(l::add);
        return l;
    }
    //////////////////////

    // First Depth Traversal - Recursive

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

    public List<E> asListInOrder() {
        List<E> l = new ArrayList<>();
        forEachInOrder(l::add);
        return l;
    }

    public List<E> asListPostOrder() {
        List<E> l = new ArrayList<>();
        forEachPostOrder(l::add);
        return l;
    }

    public List<E> asListPreOrder() {
        List<E> l = new ArrayList<>();
        forEachPreOrder(l::add);
        return l;
    }

    ///////////////////////////

    // First Depth Traversal - Iterative

    public void traverseInOrderIterative(Consumer<E> c) {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        stack.push(root);
        while (!stack.isEmpty()) {
            while (current.left != null) {
                current = current.left;
                stack.push(current);
            }
            current = stack.pop();
            c.accept(current.value);
            if (current.right != null) {
                current = current.right;
                stack.push(current);
            }
        }
    }

    public void traversePreOrderIterative(Consumer<E> c) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            c.accept(current.value);

            if (current.right != null)
                stack.push(current.right);

            if (current.left != null)
                stack.push(current.left);
        }
    }

    public void traversePostOrderIterative(Consumer<E> c) {
        Stack<Node> stack = new Stack<>();
        Node prev = root;
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.peek();
            boolean hasChild = (current.left != null || current.right != null);
            boolean isPrevLastChild = (prev == current.right || (prev == current.left && current.right == null));

            if (!hasChild || isPrevLastChild) {
                current = stack.pop();
                c.accept(current.value);
                prev = current;
            } else {
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
            }
        }
    }

    public List<E> asListInOrderItr() {
        List<E> l = new ArrayList<>();
        traverseInOrderIterative(l::add);
        return l;
    }

    public List<E> asListPostOrderItr() {
        List<E> l = new ArrayList<>();
        traversePostOrderIterative(l::add);
        return l;
    }

    public List<E> asListPreOrderItr() {
        List<E> l = new ArrayList<>();
        traversePreOrderIterative(l::add);
        return l;
    }

    ////////////////////////
    // Iterator

    public Iterator<E> inOrderIterator() {

        return new InOrderIterator(root);
    }

    public List<E> asListInOrderViaIterator() {
        List<E> l = new ArrayList<>();
        InOrderIterator it = new InOrderIterator(root);
        while (it.hasNext())
            l.add(it.next());
        return l;
    }

    class InOrderIterator implements Iterator<E> {
        Stack<Node> stack;
        Node current;

        public InOrderIterator(Node current) {
            this.current = current;
            this.stack = new Stack<>();
            stack.push(current);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public E next() {
            while (current.left != null) {
                current = current.left;
                stack.push(current);
            }

            current = stack.pop();
            E val = current.value;

            if (current.right != null) {
                current = current.right;
                stack.push(current);
            }
            return val;
        }
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