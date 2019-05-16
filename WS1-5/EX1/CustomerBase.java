import java.util.ArrayList;

  /**
    * CustomerBase is a class for holding customers and their purchase information. Information is represented in the form
    * of an ArrayList containing objects of type CustomerWithGoods
    *
    * @author Adam Robinson
    * @version 2017-11-22
    */

public class CustomerBase {

  private ArrayList<CustomerWithGoods> allCustomers;

    /**
     * This constructor creates customer base information from an ArrayList containing objects of type CutomerWithGoods
     * @param allCustomers ArrayList containing objects of type CustomerWithGoods
     */

  public CustomerBase(ArrayList<CustomerWithGoods> allCustomers) {
    this.allCustomers = allCustomers;
  }

  // Adds CustomerWithGoods objects to CustomerBase ArrayList
  public void addCustomer(CustomerWithGoods customer) {
    allCustomers.add(customer);
  }

    /**
     * Filters customers by loyalty.
     * @return Customers who purchase more products than the customer base average
     */

  public ArrayList<CustomerWithGoods> filterLoyal() {
    ArrayList<CustomerWithGoods> loyalCustomers = new ArrayList<CustomerWithGoods>();
    int orders = 0;
    for (CustomerWithGoods el : allCustomers) {
      orders += el.numberOfGoods();
    }

    orders = orders / allCustomers.size();

    for (CustomerWithGoods el : allCustomers) {
      if (el.numberOfGoods() > orders) {
        loyalCustomers.add(el);
      }
    }
    return loyalCustomers;
  }


    /**
     * Filters customers by Valued.
     * @return Customers who spent more on goods than the customer base average
     */

  public ArrayList<CustomerWithGoods> filterValued() {
    ArrayList<CustomerWithGoods> highValue = new ArrayList<CustomerWithGoods>();
    int value = 0;
    for (CustomerWithGoods el : allCustomers) {
      value += el.valueOfGoods();
    }

    value = value / allCustomers.size();

    for (CustomerWithGoods el : allCustomers) {
      if (el.valueOfGoods() > value) {
        highValue.add(el);
      }
    }
    return highValue;
  }
}
