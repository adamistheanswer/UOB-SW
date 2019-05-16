import java.util.Arrays;

/**
 * Sieve is a class containing an efficient Eratosthenes method to determine all prime numbers up to
 * a maximum n
 *
 * @author Adam Robinson
 * @version 2017-11-23
 */

public class Sieve {

  /**
   * Eratosthenes of Cyrene sieve method for finding all prime numbers up to a maximum n
   *
   * @param max Maximum range to find prime numbers up to (included if prime)
   * @return Array containing all prime numbers below max (included max if prime)
   */

  public static int[] sieve(int max) {

    // Makes new boolean array with the size of max
    boolean[] sieve = new boolean[max + 1];

    for (int j = 0; j < sieve.length; j++) {
      // All positions above 2 are set to true
      if (j >= 2) {
        sieve[j] = true;
      }
    }

    // for loop works to maximum iterations needed of max squared
    for (int i = 0; i <= Math.sqrt(max); i++) {
      // start with a true value and look ahead to see if indexes can be divided by
      // counter j. If they are divisible to zero then they are not a prime number
      // set to false
      if (sieve[i] == true) {

        for (int j = i + 1; j < sieve.length; j++) {
          if (j % i == 0) {
            sieve[j] = false;
          }
        }

        // COMMENTED OUT FOR USE IN VIVA TO DISPLAY TRUE FALSE AS TEXT

        //   System.out.printf("%d%s", i, "-> ");
        //   for (boolean n : sieve) {
        //     System.out.printf("%5b  ", n);
        //   }
        //   System.out.println();
      }
    }

    // counter to see how many trues in array
    // will become length of new array
    int counter = 0;
    for (int i = 0; i < sieve.length; i++) {
      if (sieve[i] == true) {
        counter++;
      }
    }

    // if true add that index of true boolean into the new array. This is also the value
    int[] outputArray = new int[counter];

    int i = 0;

    while (i < outputArray.length) {
      for (int j = 0; j < sieve.length; j++) {
        if (sieve[j] == true) {
          outputArray[i] = j;

          i++;
        }
      }
    }
    return outputArray;
  }

  public static void main(String[] args) {

    System.out.println(Arrays.toString(sieve(100)));
  }

}