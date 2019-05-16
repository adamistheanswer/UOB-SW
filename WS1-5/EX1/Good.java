/**
 * Good is a class for representing a shop item. Information is represented in the form
 * "name" and "price"
 *
 * @author Adam Robinson
 * @version 2017-11-22
 */

public class Good {

  private String name;
  private int price;

  /**
   * This constructor creates goof information from two parts: name and price.
   * Which are Sting and int respectively.
   *
   * @param name The name of a good
   * @param price The price of a good
   */

  public Good(String name, int price) {
    this.name = name;
    this.price = price;
  }

  /**
   * Getter for the price of a good
   * @return price of the item
   */

  public int getPrice() {
    return price;
  }

  /**
   * @return The print format of good information "[Name]  £[Price]"
   */

  @Override
  public String toString() {
    return  name + " " + "£" +price;
  }
}
