import static junit.framework.TestCase.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests for worksheet 2
 *
 * @author Adam Robinson
 */

public class Worksheet2Test {

  private Tree<Integer> BST1, BST2, simpleBST,
      nonBST, positiveTree, negativeTree, emptyTree, singletonTree,
      nonHB, miscTree, miscTree2;

  @Before
  public void setUp() {
    BST1 = new Tree<>(6, new Tree<>(4, new Tree<>(2)
        , new Tree<>(5, new Tree<>(), new Tree<>()))
        , new Tree<>(8, new Tree<>(7, new Tree<>(), new Tree<>()),
        new Tree<>(9, new Tree<>(), new Tree<>())));
    BST2 = new Tree<>(9,
        new Tree<>(6, new Tree<>(3, new Tree<>(), new Tree<>()),
            new Tree<>(7, new Tree<>(), new Tree<>())),
        new Tree<>(15, new Tree<>(12, new Tree<>(), new Tree<>()),
            new Tree<>(21, new Tree<>(), new Tree<>())));
    simpleBST = new Tree<>(2, new Tree<>(1, new Tree<>(),
        new Tree<>()), new Tree<>(3, new Tree<>(), new Tree<>()));
    miscTree = new Tree<>(20, new Tree<>(10, new Tree<>(5, new Tree<>(2), new Tree<>()),
        new Tree<>(15, new Tree<>(13), new Tree<>(17))),
        new Tree<>(30, new Tree<>(25, new Tree<>(), new Tree<>(27)), new Tree<>(40)));
    miscTree2 = new Tree<>(20, new Tree<>(10, new Tree<>(5, new Tree<>(2), new Tree<>()),
        new Tree<>(15, new Tree<>(13), new Tree<>(17))),
        new Tree<>(30, new Tree<>(25, new Tree<>(), new Tree(27)), new Tree<>(40)));
    nonBST = new Tree<>(10,
        new Tree<>(12, new Tree<>(24, new Tree<>(), new Tree<>()),
            new Tree<>(9, new Tree<>(), new Tree<>())),
        new Tree<>(-3, new Tree<>(7, new Tree<>(), new Tree<>()),
            new Tree<>(21, new Tree<>(), new Tree<>())));
    positiveTree = new Tree<>(14,
        new Tree<>(9, new Tree<>(3, new Tree<>(), new Tree<>()),
            new Tree<>(8, new Tree<>(), new Tree<>())),
        new Tree<>(22, new Tree<>(17, new Tree<>(), new Tree<>()),
            new Tree<>(29, new Tree<>(), new Tree<>())));
    negativeTree = new Tree<>(-6, new Tree<>(-4, new Tree<>(-2)
        , new Tree<>(-5, new Tree<>(), new Tree<>()))
        , new Tree<>(-8, new Tree<>(-7, new Tree<>(), new Tree<>()),
        new Tree<>(-9, new Tree<>(), new Tree<>())));
    emptyTree = new Tree<>();
    singletonTree = new Tree<>(100, new Tree<>(), new Tree<>());
    nonHB = new Tree<>(8,
        new Tree<>(4, new Tree<>(3), new Tree<>()),
        new Tree<>());
  }

  // Exercise 1 Tests - Negate All

  @Test
  public void ex1_emptyTree() {
    Tree expected = new Tree();
    Tree actual = Worksheet2.negateAll(emptyTree);
    assertEquals(expected, actual);
  }

  @Test
  public void ex1_singletonTree() {
    int expected = -100;
    int actual = Worksheet2.negateAll(singletonTree).getValue();
    assertEquals(expected, actual);
  }

  @Test
  public void ex1_treeNeg() {
    Tree expected = new Tree<>(-6, new Tree<>(-4, new Tree<>(-2)
        , new Tree<>(-5, new Tree<>(), new Tree<>()))
        , new Tree<>(-8, new Tree<>(-7, new Tree<>(), new Tree<>()),
        new Tree<>(-9, new Tree<>(), new Tree<>())));

    Tree actual = Worksheet2.negateAll(BST1);
    assertEquals(expected, actual);
  }

  @Test
  public void ex1_leafEdgeValue() {
    int expected = -24;
    int actual = Worksheet2.negateAll(nonBST).getLeft().getLeft().getValue();
    assertEquals(expected, actual);
  }

  @Test
  public void ex1_rootValue() {
    int expected = -14;
    int actual = Worksheet2.negateAll(positiveTree).getValue();
    assertEquals(expected, actual);
  }

  // Exercise 2 Tests - All Positive

  @Test
  public void ex2_negativeTree() {
    boolean expected = false;
    boolean actual = Worksheet2.allPositive(negativeTree);
    assertEquals(expected, actual);
  }

  @Test
  public void ex2_positiveTree() {
    boolean expected = true;
    boolean actual = Worksheet2.allPositive(positiveTree);
    assertEquals(expected, actual);
  }

  @Test
  public void ex2_emptyTree() {
    boolean expected = true;
    boolean actual = Worksheet2.allPositive(emptyTree);
    assertEquals(expected, actual);
  }

  @Test
  public void ex2_singletonTree() {
    boolean expected = true;
    boolean actual = Worksheet2.allPositive(singletonTree);
    assertEquals(expected, actual);
  }

  // Exercise 3 Tests - Mirrored Tree

  @Test
  public void ex3_fullTree() {
    Tree expected = new Tree<>(6,
        new Tree<>(8, new Tree<>(9, new Tree<>(), new Tree<>()),
            new Tree<>(7, new Tree<>(), new Tree<>())),
        new Tree<>(4, new Tree<>(5, new Tree<>(), new Tree<>()),
            new Tree<>(2, new Tree<>(), new Tree<>())));
    Tree actual = Worksheet2.mirror(BST1);
    assertEquals(expected, actual);
  }

  @Test
  public void ex3_leafEdgeValue() {
    int expected = 21;
    int actual = Worksheet2.mirror(nonBST).getLeft().getLeft().getValue();
    assertEquals(expected, actual);
  }

  @Test
  public void ex3_rootValue() {
    int expected = 14;
    int actual = Worksheet2.mirror(positiveTree).getValue();
    assertEquals(expected, actual);
  }

  @Test
  public void ex3_empty() {
    Tree expected = new Tree<>();
    Tree actual = Worksheet2.mirror(emptyTree);
    assertEquals(expected, actual);
  }

  @Test
  public void ex3_singleton() {
    int expected = 100;
    int actual = Worksheet2.mirror(singletonTree).getValue();
    assertEquals(expected, actual);
  }

  // Exercise 4 Tests - Postorder

  @Test
  public void ex4_BSTree() {
    List expected = new List(2,
        new List(5, new List(4, new List(7, new List(9, new List(8, new List(6, new List())))))));
    List actual = Worksheet2.postorder(BST1);
    assertEquals(expected, actual);
  }

  @Test
  public void ex4_nonBSTree() {
    List expected = new List(24, new List(9,
        new List(12, new List(7, new List(21, new List(-3, new List(10, new List())))))));
    List actual = Worksheet2.postorder(nonBST);
    assertEquals(expected, actual);
  }

  @Test
  public void ex4_simpleBST() {
    List expected = new List(1, new List(3, new List(2, new List())));
    List actual = Worksheet2.postorder(simpleBST);
    assertEquals(expected, actual);
  }

  @Test
  public void ex4_empty() {
    List expected = new List();
    List actual = Worksheet2.postorder(emptyTree);
    assertEquals(expected, actual);
  }

  @Test
  public void ex4_singleton() {
    List expected = new List(100, new List());
    List actual = Worksheet2.postorder(singletonTree);
    assertEquals(expected, actual);
  }

  // Exercise 5 Tests - Is BSTree

  @Test
  public void ex5_binarySearchTree() {
    boolean expected = true;
    boolean actual = Worksheet2.isSearchTree(BST1);
    assertEquals(expected, actual);
  }

  @Test
  public void ex5_nonBSTree() {
    boolean expected = false;
    boolean actual = Worksheet2.isSearchTree(nonBST);
    assertEquals(expected, actual);
  }

  @Test
  public void ex5_emptyTree() {
    boolean expected = true;
    boolean actual = Worksheet2.isSearchTree(emptyTree);
    assertEquals(expected, actual);
  }

  @Test
  public void ex5_singletonTree() {
    boolean expected = true;
    boolean actual = Worksheet2.isSearchTree(singletonTree);
    assertEquals(expected, actual);
  }

  // Exercise 6 Tests - Print Descending

  @Test
  public void ex6_emptyTree() {
    ByteArrayOutputStream out1 = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out1));
    Worksheet2.printDescending(emptyTree);
    assertEquals("", out1.toString());
  }

  @Test
  public void ex6_singletonTree() {
    ByteArrayOutputStream out2 = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out2));
    Worksheet2.printDescending(singletonTree);
    assertEquals("100 ", out2.toString());
  }

  @Test
  public void ex6_BSTreeHB() {
    ByteArrayOutputStream out3 = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out3));
    Worksheet2.printDescending(BST1);
    assertEquals("9 8 7 6 5 4 2 ", out3.toString());
  }

  @Test
  public void ex6_BSTreeSimple() {
    ByteArrayOutputStream out4 = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out4));
    Worksheet2.printDescending(simpleBST);
    assertEquals("3 2 1 ", out4.toString());
  }

  // Exercise 7 Tests - Max Value

  @Test
  public void ex7_emptyTree() {
    int expected = 0;
    int actual = Worksheet2.max(emptyTree);
    assertEquals(expected, actual);
  }

  @Test
  public void ex7_singletonTree() {
    int expected = 100;
    int actual = Worksheet2.max(singletonTree);
    assertEquals(expected, actual);
  }

  @Test
  public void ex7_BSTree1() {
    int expected = 9;
    int actual = Worksheet2.max(BST1);
    assertEquals(expected, actual);
  }

  @Test
  public void ex7_BSTree2() {
    int expected = 21;
    int actual = Worksheet2.max(BST2);
    assertEquals(expected, actual);
  }

  @Test
  public void ex7_BSTree3() {
    int expected = 3;
    int actual = Worksheet2.max(simpleBST);
    assertEquals(expected, actual);
  }

  // Exercise 8 Tests - Delete Value

  @Test
  public void q8_emptyTree() {
    Tree expected = new Tree<>();
    Tree actual = Worksheet2.delete(emptyTree, 9);
    assertEquals(expected, actual);
  }

  @Test
  public void q8_singletonTree() {
    Tree expected = new Tree<>();
    Tree actual = Worksheet2.delete(singletonTree, 100);
    assertEquals(expected, actual);
  }

  @Test
  public void q8_singletonTreeNOVal() {
    Tree expected = new Tree<>(100, new Tree<>(), new Tree<>());
    Tree actual = Worksheet2.delete(singletonTree, 99);
    assertEquals(expected, actual);
  }

  @Test
  public void q8_simpleTree() {
    Tree expected = new Tree<>(2, new Tree<>(1), new Tree<>());
    Tree actual = Worksheet2.delete(simpleBST, 3);
    assertEquals(expected, actual);
  }

  @Test
  public void q8_deletionTree() {
    Tree expected = new Tree<>(17,
        new Tree(10, new Tree(5, new Tree(2), new Tree()), new Tree(15, new Tree(13), new Tree())),
        new Tree(30, new Tree(25, new Tree(), new Tree(27)), new Tree(40)));
    Tree actual = Worksheet2.delete(miscTree, 20);
    assertEquals(expected, actual);
  }

  // Exercise 9 Tests - Height balanced

  @Test
  public void ex9_emptyTree() {
    boolean expected = true;
    boolean actual = Worksheet2.isHeightBalanced(emptyTree);
    assertEquals(expected, actual);
  }

  @Test
  public void ex9_singletonTree() {
    boolean expected = true;
    boolean actual = Worksheet2.isHeightBalanced(singletonTree);
    assertEquals(expected, actual);
  }

  @Test
  public void ex9_binarySearchTree() {
    boolean expected = true;
    boolean actual = Worksheet2.isHeightBalanced(BST1);
    assertEquals(expected, actual);
  }

  @Test
  public void ex9_nonHeightBalanced() {
    boolean expected = false;
    boolean actual = Worksheet2.isHeightBalanced(nonHB);
    assertEquals(expected, actual);
  }

  // Exercise 10 Tests - Insert Delete

  @Test
  public void ex10_simpleInsertHB() {
    Tree expected = new Tree<>(8,
        new Tree<>(4, new Tree<>(3), new Tree<>()),
        new Tree<>(10));
    Tree actual = Worksheet2.insertHB(10, nonHB);
    assertEquals(expected, actual);
  }

  @Test
  public void ex10_treeInsertHB() {
    Tree expected = new Tree<>(20, new Tree<>(10, new Tree<>(5, new Tree<>(2), new Tree<>()),
        new Tree<>(15, new Tree<>(13), new Tree<>(17))),
        new Tree<>(30, new Tree<>(25, new Tree<>(24), new Tree<>(27)), new Tree<>(40)));
    Tree actual = Worksheet2.insertHB(24, miscTree2);
    assertEquals(expected, actual);
  }

  @Test
  public void ex10_emptyInsertHB() {
    Tree expected = new Tree<>(3);
    Tree actual = Worksheet2.insertHB(3, emptyTree);
    assertEquals(expected, actual);
  }

  @Test
  public void ex10_singletonInsertHB() {
    Tree expected = new Tree<>(100, new Tree<>(99), new Tree<>());
    Tree actual = Worksheet2.insertHB(99, singletonTree);
    assertEquals(expected, actual);
  }

  @Test
  public void ex10_simpleDeleteHB() {
    Tree expected = new Tree<>(8,
        new Tree<>(4, new Tree<>(), new Tree<>()),
        new Tree<>());
    Tree actual = Worksheet2.deleteHB(nonHB, 3);
    assertEquals(expected, actual);
  }

  @Test
  public void ex10_treeDeleteHB() {
    Tree expected = new Tree<>(17,
        new Tree<>(10, new Tree<>(5, new Tree<>(2), new Tree<>()),
            new Tree<>(15, new Tree<>(13), new Tree<>())),
        new Tree<>(30, new Tree<>(25, new Tree<>(), new Tree<>(27)), new Tree<>(40)));
    Tree actual = Worksheet2.deleteHB(miscTree, 20);
    assertEquals(expected, actual);
  }

  @Test
  public void ex10_emptyDeleteHB() {
    Tree expected = new Tree();
    Tree actual = Worksheet2.deleteHB(emptyTree, 3);
    assertEquals(expected, actual);
  }

  @Test
  public void ex10_singletonDeleteHB() {
    Tree expected = new Tree();
    Tree actual = Worksheet2.deleteHB(singletonTree, 100);
    assertEquals(expected, actual);
  }

}