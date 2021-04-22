package org.hsmak.datastructures.tree;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.stream.Collectors;

public class BinarySearchTreeTest {

    BinarySearchTree<Integer>  bst;

    public BinarySearchTreeTest() {
        bst = new BinarySearchTree<>();
        bst.add(6);
        bst.add(4);
        bst.add(8);
        bst.add(3);
        bst.add(5);
        bst.add(7);
        bst.add(9);
    }

    @Test
    public void testInOrderTraversal(){
        System.out.println(bst.asListInOrder().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        Assertions.assertThat(bst.asListInOrder()).containsExactly(3,4,5,6,7,8,9);
        Assertions.assertThat(bst.asListInOrderItr()).containsExactly(3,4,5,6,7,8,9);
        Assertions.assertThat(bst.asListInOrderViaIterator()).containsExactly(3,4,5,6,7,8,9);


        bst.delete(3);
        Assertions.assertThat(bst.asListInOrder()).containsExactly(4,5,6,7,8,9);
        Assertions.assertThat(bst.asListInOrderItr()).containsExactly(4,5,6,7,8,9);
        Assertions.assertThat(bst.asListInOrderViaIterator()).containsExactly(4,5,6,7,8,9);

        bst.delete(6);
        Assertions.assertThat(bst.asListInOrder()).containsExactly(4,5,7,8,9);
        Assertions.assertThat(bst.asListInOrderItr()).containsExactly(4,5,7,8,9);
        Assertions.assertThat(bst.asListInOrderViaIterator()).containsExactly(4,5,7,8,9);
    }

    @Test
    public void testPostOrderTraversal() {
        System.out.println(bst.asListPostOrder().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        Assertions.assertThat(bst.asListPostOrder()).containsExactly(3,5,4,7,9,8,6);
        Assertions.assertThat(bst.asListPostOrderItr()).containsExactly(3,5,4,7,9,8,6);

        bst.delete(3);
        Assertions.assertThat(bst.asListPostOrder()).containsExactly(5,4,7,9,8,6);
        Assertions.assertThat(bst.asListPostOrderItr()).containsExactly(5,4,7,9,8,6);

        bst.delete(6);
        Assertions.assertThat(bst.asListPostOrder()).containsExactly(5,4,9,8,7);
        Assertions.assertThat(bst.asListPostOrderItr()).containsExactly(5,4,9,8,7);
    }

    @Test
    public void testPreOrderTraversal() {
        System.out.println(bst.asListPreOrder().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        Assertions.assertThat(bst.asListPreOrder()).containsExactly(6,4,3,5,8,7,9);
        Assertions.assertThat(bst.asListPreOrderItr()).containsExactly(6,4,3,5,8,7,9);
        Assertions.assertThat(bst.asListPreOrderViaIterator()).containsExactly(6,4,3,5,8,7,9);

        bst.delete(3);
        Assertions.assertThat(bst.asListPreOrder()).containsExactly(6,4,5,8,7,9);
        Assertions.assertThat(bst.asListPreOrderItr()).containsExactly(6,4,5,8,7,9);
        Assertions.assertThat(bst.asListPreOrderViaIterator()).containsExactly(6,4,5,8,7,9);

        bst.delete(6);
        Assertions.assertThat(bst.asListPreOrder()).containsExactly(7,4,5,8,9);
        Assertions.assertThat(bst.asListPreOrderItr()).containsExactly(7,4,5,8,9);
        Assertions.assertThat(bst.asListPreOrderViaIterator()).containsExactly(7,4,5,8,9);
    }

    @Test
    public void testTraverseBreadthFirst(){
        System.out.println(bst.asListBreadthFirst().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        Assertions.assertThat(bst.asListBreadthFirst()).containsExactly(6,4,8,3,5,7,9);
        Assertions.assertThat(bst.asListBreadthFirst2()).containsExactly(6,4,8,3,5,7,9);
        Assertions.assertThat(bst.asListBreadthFirstRec()).containsExactly(6,4,8,3,5,7,9);

    }

    @Test
    public void testConvertingBinaryTreeToDoublyLinkedList(){
        System.out.println(bst.asListInOrder().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        bst.flattenToDoublyLinkedList();
        System.out.println(bst.asListDLL().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
    }

}