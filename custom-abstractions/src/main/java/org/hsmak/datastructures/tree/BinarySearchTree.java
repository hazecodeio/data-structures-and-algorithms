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
            E minValueOfRightSubtree = findMinNode(current.right).value;
            current.value = minValueOfRightSubtree;
            current.right = deleteRecursive(current.right, minValueOfRightSubtree);

            /*
             * Alternatively, replacing with the max of the left subtree would work as well. However,
             * PreOrder & PostOrder traversal will differ (as expected), and InOrder would be the same.
             */
            /*E maxValueOfLeftSubtree = findMaxNode(current.left).value;
            current.value = maxValueOfLeftSubtree;
            current.left = deleteRecursive(current.left, maxValueOfLeftSubtree);*/
        }
        return current;
    }

    private Node findMinNode(Node subtree) {
        if (subtree == null)
            return null;
        return subtree.left == null ? subtree : findMinNode(subtree.left);
    }

    private Node findMaxNode(Node subtree) {
        if (subtree == null)
            return null;
        return subtree.right == null ? subtree : findMaxNode(subtree.right);
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

    // ToDo - revisit since this might be flatten into a SinglyLinkedList
    public void toSinglyLinkedListIter() {
        helpFlattenIter(root);
    }

    // ToDo - revisit since this might be flatten into a SinglyLinkedList
    public void helpFlattenIter(Node root) {

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

    public void toDoublyLinkedListInOrder() {
        toDLLInOrderHelper(root, new BinarySearchTree<E>(), new BinarySearchTree<E>());
    }

    private void toDLLInOrderHelper(Node current, BinarySearchTree<E> head, BinarySearchTree<E> prv) {
        if (current == null)
            return;


        BinarySearchTree<E> left = new BinarySearchTree<>();
        left.root = current.left;
        current.left = null;
        BinarySearchTree<E> right = new BinarySearchTree<>();
        right.root = current.right;
        current.right = null;

        toDLLInOrderHelper(left.root, head, prv);

        if (head.root == null) {
            head.root = current;
        } else {
            current.left = prv.root;
            prv.root.right = current;
        }

        prv.root = current;

        toDLLInOrderHelper(right.root, head, prv);
    }

    public void toDoublyLinkedListInOrderReversed() {
        toDLLInOrderReversedHelper(root, new BinarySearchTree<E>(), new BinarySearchTree<E>());
    }

    private void toDLLInOrderReversedHelper(Node current, BinarySearchTree<E> head, BinarySearchTree<E> prv) {
        if (current == null)
            return;

        BinarySearchTree<E> right = new BinarySearchTree<>();
        right.root = current.right;
        current.right = null;

        BinarySearchTree<E> left = new BinarySearchTree<>();
        left.root = current.left;
        current.left = null;

        toDLLInOrderReversedHelper(right.root, head, prv);

        if (head.root == null) {
            head.root = current;
        } else {
            current.left = prv.root;
            prv.root.right = current;
        }

        prv.root = current;

        toDLLInOrderReversedHelper(left.root, head, prv);
    }

    public void toDoublyLinkedListPreOrder() {
        toDLLPreOrderHelper(root, new BinarySearchTree<E>(), new BinarySearchTree<E>());
    }

    private void toDLLPreOrderHelper(Node current, BinarySearchTree<E> head, BinarySearchTree<E> prv) {
        if (current == null)
            return;


        BinarySearchTree<E> left = new BinarySearchTree<>();
        left.root = current.left;
        current.left = null;
        BinarySearchTree<E> right = new BinarySearchTree<>();
        right.root = current.right;
        current.right = null;

        if (head.root == null) {
            head.root = current;
        } else {
            current.left = prv.root;
            prv.root.right = current;
        }

        prv.root = current;

        toDLLPreOrderHelper(left.root, head, prv);
        toDLLPreOrderHelper(right.root, head, prv);
    }

    public void toDoublyLinkedListPostOrder() {
        toDLLPostOrderHelper(root, new BinarySearchTree<E>(), new BinarySearchTree<E>());
    }

    private void toDLLPostOrderHelper(Node current, BinarySearchTree<E> head, BinarySearchTree<E> prv) {
        if (current == null)
            return;

        BinarySearchTree<E> left = new BinarySearchTree<>();
        left.root = current.left;
        current.left = null;
        BinarySearchTree<E> right = new BinarySearchTree<>();
        right.root = current.right;
        current.right = null;

        toDLLPostOrderHelper(left.root, head, prv);
        toDLLPostOrderHelper(right.root, head, prv);

        if (head.root == null) {
            head.root = current;
        } else {
            current.left = prv.root;
            prv.root.right = current;
        }

        prv.root = current;
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

    List<E> rightSubtreesAsList() {
        List<E> l = new ArrayList<>();

        for (Node head = root; head != null; head = head.right)
            l.add(head.value);

        return l;
    }

    List<E> leftSubtreesAsList() {
        List<E> l = new ArrayList<>();

        for (Node head = root; head != null; head = head.left)
            l.add(head.value);

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

        public Node(E value) {
            this.value = value;
        }
    }
}