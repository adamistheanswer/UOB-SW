/**
 * @author Adam Robinson This class contains the solution for Worksheet1
 * @version 2018-01-18
 */

public class Worksheet1 {

  // Exercise 1

  /**
   * This method gives the m ^ n using recursion using liner complexity O(n)
   *
   * @param m Integer base to be raised to the power of n (non negative)
   * @param n Integer exponent (non negative)
   * @return m ^ n
   */

  public static int power(int m, int n) {
    if (n == 0) {
      return 1;
    } else {
      return power(m, n - 1) * m;
    }
  }

  /**
   * This method gives the m ^ n using recursion using 0 log n complexity
   *
   * @param m Integer base to be raised to the power of n
   * @param n Integer exponent
   * @return m ^ n
   */

  public static int fastPower(int m, int n) {
    if (n == 0) {
      return 1;
    } else if (n % 2 == 1) {
      return fastPower(m, n - 1) * m;
    } else {
      int y = fastPower(m, n / 2);
      return y * y;
    }
  }

  // Exercise 2

  /**
   * This method changes all positive numbers to negative and all negative to positive within a
   * list
   *
   * @param a Input list of integers to be negated
   * @return List with all numbers negated
   */

  public static List<Integer> negateAll(List<Integer> a) {
    if (a.isEmpty()) {
      return new List<>();
    } else {
      return new List<>(a.getHead() * -1, negateAll(a.getTail()));
    }
  }

  // Exercise 3

  /**
   * This method gives the index of the integer under inspection within a provided list. An
   * Exception will be thrown if x not in list.
   *
   * @param x The integer to be located within the supplied list
   * @param a A List of integers that should contain x
   * @return The index of x within list a.
   */

  public static int find(int x, List<Integer> a) {
    if (a.isEmpty()) {
      throw new IllegalArgumentException("Not In List");
    } else if (a.getHead() == x) {
      return 0;
    } else {
      return 1 + find(x, a.getTail());
    }
  }

  // Exercise 4

  /**
   * This method checks that all of the integers within a supplied list are positive
   *
   * @param a A List of integers we want to determine if all positive or not
   * @return TRUE: if all integers within list are positive FALSE: 1 or more integers are negative
   */

  public static boolean allPositive(List<Integer> a) {
    if (a.isEmpty()) {
      return true;
    } else if (a.getHead() >= 0) {
      return allPositive(a.getTail());
    } else {
      return false;
    }
  }

  // Exercise 5

  /**
   * This method finds all of the positive integers within a supplied list
   *
   * @param a A List of integers
   * @return a List containing positive integers
   */

  public static List<Integer> positives(List<Integer> a) {
    if (a.isEmpty()) {
      return new List<>();
    } else if (a.getHead() >= 0) {
      return new List<>(a.getHead(), positives(a.getTail()));
    } else {
      return positives(a.getTail());
    }
  }

  // Exercise 6

  /**
   * This method determines whether the values within list are sorted
   *
   * @param a A List of integers
   * @return TRUE: If the list is sorted FALSE: If the list is unsorted
   */

  public static boolean sorted(List<Integer> a) {
    if (a.isEmpty() || a.getTail().isEmpty()) {
      return true;
    } else if (a.getHead() <= (a.getTail()).getHead()) {
      return sorted(a.getTail());
    } else {
      return false;
    }
  }

  // Exercise 7

  /**
   * This method merges two sorted lists in ascending order
   *
   * @param a a sorted list of integers
   * @param b a sorted list of integers
   * @return A list in ascending order containing the values of list a & b
   */

  public static List<Integer> merge(List<Integer> a, List<Integer> b) {
    if (a.isEmpty()) {
      return b;
    } else if (b.isEmpty()) {
      return a;
    } else if (a.getHead() <= b.getHead()) {
      return new List<>(a.getHead(), merge(a.getTail(), b));
    } else {
      return new List<>(b.getHead(), merge(b.getTail(), a));
    }
  }

  // Exercise 8

  /**
   * This method removes duplicate values from a list
   *
   * @param a A List of integers
   * @return a List containing unique integers
   */

  static List<Integer> removeDuplicates(List<Integer> a) {
    if (a.isEmpty() || a.getTail().isEmpty()) {
      return a;
    } else if (a.getHead() == (a.getTail()).getHead()) {
      return removeDuplicates(a.getTail());
    } else {
      return new List<>(a.getHead(), removeDuplicates(a.getTail()));
    }
  }

}