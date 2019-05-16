import java.util.ArrayList;

public class CustomerBaseMain {

  public static void main(String[] args) {

    Good item1 = new Good("Hat", 10);
    Good item2 = new Good("Cat", 20);
    Good item3 = new Good("Mat", 5);
    Good item4 = new Good("Bat", 10);
    Good item5 = new Good("Shoes", 40);
    Good item6 = new Good("Glue", 1);
    Good item7 = new Good("Beer", 3);
    Good item8 = new Good("Shirt", 30);
    Good item9 = new Good("Phone", 200);

    ArrayList<Good> alansGoods = new ArrayList<Good>();
    ArrayList<Good> bertsGoods = new ArrayList<Good>();
    ArrayList<Good> chrisGoods = new ArrayList<Good>();
    ArrayList<Good> sarahGoods = new ArrayList<Good>();


    CustomerWithGoods alan = new CustomerWithGoods("Alan Phillips ", "Hobson Road", "07700123456",
        alansGoods);
    System.out.println(alan);
    alan.buy(item1);
    alan.buy(item2);
    alan.buy(item3);
    alan.buy(item9);
    System.out.println(alan);
    System.out.println("Total purchases: " + alan.numberOfGoods());
    System.out.println("Total Value of Goods £" + alan.valueOfGoods());

    CustomerWithGoods bert = new CustomerWithGoods("Bert Reynolds ", "Cholomondely Rise",
        "07700123123", bertsGoods);
    System.out.println("\n" + bert);
    bert.buy(item9);
    bert.buy(item9);
    System.out.println(bert);
    System.out.println("Total purchases: " + bert.numberOfGoods());
    System.out.println("Total Value of Goods £" + bert.valueOfGoods());

    CustomerWithGoods chris = new CustomerWithGoods("Chris James ", "Playboy Mansion ",
        "07700129876", chrisGoods);
    System.out.println("\n" + chris);
    chris.buy(item3);
    chris.buy(item4);
    chris.buy(item5);
    chris.buy(item6);
    chris.buy(item7);
    chris.buy(item8);
    System.out.println(chris);
    System.out.println("Total purchases: " + chris.numberOfGoods());
    System.out.println("Total Value of Goods £" + chris.valueOfGoods());

    CustomerWithGoods sarah = new CustomerWithGoods("Sarah Smith ", "Hookey Street ",
        "07700111333", sarahGoods);
    System.out.println("\n" + sarah);
    sarah.buy(item2);
    sarah.buy(item2);
    sarah.buy(item2);
    sarah.buy(item2);
    sarah.buy(item2);
    sarah.buy(item2);
    System.out.println(sarah);
    System.out.println("Total purchases: " + sarah.numberOfGoods());
    System.out.println("Total Value of Goods £" + sarah.valueOfGoods());


    ArrayList<CustomerWithGoods> customers = new ArrayList<>();
    customers.add(alan);
    customers.add(bert);
    customers.add(chris);
    customers.add(sarah);

    CustomerBase base = new CustomerBase(customers);

    System.out.println("\n\n" + "Valued Customers");
    System.out.println(base.filterValued());
   double totalVal = (alan.valueOfGoods() + bert.valueOfGoods()+chris.valueOfGoods()+sarah.valueOfGoods());
   double averageVal = totalVal / 4;
    System.out.println("\nThese customers spent more than the average of: £"  + averageVal);


    System.out.println("\n\n" + "Loyal Customers");
    System.out.println(base.filterLoyal());
    double totalGoods = (alan.numberOfGoods() + bert.numberOfGoods() +chris.numberOfGoods() +sarah.numberOfGoods());
    double averageGoods = totalGoods / 4;
    System.out.println("\nThese customers bought more than the average of: "  + averageGoods);
  }
}
