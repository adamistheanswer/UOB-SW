/**
 * @author Adam Robinson
 * This class contains the solutions for Worksheet2-2
 */

public class Worksheet2 implements Worksheet2Interface {

  // Exercise 1

  /**
   * Method returns a tree with all elements from input tree negated.
   * Base case checks if tree is empty, in which case it returns the same tree
   * If the tree contains Integer values it multiplies each element by -1.
   *
   * @param t Input tree of type integer
   * @return Negated input tree
   */

  public static Tree<Integer> negateAll(Tree<Integer> t) {
    if (t.isEmpty()) {
      return new Tree<>();
    } else {
      return new Tree<>(t.getValue() * -1, negateAll(t.getLeft()), negateAll(t.getRight()));
    }
  }

  // Exercise 2

  /**
   * Method returns boolean value testing if all input tree elements are positive.
   * Base case checks if tree is empty, in which case it returns true, as empty tree classed as positive.
   * Method recursively called on left and right sub trees where their root nodes are tested against >= 0
   *
   * @param a Input tree of type integer
   * @return TRUE: If all elements positive FALSE: If an element is negative
   */

  public static boolean allPositive(Tree<Integer> a) {
    if (a.isEmpty()) {
      return true;
    } else if (a.getValue() >= 0) {
      return allPositive(a.getLeft()) && allPositive(a.getRight());
    } else {
      return false;
    }
  }

  // Exercise 3

  /**
   * Returns vertically mirrored tree from input tree.
   * Base case checks if the tree is empty, in which case it returns the same tree
   * as mirrored output is identical.
   *
   * @param t Input tree of type generic
   * @return Input tree with all its elements mirrored to the opposite side
   */

  public static <E> Tree<E> mirror(Tree<E> t) {
    if (t.isEmpty()) {
      return new Tree<>();
    } else {
      return new Tree<>(t.getValue(), mirror(t.getRight()), mirror(t.getLeft()));
    }
  }

  // Exercise 4

  // Append helper method from ListOps

  public static <E> List<E> append(List<E> a, List<E> b) {
    if (a.isEmpty()) {
      return b;
    } else {
      return new List<>(a.getHead(), append(a.getTail(), b));
    }
  }

  /**
   * This method returns a list containing all the elements of an input tree traversed in post order.
   * Base case checks if tree is empty. If empty it returns empty list. If tree contains values,
   * The left subtree's node, the right subtree's node and finally the root node are attained.
   * Method called recursively on all subtrees & their output appended to the first list.
   *
   * @param t input tree of type generic
   * @return list of elements traversed in post order
   */

  public static <E> List<E> postorder(Tree<E> t) {
    if (t.isEmpty()) {
      return new List<>();
    } else {
      return append(postorder(t.getLeft()),
          append(postorder(t.getRight()), (new List<>(t.getValue(), (new List<>())))));
    }
  }

  // Exercise 5 V.1

//  public static boolean isSearchTree(Tree<Integer> a) {
//    if (a.isEmpty() || a.getHeight() == 1) {
//      return true;
//    } else if (!a.getLeft().isEmpty() && a.getRight().isEmpty()) {
//      return isSearchTree(a.getLeft());
//    } else if (!a.getRight().isEmpty() && a.getLeft().isEmpty()) {
//      return isSearchTree(a.getRight());
//    } else if (a.getLeft().getValue() < a.getValue() && a.getRight().getValue() > a.getValue()) {
//      return isSearchTree(a.getLeft()) && isSearchTree(a.getRight());
//    } else {
//      return false;
//    }
//  }

  // Exercise 5

  /**
   * Methods base case checks if input tree is empty, returning true if so.
   * If input tree contains elements helper method is recursively called on input trees left & right subtrees.
   * Initially assigning min & max of helper method to Integer.MIN_VALUE & Integer.MAX_VALUE
   *
   * @param a Input tree of type integer
   * @return TRUE: Is a binary search tree FALSE: Isn't a BST
   */

  public static boolean isSearchTree(Tree<Integer> a) {
    if (a.isEmpty()) {
      return true;
    } else {
      return searchHelper(a.getLeft(), a.getValue(), Integer.MIN_VALUE) && searchHelper(
          a.getRight(), Integer.MAX_VALUE, a.getValue());
    }
  }

  /**
   * EX 5 HELPER METHOD
   *
   * Base case returns true if no further nodes left to consider.
   * If current root node under consideration is less < min & > max, helper method recursively called
   * returning left & right sub trees and re assigning the max and min as the previous root node for
   * comparison at deeper recursive call.
   *
   * @param a Input tree integer
   * @param max Maximum value in search tree (cascading assignment from all root nodes traversed)
   * @param min Minimum value in search tree (cascading assignment from all root nodes traversed)
   * @return TRUE: If root nodes < min & > max FALSE: If root nodes fail this test
   */

  public static boolean searchHelper(Tree<Integer> a, int max, int min) {
    if (a.isEmpty()) {
      return true;
    }
    if (min < a.getValue() && a.getValue() < max) {
      return (searchHelper(a.getLeft(), a.getValue(), min) && searchHelper(a.getRight(), max,
          a.getValue()));
    } else {
      return false;
    }
  }

  // Exercise 6

  /**
   * Method prints all vales within a BST in order from highest to lowest.
   * If BST contains values, method recursively finds right subtree (bottom right value highest)
   * Right subtree root value then called and printed to console.
   * Unable to find left on first pass therefore root node printed from height - 1 right subtree.
   * Get left then possible and and printed.
   * Process recursively called.
   *
   * @param a Input tree of type integer
   */

  public static void printDescending(Tree<Integer> a) {
    if (!a.isEmpty()) {
      printDescending(a.getRight());
      System.out.print(a.getValue() + " ");
      printDescending(a.getLeft());
    }
  }

  // Exercise 7

  /**
   * Base case of method returns 0 as max if input tree empty.
   * Method recursively calls right subtree if right subtree is not empty.
   * If no further right subtree can be called right node of deepest right subtree returned
   *
   * @param a Input tree
   * @return Maximum value
   */

  public static int max(Tree<Integer> a) {
    if (a.isEmpty()) {
      return 0;
    }
    if (!a.getRight().isEmpty()) {
      return max(a.getRight());
    } else {
      return a.getValue();
    }
  }

  // Exercise 8

  /**
   * Method removes Integer x from a BST.
   * Method base case, if tree is empty return new empty tree.
   * When X is less than node, left subtree recursively called.
   * When X is greater than node, right subtree recursively called.
   *
   * If the right subtree is empty from the value for deletion return left subtree
   * If the left subtree is empty from the value for deletion return right subtree
   * If there are subtrees left and right bellow node under inspection the maximum value of the left
   * subtree is set to the root node and the original instance of the max left sub tree value is removed
   *
   * @param a Input binary search tree
   * @param x Integer to be removed from binary search tree
   * @return Input tree with X removed
   */

  public static Tree<Integer> delete(Tree<Integer> a, int x) {
    if (a.isEmpty()) {
      return new Tree<>();
    } else if (x < a.getValue()) {
      return new Tree<>(a.getValue(), delete(a.getLeft(), x), a.getRight());
    } else if (x > a.getValue()) {
      return new Tree<>(a.getValue(), a.getLeft(), delete(a.getRight(), x));
    } else {
      if (a.getRight().isEmpty() && a.getLeft().isEmpty()) {
        return new Tree<>();
      } else if (a.getRight().isEmpty()) {
        return a.getLeft();
      } else if (a.getLeft().isEmpty()) {
        return a.getRight();
      } return new Tree<>(max(a.getLeft()), delete(a.getLeft(), max(a.getLeft())), a.getRight());
      }
    }


  // Exercise 9

  /**
   * Method tests in BST is height balanced. (Right & Left subtree heights difference are no greater than 1)
   * Tests that difference between left and right trees are no greater then 1
   * Recursively calls left and right subtree to ensure subtrees are also balanced
   *
   * @param a Input Binary Search Tree of type generic
   * @return TRUE: If tree is height balanced (Right & Left subtree heights difference are no greater than 1)
   *         FALSE:If difference in Right & Left subtree heights are greater then 1)
   */

  public static <E> boolean isHeightBalanced(Tree<E> a) {
    if (a.isEmpty()) {
      return true;
    } else {
      if (Math.abs(a.getLeft().getHeight() - a.getRight().getHeight()) > 1) {
        return false;
      }
      return isHeightBalanced(a.getLeft()) && isHeightBalanced(a.getRight());
    }
  }


// Exercise 10

  /**
   * Method inserts an integer into a height balanced Binary Search Tree of type integer
   * Base case 1 : if tree is empty returns a tree only containing insertion value
   * Base case 2 : if X is already present in the tree, the input tree is returned so there are no duplicates
   *
   * @param x Integer to be inserted into binary search tree
   * @param a Input Tree of type integer
   * @return Binary search tree with X inserted
   */

  public static Tree insertHB(int x, Tree<Integer> a) {
    if (a.isEmpty())
      return new Tree<>(x);
    if (x == a.getValue())
      return a;
    if (x < a.getValue())
      return balancer(new Tree<Integer>(a.getValue(), insertHB(x, a.getLeft()), a.getRight()));
    else
      return balancer(new Tree<Integer>(a.getValue(), a.getLeft(), insertHB(x, a.getRight())));
  }

  /**
   * Method removes an integer from a height balanced Binary Search Tree of type integer
   * Base case 1 : if tree is empty returns a new empty tree
   *
   * @param a Input tree of type Integer
   * @param x Integer to be removed from input tree
   * @return Binary search tree with X removed
   */

  public static Tree<Integer> deleteHB(Tree<Integer> a, int x) {
    if (a.isEmpty())
      return new Tree<>();
    else if (x < a.getValue())
      return balancer( new Tree<>(a.getValue(), delete(a.getLeft(), x), a.getRight()));
    else if (x > a.getValue())
      return balancer(new Tree<>(a.getValue(),a.getLeft(), delete(a.getRight(),x)));
    if (a.getLeft().isEmpty() && a.getRight().isEmpty())
      return new Tree<>();
    else if (a.getLeft().isEmpty())
      return a.getRight();
    else if (a.getRight().isEmpty())
      return a.getLeft();
    else return balancer( new Tree<>(max(a.getLeft()),delete(a.getLeft(), max(a.getLeft())), a.getRight()));
  }

  //Helper methods for 10

  /**
   * Helper method for right tree rotation
   *
   * @param a Input tree of type integer
   * @return  Right Rotated input tree
   */

  public static Tree<Integer> rotateRight(Tree <Integer> a){
    return new Tree<>(a.getLeft().getValue(),a.getLeft().getLeft(), new Tree<>(a.getValue(), a.getLeft().getRight(), a.getRight()));
  }

  /**
   * Helper method for right left tree rotation
   *
   * @param a Input tree of type integer
   * @return  Right Left Rotated input tree
   */

  public static Tree<Integer>rightLeftRotate(Tree<Integer> a){
    return rotateLeft( new Tree<> (a.getValue(), a.getLeft(), rotateRight(a.getRight())));
  }

  /**
   * Helper method for left tree rotation
   *
   * @param a Input tree of type integer
   * @return  Left Rotated input tree
   */

  public static Tree<Integer> rotateLeft(Tree <Integer> a){
    return new Tree<>(a.getRight().getValue(), new Tree<>(a.getValue(),a.getLeft(),a.getRight().getLeft()) ,a.getRight().getRight());
  }

  /**
   * Helper method for left right tree rotation
   *
   * @param a Input tree of type integer
   * @return Left Right Rotated input tree
   */

  public static Tree<Integer>leftRightRotate(Tree<Integer> a){
    return rotateRight( new Tree <> (a.getValue(), rotateLeft(a.getLeft()), a.getRight()));
  }


  /**
   * This helper method uses the output from the balance value method
   * to determine appropriate rotations to height balance the input tree
   *
   * @param a Input tree of type integer
   * @return Rotated tree height balanced
   */

  public static Tree<Integer> balancer(Tree<Integer> a){
    if (isHeightBalanced(a))
      return a;
    else {
      if (balanceValue(a) < 0) {
        if (balanceValue(a.getLeft()) > 0) {
          return leftRightRotate(a);
        }
        return rotateRight(a);
      }
      if (balanceValue(a) > 0) {
        if (balanceValue(a.getRight()) < 0) {
          return rightLeftRotate(a);
        }
        return rotateLeft(a);
      }
    }
    return a;
  }

  /**
   * This helper method gives a balance value as the difference
   * between left and right sub trees height
   *
   * @param a Input tree of type integer
   * @return The deference in height between a left and right subtree
   */

  public static int balanceValue(Tree<Integer> a) {
    if (!a.isEmpty()) {
      return a.getRight().getHeight() - a.getLeft().getHeight();
    } else {
      return 0;
    }
  }
  }
