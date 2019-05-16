package Predictive;

/**
 * @author Adam Robinson This class contains command-line program for Worksheet 2-3
 */

public class Sigs2WordsList {

  /**
   * command-line program
   *
   * accepts a list of strings and calls signatureToWords, making the appropriate conversion.
   *
   * @param args numeric signatures
   */

  public static void main(String[] args) {

    ListDictionary dictionary = new ListDictionary("src/Predictive/words.txt");

    for (String sig : args) {
      System.out.println(sig + " - " + dictionary.signatureToWords(sig));

    }
  }

//  TERMINAL SPEED TEST
//
//  Adams-MacBook-Air:src AdamMBA$ time java Sigs2WordsList 43556 96753 88726 263333 78277 386 227 3278 2 3 4 5 6 7 8 9
//
//      43556 - [gekko, hello]
//      96753 - [world, yorke]
//      88726 - [turbo, turco]
//      263333 - [andeee, codded, coffee]
//      78277 - [quass, starr, stars]
//      386 - [dum, dun, duo, dvm, etn, eto, fum, fun]
//      227 - [aap, aar, aas, abp, abr, abs, acp, acs, bap, bar, bas, bbs, bcp, bcr, bcs, cap, car, cas, cbr, cbs, ccp, ccr, ccs]
//      3278 - [dart, daru, east, ecpt, ecru, fart, fast]
//      2 - [a, b, c]
//      3 - [d, e, f]
//      4 - [g, h, i]
//      5 - [j, k, l]
//      6 - [m, n, o]
//      7 - [p, q, r, s]
//      8 - [t, u, v]
//      9 - [w, x, y, z]
//
//  real	0m2.887s  <<<----  Elapsed real (wall clock) time used by the process, in seconds.
//  user	0m3.668s  <<<----  Total number of CPU-seconds that the process used directly (in user mode), in seconds.
//  sys	  0m0.473s           Total number of CPU-seconds used by the system on behalf of the process (in kernel mode), in seconds.

}

