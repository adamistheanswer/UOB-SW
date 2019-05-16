import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Adam Robinson
 */

public class CustomerBaseTest {

  private final static double ACCURACY = 0.000001;

  private CustomerWithGoods alan,sarah,phillip,chris;

  @Before
  public void setUp(){

    ArrayList<Good> alansGoods = new ArrayList<>();
    ArrayList<Good> sarahGoods = new ArrayList<>();
    ArrayList<Good> phillipGoods = new ArrayList<>();
    ArrayList<Good> chrisGoods = new ArrayList<>();


    alan = new CustomerWithGoods("Alan Phillips ", "Hobson Road", "07700123456",
        alansGoods);
    sarah = new CustomerWithGoods("Sarah Smith ", "Hobson Road", "07700123456",
        sarahGoods);
    phillip = new CustomerWithGoods("Phillip Walker ", "Hobson Road", "07700123456",
        phillipGoods);
   chris = new CustomerWithGoods("Chris James ", "Playboy Mansion ",
        "07700129876", chrisGoods);

  }


  // Price Getter Test
  @Test
  public void test1() {

    Good good1 = new Good("Phone", 100);
    assertEquals(100, good1.getPrice(), ACCURACY);
  }

  // Good toString Test
  @Test
  public void test2() {
    Good good2 = new Good("Phone", 100);
    assertEquals("Phone £100", good2.toString());
  }

  // Buy good method test & number of goods test
  @Test
  public void test3() {
    Good item1 = new Good("Hat", 10);
    Good item2 = new Good("Shoes", 40);

    assertEquals(0, alan.numberOfGoods());
    alan.buy(item1);
    alan.buy(item1);
    alan.buy(item1);
    alan.buy(item1);
    alan.buy(item2);
    alan.buy(item2);
    alan.buy(item2);
    alan.buy(item2);
    assertEquals(8, alan.numberOfGoods());
  }

  // CustomerWithGoods toString Test (Extends toString from customer)
  @Test
  public void test4() {

    Good item1 = new Good("Hat", 10);
    Good item2 = new Good("Cat", 20);
    Good item3 = new Good("Mat", 5);
    Good item9 = new Good("Phone", 200);

    alan.buy(item1);
    alan.buy(item2);
    alan.buy(item3);
    alan.buy(item9);

    assertEquals(
        "\nCustomer: Alan Phillips \n"
            + "Address: Hobson Road\n"
            + "Telephone No: 07700123456\n"
            + "Previous Orders: [Hat £10, Cat £20, Mat £5, Phone £200]\n", alan.toString());
  }

  // Filtered Loyal Customer Test
  @Test
  public void test5() {
    Good item1 = new Good("Hat", 10);
    Good item2 = new Good("Shoes", 40);
    Good item3 = new Good("Mat", 5);
    Good item4 = new Good("Phone", 200);

    ArrayList<CustomerWithGoods> customers = new ArrayList<>();

    alan.buy(item1);
    alan.buy(item1);
    alan.buy(item1);
    alan.buy(item1);
    alan.buy(item2);
    alan.buy(item3);
    alan.buy(item2);
    alan.buy(item4);
    sarah.buy(item4);
    sarah.buy(item4);
    sarah.buy(item1);
    phillip.buy(item1);
    phillip.buy(item3);
    phillip.buy(item1);
    phillip.buy(item3);
    phillip.buy(item1);
    phillip.buy(item3);
    phillip.buy(item1);
    chris.buy(item4);
    chris.buy(item4);
    chris.buy(item4);

    CustomerBase base = new CustomerBase(customers);
    base.addCustomer(alan);
    base.addCustomer(sarah);
    base.addCustomer(phillip);
    base.addCustomer(chris);

    ArrayList<CustomerWithGoods>  expected = new ArrayList<>();
    expected.add(alan);
    expected.add(phillip);


    assertEquals(expected, base.filterLoyal());

  }

  // Filtered Valued Customer Test
  @Test
  public void test6() {
    Good item1 = new Good("Hat", 10);
    Good item2 = new Good("Shoes", 40);
    Good item3 = new Good("Mat", 5);
    Good item4 = new Good("Phone", 200);

    ArrayList<CustomerWithGoods> customers = new ArrayList<>();

    alan.buy(item1);
    alan.buy(item1);
    alan.buy(item1);
    alan.buy(item1);
    alan.buy(item2);
    alan.buy(item3);
    alan.buy(item2);
    alan.buy(item4);
    sarah.buy(item4);
    sarah.buy(item4);
    sarah.buy(item1);
    phillip.buy(item1);
    phillip.buy(item3);
    phillip.buy(item1);
    phillip.buy(item3);
    phillip.buy(item1);
    phillip.buy(item3);
    phillip.buy(item1);
    chris.buy(item4);
    chris.buy(item4);
    chris.buy(item4);

    CustomerBase base = new CustomerBase(customers);
    base.addCustomer(alan);
    base.addCustomer(sarah);
    base.addCustomer(phillip);
    base.addCustomer(chris);

    ArrayList<CustomerWithGoods>  expected = new ArrayList<>();
    expected.add(sarah);
    expected.add(chris);


    assertEquals(expected, base.filterValued());

  }

  // Get Value of Goods Method Test
  @Test
  public void test7() {
    Good item1 = new Good("Hat", 10);
    Good item2 = new Good("Shoes", 40);

    alan.buy(item1);
    alan.buy(item1);
    alan.buy(item1);
    alan.buy(item1);
    alan.buy(item2);
    alan.buy(item2);
    alan.buy(item2);
    alan.buy(item2);

    assertEquals(200, alan.valueOfGoods());
  }

}
