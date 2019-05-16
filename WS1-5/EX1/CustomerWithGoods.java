import java.util.ArrayList;

/**
 * CustomerWithGoods is a subclass of customer. CustomerWithGoods extends customer information in
 * the form "CustomerName, address and telephoneNumber" while also defining "goods"
 *
 * @author Adam Robinson
 * @version 2017-11-22
 */

public class CustomerWithGoods extends Customer {

  private ArrayList<Good> goods;

  /**
   * This constructor creates CustomerWithGoods information from four parts: customerName, address,
   * telephoneNumber and goods. Which are a String, a String, a String, and an ArrayList for objects
   * of type Good respectively.
   *
   * @param customerName Name of the customer
   * @param address Address of the customer
   * @param telephoneNumber Telephone number of the customer
   * @param goods Goods purchased by the customer
   */

  public CustomerWithGoods(String customerName, String address, String telephoneNumber,
      ArrayList<Good> goods) {
    super(customerName, address, telephoneNumber);
    this.goods = goods;
  }

  // Adds object of type good to CustomerWithGoods good ArrayList
  public void buy(Good good) {
    goods.add(good);
  }

  /**
   * Calculates total value of goods attributed to a customer
   * @return Total value of customers purchased goods
   */

  public int valueOfGoods() {
    int value = 0;
    for (Good el : goods) {
      value += el.getPrice();
    }
    return value;
  }

  /**
   * @return Number of goods purchased by a customer
   */

  public int numberOfGoods() {
    return goods.size();
  }

  /**
   * @return The print format of CustomerWithGoods information
   * "Customer: [customerName]
   *  Address:  [address]
   *  Telephone No: [telephoneNumber]
   *  Previous Orders: [goods]"
   */

  @Override
  public String toString() {
    return super.toString() + "Previous Orders: " + goods + "\n";
  }
}
