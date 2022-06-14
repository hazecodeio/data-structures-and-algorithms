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
            E minValueOfRightSubtree = findMin(current.right);
            current.value = minValueOfRightSubtree;
            current.right = deleteRecursive(current.right, minValueOfRightSubtree);

            /*
             * Alternatively, replacing with the max of the left subtree would work as well. However,
             * PreOrder & PostOrder traversal will differ (as expected), and InOrder would be the same.
             */
            /*E maxValueOfLeftSubtree = findMax(current.left);
            current.value = maxValueOfLeftSubtree;
            current.left = deleteRecursive(current.left, maxValueOfLeftSubtree);*/
        }
        return current;
    }

    private E findMin(Node current) {
        return current.left == null ? current.value : findMin(current.left);
    }

    private E findMax(Node node) {
        return node.right == null ? node.value : findMin(node.right);
    }

    public int height() {
        return heightRecursive(root);
    }

    private int heightRecursive(Node current) {
        if (current == null)
            return -1;

        int left = 1 + heightRecursive(current.left);
        int right = 1 + heightRecursive(current.right);

        return Integer.max(left, right);
    }

    /* ***********************************************
     * ********* Convert to DoublyLinkedList *********
     * ***********************************************/

    public void flattenToDoublyLinkedList() {
        helpFlatten(root);
    }

    private void helpFlatten(Node current) {
        if (current == null) {
            return;
        }
        helpFlatten(current.left);
        helpFlatten(current.right);
        //checking if root's left child exist. if does not exist we will move forward without any changes.

        if (current.left != null) {
            //if right child does not exist we will simply change left child to right child
            if (current.right == null) {
                current.right = current.left;
                current.left = null;
                return;
            }
            //if exist we will traverse to the end of the left child linkedlist and connect it to the right child linkedlist
            Node temp = current.left;
            while (temp.right != null) {
                temp = temp.right;
            }
            temp.right = current.right;
            current.right = current.left;
            current.left = null;
        }
    }

    public List<E> asListDLL() {
        List<E> l = new ArrayList<>();

        for (Node head = root; head != null; head = head.right)
            l.add(head.value);

        return l;
    }

    public void flatten2(Node root) {

        if (root == null)
            return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node current = root, prev = null;

        while (!stack.isEmpty()) {

            current = stack.pop();
            if (prev != null)
                prev.right = current;

            if (current.right != null)
                stack.push(current.right);
            if (current.left != null)
                stack.push(current.left);

            current.left = null;
            prev = current;
        }
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


    public void traverseBreadthFirstByLevelIter(Node root, Consumer<E> c) {
        LinkedList<Node> levelQ = new LinkedList<>();
        LinkedList<Node> childrenQ = new LinkedList<>();
        levelQ.addFirst(root);

        while (!levelQ.isEmpty()) {
            while (!levelQ.isEmpty()) {
                Node n = levelQ.removeLast();
                c.accept(n.value);

                if (n.left != null)
                    childrenQ.addFirst(n.left);
                if (n.right != null)
                    childrenQ.addFirst(n.right);
            }
            while (!childrenQ.isEmpty()) {
                levelQ.addFirst(childrenQ.removeLast());
            }
        }
    }

    void traverseBreadthFirstByLevelRec(Node root, Consumer<E> c) {
        LinkedList<Node> currentLevelQ = new LinkedList<>();
        currentLevelQ.addFirst(root);
        breadthFirstByLevelRecHelper(currentLevelQ, c);
    }

    private void breadthFirstByLevelRecHelper(LinkedList<Node> currentLevelQ, Consumer<E> c) {
        if (currentLevelQ.isEmpty())
            return;

        LinkedList<Node> nextLevelQ = new LinkedList<>();

        while (!currentLevelQ.isEmpty()) {
            Node n = currentLevelQ.removeLast();
            c.accept(n.value);
            if (n.left != null)
                nextLevelQ.addFirst(n.left);
            if (n.right != null)
                nextLevelQ.addFirst(n.right);
        }
        breadthFirstByLevelRecHelper(nextLevelQ, c);
    }


    public void forEachBreadthFirst(Consumer<E> c) {
        traverseBreadthFirst(root, c);
    }

    public List<E> asListBreadthFirst() {
        List<E> l = new ArrayList<>();
        forEachBreadthFirst(l::add);
        return l;
    }

    public List<E> asListBreadthFirstByLevelIter() {
        List<E> l = new ArrayList<>();
        traverseBreadthFirstByLevelIter(root, l::add);
        return l;
    }

    public List<E> asListBreadthFirstByLevelRec() {
        List<E> l = new ArrayList<>();
        traverseBreadthFirstByLevelRec(root, l::add);
        return l;
    }
    //////////////////////

    // First Depth Traversal - Recursive

    public void traverseInOrder(Node node, Consumer<E> c) {
        if (node == null)
            return;

        traverseInOrder(node.left, c);
        c.accept(node.value);
        traverseInOrder(node.right, c);
    }

    public void traversePreOrder(Node node, Consumer<E> c) {
        if (node == null)
            return;

        c.accept(node.value);
        traversePreOrder(node.left, c);
        traversePreOrder(node.right, c);
    }

    public void traversePostOrder(Node node, Consumer<E> c) {
        if (node == null)
            return;

        traversePostOrder(node.left, c);
        traversePostOrder(node.right, c);
        c.accept(node.value);
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

    /////
    public Iterator<E> iterator() {
        return new PreOrderIterator(root);
    }

    public List<E> asListPreOrderViaIterator() {
        List<E> l = new ArrayList<>();
        PreOrderIterator it = new PreOrderIterator(root);
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

    class PreOrderIterator implements Iterator<E> {
        Stack<Node> stack;
        Node current;

        PreOrderIterator(Node current) {
            this.current = current;
            stack = new Stack<>();
            stack.push(current);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public E next() {
            Node current = stack.pop();
            E val = current.value;
            if (current.right != null)
                stack.push(current.right);
            if (current.left != null)
                stack.push(current.left);

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

        public Node(E value) {
            this.value = value;
        }
    }
}