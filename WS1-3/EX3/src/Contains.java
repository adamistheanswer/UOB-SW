import java.util.ArrayList;
public class Contains {

  public static ArrayList<Integer> allIntegersWith(int from, int to, int containedDigit) {

    int i, number;
    ArrayList<Integer> containsList = new ArrayList<>();

    for (i = from; i < to; i++) {
      number = i;
      String numberAsString = Integer.toString(number);
      String containedDigitString = Integer.toString(containedDigit);
      if (numberAsString.contains(containedDigitString))
        containsList.add(i);
    }
    return containsList;
  }
}