package org.hsmak.datastructures.tree;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(Parameterized.class)
public class BinarySearchTreeTest {

    BinarySearchTree<Integer> bst;

    TestData TEST_DATA;


    public BinarySearchTreeTest(TestData TEST_DATA) {
        this.TEST_DATA = TEST_DATA;
        bst = new BinarySearchTree<>();
        TEST_DATA.input().stream().forEach(bst::add);

        List<Integer> l2 = List.of(1, 0, 3, 2, 5, 4, 7, 6);
//        l2.stream().forEach(bst::add);

        List<Integer> l3 = List.of(7, 0, 3, 2, 1, 6, 5, 4);
//        l3.stream().forEach(bst::add);

    }

    @Parameterized.Parameters(name = "{0}")
    public static EnumSet<TestData> getEnums() {
        return EnumSet.allOf(TestData.class);
    }

    interface ITestData<T> {
        List<T> input();

        List<T> expectedBreadthFirstOrder();

        List<T> expectedBreadthFirstOrderAfterDelete3();

        List<T> expectedBreadthFirstOrderAfterDelete6();

        List<T> expectedPreOrder();

        List<T> expectedInOrder();

        List<T> expectedPostOrder();

        List<T> expectedPreOrderAfterDelete3();

        List<T> expectedInOrderAfterDelete3();

        List<T> expectedPostOrderAfterDelete3();

        List<T> expectedPreOrderAfterDelete6();

        List<T> expectedInOrderAfterDelete6();

        List<T> expectedPostOrderAfterDelete6();
    }

    @RunWith(Parameterized.class)
    private enum TestData implements ITestData<Integer> {
        SAMPLE_DATA_01 {
            @Override
            public List<Integer> input() {
                return List.of(6, 4, 8, 3, 5, 7, 9);
            }

            @Override
            public List<Integer> expectedBreadthFirstOrder() {
                return List.of(6, 4, 8, 3, 5, 7, 9);
            }

            @Override
            public List<Integer> expectedBreadthFirstOrderAfterDelete3() {
                return List.of(6, 4, 8, 5, 7, 9);
            }

            @Override
            public List<Integer> expectedBreadthFirstOrderAfterDelete6() {
                return List.of(7, 4, 8, 5, 9);
            }

            @Override
            public List<Integer> expectedPreOrder() {
                return List.of(6, 4, 3, 5, 8, 7, 9);
            }

            @Override
            public List<Integer> expectedInOrder() {
                return List.of(3, 4, 5, 6, 7, 8, 9);
            }

            @Override
            public List<Integer> expectedPostOrder() {
                return List.of(3, 5, 4, 7, 9, 8, 6);
            }

            @Override
            public List<Integer> expectedPreOrderAfterDelete3() {
                return List.of(6, 4, 5, 8, 7, 9);
            }

            @Override
            public List<Integer> expectedInOrderAfterDelete3() {
                return List.of(4, 5, 6, 7, 8, 9);
            }

            @Override
            public List<Integer> expectedPostOrderAfterDelete3() {
                return List.of(5, 4, 7, 9, 8, 6);
            }

            @Override
            public List<Integer> expectedPreOrderAfterDelete6() {
                return List.of(7, 4, 5, 8, 9);
            }

            @Override
            public List<Integer> expectedInOrderAfterDelete6() {
                return List.of(4, 5, 7, 8, 9);
            }

            @Override
            public List<Integer> expectedPostOrderAfterDelete6() {
                return List.of(5, 4, 9, 8, 7);
            }

        },

        //ToDo
        /*SAMPLE_DATA_02 {
            @Override
            public List<Integer> input() {
                return Collections.emptyList();
            }

            @Override
            public List<Integer> expectedBreadthFirstOrder() {
                return null;
            }

            @Override
            public List<Integer> expectedBreadthFirstOrderAfterDelete3() {
                return null;
            }

            @Override
            public List<Integer> expectedBreadthFirstOrderAfterDelete6() {
                return null;
            }

            @Override
            public List<Integer> expectedPreOrder() {
                return null;
            }

            @Override
            public List<Integer> expectedInOrder() {
                return null;
            }

            @Override
            public List<Integer> expectedPostOrder() {
                return null;
            }

            @Override
            public List<Integer> expectedPreOrderAfterDelete3() {
                return null;
            }

            @Override
            public List<Integer> expectedInOrderAfterDelete3() {
                return null;
            }

            @Override
            public List<Integer> expectedPostOrderAfterDelete3() {
                return null;
            }

            @Override
            public List<Integer> expectedPreOrderAfterDelete6() {
                return null;
            }

            @Override
            public List<Integer> expectedInOrderAfterDelete6() {
                return null;
            }

            @Override
            public List<Integer> expectedPostOrderAfterDelete6() {
                return null;
            }
        }*/
        ;

        @Override
        public String toString() {
            return Stream.of(name(), input().toString()).collect(Collectors.joining(" -> "));
        }
    }

    @Test
    public void testTraversalInOrder() {
        System.out.println(bst.asListInOrder().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        Assertions.assertThat(bst.asListInOrder()).containsExactly(TEST_DATA.expectedInOrder().toArray(Integer[]::new));
        Assertions.assertThat(bst.asListInOrderItr()).containsExactly(TEST_DATA.expectedInOrder().toArray(Integer[]::new));
        Assertions.assertThat(bst.asListInOrderViaIterator()).containsExactly(TEST_DATA.expectedInOrder().toArray(Integer[]::new));


        bst.delete(3);
        Assertions.assertThat(bst.asListInOrder()).containsExactly(TEST_DATA.expectedInOrderAfterDelete3().toArray(Integer[]::new));
        Assertions.assertThat(bst.asListInOrderItr()).containsExactly(TEST_DATA.expectedInOrderAfterDelete3().toArray(Integer[]::new));
        Assertions.assertThat(bst.asListInOrderViaIterator()).containsExactly(TEST_DATA.expectedInOrderAfterDelete3().toArray(Integer[]::new));

        bst.delete(6);
        Assertions.assertThat(bst.asListInOrder()).containsExactly(TEST_DATA.expectedInOrderAfterDelete6().toArray(Integer[]::new));
        Assertions.assertThat(bst.asListInOrderItr()).containsExactly(TEST_DATA.expectedInOrderAfterDelete6().toArray(Integer[]::new));
        Assertions.assertThat(bst.asListInOrderViaIterator()).containsExactly(TEST_DATA.expectedInOrderAfterDelete6().toArray(Integer[]::new));
    }

    @Test
    public void testTraversalPostOrder() {
        System.out.println(bst.asListPostOrder().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        System.out.println(bst.asListPostOrderItr().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));

        Assertions.assertThat(bst.asListPostOrder()).containsExactly(TEST_DATA.expectedPostOrder().toArray(Integer[]::new));
        Assertions.assertThat(bst.asListPostOrderItr()).containsExactly(TEST_DATA.expectedPostOrder().toArray(Integer[]::new));
        Assertions.assertThat(bst.asListPostOrderViaIterator()).containsExactly(TEST_DATA.expectedPostOrder().toArray(Integer[]::new));

        bst.delete(3);
        Assertions.assertThat(bst.asListPostOrder()).containsExactly(TEST_DATA.expectedPostOrderAfterDelete3().toArray(Integer[]::new));
        Assertions.assertThat(bst.asListPostOrderItr()).containsExactly(TEST_DATA.expectedPostOrderAfterDelete3().toArray(Integer[]::new));
        Assertions.assertThat(bst.asListPostOrderViaIterator()).containsExactly(TEST_DATA.expectedPostOrderAfterDelete3().toArray(Integer[]::new));

        bst.delete(6);
        Assertions.assertThat(bst.asListPostOrder()).containsExactly(TEST_DATA.expectedPostOrderAfterDelete6().toArray(Integer[]::new));
        Assertions.assertThat(bst.asListPostOrderItr()).containsExactly(TEST_DATA.expectedPostOrderAfterDelete6().toArray(Integer[]::new));
        Assertions.assertThat(bst.asListPostOrderViaIterator()).containsExactly(TEST_DATA.expectedPostOrderAfterDelete6().toArray(Integer[]::new));
    }

    @Test
    public void testTraversalPreOrder() {
        System.out.println(bst.asListPreOrder().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        Assertions.assertThat(bst.asListPreOrder()).containsExactly(TEST_DATA.expectedPreOrder().toArray(Integer[]::new));
        Assertions.assertThat(bst.asListPreOrderItr()).containsExactly(TEST_DATA.expectedPreOrder().toArray(Integer[]::new));
        Assertions.assertThat(bst.asListPreOrderViaIterator()).containsExactly(TEST_DATA.expectedPreOrder().toArray(Integer[]::new));

        bst.delete(3);
        Assertions.assertThat(bst.asListPreOrder()).containsExactly(TEST_DATA.expectedPreOrderAfterDelete3().toArray(Integer[]::new));
        Assertions.assertThat(bst.asListPreOrderItr()).containsExactly(TEST_DATA.expectedPreOrderAfterDelete3().toArray(Integer[]::new));
        Assertions.assertThat(bst.asListPreOrderViaIterator()).containsExactly(TEST_DATA.expectedPreOrderAfterDelete3().toArray(Integer[]::new));

        bst.delete(6);
        Assertions.assertThat(bst.asListPreOrder()).containsExactly(TEST_DATA.expectedPreOrderAfterDelete6().toArray(Integer[]::new));
        Assertions.assertThat(bst.asListPreOrderItr()).containsExactly(TEST_DATA.expectedPreOrderAfterDelete6().toArray(Integer[]::new));
        Assertions.assertThat(bst.asListPreOrderViaIterator()).containsExactly(TEST_DATA.expectedPreOrderAfterDelete6().toArray(Integer[]::new));
    }

    @Test
    public void testTraverseBreadthFirst() {
        System.out.println(bst.asListBreadthFirst().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        Assertions.assertThat(bst.asListBreadthFirst()).containsExactly(TEST_DATA.expectedBreadthFirstOrder().toArray(Integer[]::new));
        Assertions.assertThat(bst.asListBreadthFirstByLevelIter()).containsExactly(TEST_DATA.expectedBreadthFirstOrder().toArray(Integer[]::new));
        Assertions.assertThat(bst.asListBreadthFirstByLevelRec()).containsExactly(TEST_DATA.expectedBreadthFirstOrder().toArray(Integer[]::new));

        bst.delete(3);
        Assertions.assertThat(bst.asListBreadthFirst()).containsExactly(TEST_DATA.expectedBreadthFirstOrderAfterDelete3().toArray(Integer[]::new));
        Assertions.assertThat(bst.asListBreadthFirstByLevelIter()).containsExactly(TEST_DATA.expectedBreadthFirstOrderAfterDelete3().toArray(Integer[]::new));
        Assertions.assertThat(bst.asListBreadthFirstByLevelRec()).containsExactly(TEST_DATA.expectedBreadthFirstOrderAfterDelete3().toArray(Integer[]::new));

        bst.delete(6);
        Assertions.assertThat(bst.asListBreadthFirst()).containsExactly(TEST_DATA.expectedBreadthFirstOrderAfterDelete6().toArray(Integer[]::new));
        Assertions.assertThat(bst.asListBreadthFirstByLevelIter()).containsExactly(TEST_DATA.expectedBreadthFirstOrderAfterDelete6().toArray(Integer[]::new));
        Assertions.assertThat(bst.asListBreadthFirstByLevelRec()).containsExactly(TEST_DATA.expectedBreadthFirstOrderAfterDelete6().toArray(Integer[]::new));
    }

    @Test
    public void testToSinglyLinkedListIter() { // ToDo - revisit since this might be flatten into a SinglyLinkedList
        System.out.println(bst.asListInOrder().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));

        bst.toSinglyLinkedListIter();
        System.out.println(bst.rightSubtreesAsList().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));

        System.out.println("asListPreOrder: " + bst.asListPreOrder().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        System.out.println("asListInOrder: " + bst.asListInOrder().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        System.out.println("asListPostOrder: " + bst.asListPostOrder().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
    }

    @Test
    public void testToDoublyLinkedListPreOrder() {
        System.out.println("asListPreOrder: " + bst.asListPreOrder().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        System.out.println("asListInOrder: " + bst.asListInOrder().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        System.out.println("asListPostOrder: " + bst.asListPostOrder().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));

        System.out.println("---");
        bst.toDoublyLinkedListPreOrder();
        System.out.println("rightSubtreesAsList: " + bst.rightSubtreesAsList().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        System.out.println("leftSubtreesAsList: " + bst.leftSubtreesAsList().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        System.out.println("---");
    }

    @Test
    public void testToDoublyLinkedListInOrder() {
        System.out.println("asListPreOrder: " + bst.asListPreOrder().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        System.out.println("asListInOrder: " + bst.asListInOrder().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        System.out.println("asListPostOrder: " + bst.asListPostOrder().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        System.out.println("---");

        bst.toDoublyLinkedListInOrder();

        System.out.println("rightSubtreesAsList: " + bst.rightSubtreesAsList().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        System.out.println("leftSubtreesAsList: " + bst.leftSubtreesAsList().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
    }

    @Test
    public void testToDoublyLinkedListInOrderReversed() {
        System.out.println("asListPreOrder: " + bst.asListPreOrder().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        System.out.println("asListInOrder: " + bst.asListInOrder().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        System.out.println("asListPostOrder: " + bst.asListPostOrder().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        System.out.println("---");

        bst.toDoublyLinkedListInOrderReversed();

        System.out.println("rightSubtreesAsList: " + bst.rightSubtreesAsList().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        System.out.println("leftSubtreesAsList: " + bst.leftSubtreesAsList().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
    }

    @Test
    public void testToDoublyLinkedListPostOrder() {
        System.out.println("asListPreOrder: " + bst.asListPreOrder().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        System.out.println("asListInOrder: " + bst.asListInOrder().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        System.out.println("asListPostOrder: " + bst.asListPostOrder().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        System.out.println("---");

        bst.toDoublyLinkedListPostOrder();

        System.out.println("rightSubtreesAsList: " + bst.rightSubtreesAsList().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        System.out.println("leftSubtreesAsList: " + bst.leftSubtreesAsList().stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
    }

}