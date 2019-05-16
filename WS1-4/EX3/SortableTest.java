import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Adam Robinson
 */
public class SortableTest {

  private Sortable sort1, sort2, sort3, sort4, sort5, sort6;

  public static final double ACCURACY = 1e-6;

  //Min & Max Car
  @Test
  public void test1() {

    sort1 = new Car(Double.MAX_VALUE, "AGR 799", "Lexus");
    sort2 = new Car(Double.MIN_VALUE, "AGR 798", "Austin");

    Sortable[] a = {sort1, sort2};

    Sortable[] expected = {sort2, sort1};
    Sortable[] actual = Sorting.quickSort(a);

    assertArrayEquals(expected, actual);
  }

  //Min & Max Customer
  @Test
  public void test2() {

    sort4 = new Customer("Fred", Double.MIN_VALUE, "666 Ripper Street");
    sort5 = new Customer("Stevie", Double.MAX_VALUE, "101 Adams Road");

    Sortable[] a = {sort4, sort5};

    Sortable[] expected = {sort4, sort5};
    Sortable[] actual = Sorting.quickSort(a);

    assertArrayEquals(expected, actual);
  }

  // Customer toString test
  @Test
  public void test3() {

    sort4 = new Customer("Adam Robinson", 1000000, "34 Hobson Road");

    String expected = "Customer name: Adam Robinson Total money spent: 1000000.0 Address: 34 Hobson Road";
    String actual = sort4.toString();

    assertEquals(expected, actual);
  }

  // Car toString test
  @Test
  public void test4() {

    sort3 = new Car(88.0, "MC F1Y", "Delorean");

    String expected = "car max speed: 88.0 car number: MC F1Y car make: Delorean";
    String actual = sort3.toString();

    assertEquals(expected, actual);
  }

  // Negative test
  @Test
  public void test5() {

    sort1 = new Car(-100.0, "FRTT BUS", "Lamborghini");
    sort2 = new Car(-150.0, "YMCA LOL", "Gumpert");
    sort3 = new Car(-78.0, "FAIL P45", "Ariel");
    sort4 = new Customer("Leonardo", -100.0, "Sewer 1");
    sort5 = new Customer("Donatello", -150.50, "Sewer 2");
    sort6 = new Customer("Michelangelo", -60.0, "Sewer 3");

    Sortable[] a = {sort1, sort2, sort3, sort4, sort5, sort6};

    Sortable[] expected = {sort5, sort2, sort4, sort1, sort3, sort6};
    Sortable[] actual = Sorting.quickSort(a);

    assertArrayEquals(expected, actual);
  }

  // Min and Max compareValue car Method Test
  @Test
  public void test6() {

    sort1 = new Car(Double.MIN_VALUE, "FRTT BUS", "Lamborghini");
    sort2 = new Car(Double.MAX_VALUE, "YMCA LOL", "Gumpert");

    double expected1 = 4.9E-324;
    double actual1 = sort1.compareValue();
    assertEquals(expected1, actual1, ACCURACY);

    double expected2 = 1.7976931348623157E308;
    double actual2 = sort2.compareValue();
    assertEquals(expected2, actual2, ACCURACY);
  }

  // Min and Max compareValue Customer Method Test
  @Test
  public void test7() {

    sort4 = new Customer("Leonardo", Double.MIN_VALUE, "Sewer 1");
    sort5 = new Customer("Donatello", Double.MAX_VALUE, "Sewer 2");

    double expected1 = 4.9E-324;
    double actual1 = sort4.compareValue();
    assertEquals(expected1, actual1, ACCURACY);

    double expected2 = 1.7976931348623157E308;
    double actual2 = sort5.compareValue();
    assertEquals(expected2, actual2, ACCURACY);
  }
}

