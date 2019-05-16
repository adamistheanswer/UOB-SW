import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author Adam Robinson This class contains the test cases for Worksheet1 solutions.
 */

public class Worksheet1Test {

  @Rule
  public final ExpectedException exception = ExpectedException.none();

  @Test
  // Powers
  public void ex1Test() {

    // finding the identity of power
    assertEquals(1, Worksheet1.power(0, 0));
    // 1 ^ 1
    assertEquals(1, Worksheet1.power(1, 1));
    // unique inputs powered
    assertEquals(32, Worksheet1.power(2, 5));
    // finding the identity of power
    assertEquals(1, Worksheet1.fastPower(0, 0));
    // 1 ^ 1
    assertEquals(1, Worksheet1.fastPower(1, 1));
    // unique inputs powered
    assertEquals(32, Worksheet1.fastPower(2, 5));
  }

  @Test
  // Negate List
  public void ex2Test() {

    List<Integer> a = new List<>(-1, new List<>(2, new List<>(-3, new List<>(4, new List<>()))));
    List<Integer> aNeg = new List<>(1, new List<>(-2, new List<>(3, new List<>(-4, new List<>()))));
    List<Integer> b = new List<>(1, new List<>(1, new List<>(1, new List<>(1, new List<>()))));
    List<Integer> bNeg = new List<>(-1,
        new List<>(-1, new List<>(-1, new List<>(-1, new List<>()))));
    List<Integer> empty = new List<>();
    List<Integer> singleton = new List<>(10, new List<>());
    List<Integer> singletonNeg = new List<>(-10, new List<>());

    // Negate List of Uniques
    assertEquals(aNeg, Worksheet1.negateAll(a));
    // List of Duplicates
    assertEquals(bNeg, Worksheet1.negateAll(b));
    // Empty List
    assertEquals(empty, Worksheet1.negateAll(empty));
    // Singleton
    assertEquals(singletonNeg, Worksheet1.negateAll(singleton));

  }


  @Test
  // Find Index
  public void ex3Test() {

    List<Integer> singleton = new List<>(10, new List<>());
    List<Integer> empty = new List<>();
    List<Integer> a = new List<>(1, new List<>(2, new List<>(3, new List<>(4, new List<>()))));

    // Center of list Test
    assertEquals(2, Worksheet1.find(3, a));
    // Edge Case 1st Value
    assertEquals(0, Worksheet1.find(1, a));
    // Edge Case Last Value
    assertEquals(3, Worksheet1.find(4, a));
    // Singleton Test
    assertEquals(0, Worksheet1.find(10, singleton));

    // Value not in list Exception
    exception.expect(IllegalArgumentException.class);
    Worksheet1.find(12, a);

    // Empty List Exception
    exception.expect(IllegalArgumentException.class);
    Worksheet1.find(12, empty);

  }


  @Test
  // Positive?
  public void ex4Test() {

    List<Integer> a = new List<>(1, new List<>(2, new List<>(3, new List<>(4, new List<>()))));
    List<Integer> b = new List<>(-1, new List<>(2, new List<>(3, new List<>(4, new List<>()))));
    List<Integer> c = new List<>(1, new List<>(2, new List<>(3, new List<>(-4, new List<>()))));
    List<Integer> singleton = new List<>(10, new List<>());
    List<Integer> empty = new List<>();

    // All Positive
    assertEquals(true, Worksheet1.allPositive(a));
    // Edge Case 1st Negative
    assertEquals(false, Worksheet1.allPositive(b));
    // Edge Case Last Negative
    assertEquals(false, Worksheet1.allPositive(c));
    // Singleton
    assertEquals(true, Worksheet1.allPositive(singleton));
    // Empty
    assertEquals(true, Worksheet1.allPositive(empty));

  }

  @Test
  // return positives
  public void ex5Test() {

    List<Integer> empty = new List<>();
    List<Integer> singletonPos = new List<>(10, new List<>());
    List<Integer> singletonNeg = new List<>(-10, new List<>());
    List<Integer> a = new List<>(1, new List<>(2, new List<>(3, new List<>(-4, new List<>()))));
    List<Integer> aPos = new List<>(1, new List<>(2, new List<>(3, new List<>())));
    List<Integer> b = new List<>(-1, new List<>(2, new List<>(3, new List<>(4, new List<>()))));
    List<Integer> bPos = new List<>(2, new List<>(3, new List<>(4, new List<>())));

    // Empty List
    assertEquals(empty, Worksheet1.positives(empty));
    // Singleton Negative
    assertEquals(empty, Worksheet1.positives(singletonNeg));
    // Singleton Positive
    assertEquals(singletonPos, Worksheet1.positives(singletonPos));
    // Edge Case Last Negative
    assertEquals(aPos, Worksheet1.positives(a));
    // Edge Case First Negative
    assertEquals(bPos, Worksheet1.positives(b));

  }

  @Test
  // Sorted
  public void ex6Test() {

    List<Integer> empty = new List<>();
    List<Integer> singletonPos = new List<>(10, new List<>());
    List<Integer> a = new List<>(1, new List<>(2, new List<>(3, new List<>(4, new List<>()))));
    List<Integer> b = new List<>(1, new List<>(2, new List<>(3, new List<>(1, new List<>()))));
    List<Integer> c = new List<>(80, new List<>(2, new List<>(3, new List<>(4, new List<>()))));

    // Empty List
    assertEquals(true, Worksheet1.sorted(empty));
    // Singleton List
    assertEquals(true, Worksheet1.sorted(singletonPos));
    // Sorted List
    assertEquals(true, Worksheet1.sorted(a));
    // Edge Case Last Unsorted
    assertEquals(false, Worksheet1.sorted(b));
    // Edge Case First Unsorted
    assertEquals(false, Worksheet1.sorted(c));

  }

  @Test
  // Merging
  public void ex7Test() {

    List<Integer> empty = new List<>();
    List<Integer> singleton = new List<>(10, new List<>());
    List<Integer> singleton2 = new List<>(3, new List<>());
    List<Integer> singletonMer = new List<>(3, new List<>(10, new List<>()));
    List<Integer> a = new List<>(2, new List<>(5, new List<>(5, new List<>(8, new List<>()))));
    List<Integer> b = new List<>(5, new List<>(7, new List<>(8, new List<>(9, new List<>()))));
    List<Integer> ab = new List<>(2, new List<>(5, new List<>(5,
        new List<>(5, new List<>(7, new List<>(8, new List<>(8, new List<>(9, new List<>()))))))));

    // Empty List
    assertEquals(empty, Worksheet1.merge(empty, empty));
    // Singleton & Empty
    assertEquals(singleton, Worksheet1.merge(empty, singleton));
    // Two Singletons
    assertEquals(singletonMer, Worksheet1.merge(singleton2, singleton));
    // 2 Sorted Lists Merge
    assertEquals(ab, Worksheet1.merge(a, b));

  }

  @Test
  // Duplicates
  public void ex8Test() {

    List<Integer> empty = new List<>();
    List<Integer> singleton = new List<>(10, new List<>());
    List<Integer> a = new List<>(2, new List<>(5, new List<>(5,
        new List<>(5, new List<>(7, new List<>(8, new List<>(8, new List<>(9, new List<>()))))))));
    List<Integer> aDup = new List<>(2,
        new List<>(5, new List<>(7, new List<>(8, new List<>(9, new List<>())))));
    List<Integer> b = new List<>(5, new List<>(5, new List<>(8, new List<>(9, new List<>()))));
    List<Integer> bDup = new List<>(5, new List<>(8, new List<>(9, new List<>())));
    List<Integer> c = new List<>(5, new List<>(8, new List<>(9, new List<>(9, new List<>()))));
    List<Integer> cDup = new List<>(5, new List<>(8, new List<>(9, new List<>())));

    // Empty List
    assertEquals(empty, Worksheet1.removeDuplicates(empty));
    // Singleton List
    assertEquals(singleton, Worksheet1.removeDuplicates(singleton));
    // Center of List Duplicate
    assertEquals(aDup, Worksheet1.removeDuplicates(a));
    // Edge Case First Duplicate
    assertEquals(bDup, Worksheet1.removeDuplicates(b));
    // Edge Case Last Duplicate
    assertEquals(cDup, Worksheet1.removeDuplicates(c));

  }

}
