import java.util.function.Consumer;

public class AppRunner {
    public static void main(String[] args) {
        System.out.println("running");
    }
}

class BinarySearchTree<E extends Comparable<E>> {

    Node root;

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(1);
        bst.add(10);
        bst.add(5);
        bst.add(8);
        bst.add(2);
        bst.add(20);

        System.out.println("forEachInOrder");
        bst.forEachInOrder(System.out::println);
        System.out.println();
        System.out.println("forEachPostOrder");
        bst.forEachPostOrder(System.out::println);
        System.out.println();
        System.out.println("forEachPreOrder");
        bst.forEachPreOrder(System.out::println);
        System.out.println();


        System.out.println("Deletion:");
        bst.delete(1);
        bst.forEachInOrder(System.out::println);
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