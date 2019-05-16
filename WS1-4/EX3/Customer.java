/**
 * Customer is a class for the representation of car information in the form "name, totalMoneySpent,
 * address"
 *
 * @author Adam Robinson
 * @version 2017-11-10
 */

public class Customer implements Sortable {

  private String name;
  private double totalMoneySpent;
  private String address;

  /**
   * This constructor creates customer information from three parts: name, totalMoneySpent, and address.
   * Which are a  string, double and string, respectively.
   *
   * @param name The max speed of the car
   * @param totalMoneySpent The Number of the car
   * @param address The make of the car
   */

  public Customer(String name, double totalMoneySpent, String address) {
    this.name = name;
    this.totalMoneySpent = totalMoneySpent;
    this.address = address;
  }

  /**
   * @return The total money spent by a customer
   */

  public double compareValue() {
    return totalMoneySpent;
  }

  /**
   * @return The print format of the customer information "Customer name: [name] Total money spent:
   * [totalMoneySpent] Address: [address]"
   */

  @Override
  public String toString() {
    return "Customer name: " + name + " Total money spent: " + totalMoneySpent + " Address: "
        + address;
  }
}
