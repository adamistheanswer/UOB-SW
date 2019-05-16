package Predictive;

/**
 * @author Adam Robinson This class contains command-line program for Worksheet 2-3
 */

public class Sigs2WordsTree {

  /**
   * command-line program
   *
   * accepts a list of strings and calls signatureToWords, making the appropriate conversion.
   *
   * @param args numeric signatures
   */

  public static void main(String[] args) {

    TreeDictionary dictionary = new TreeDictionary("src/Predictive/words.txt");

    for (String sig : args) {
      System.out.println(sig + " - " + dictionary.signatureToWords(sig));

    }
  }

  //  TERMINAL SPEED TEST
//
//  Adams-MacBook:src AdamMBA$ time java Sigs2WordsTree 43556 96753 88726 263333 78277 386 227 3278 2 3 4 5 6 7 8 9
//
//      43556 - [gellm, helln, hellm, gekko, hello]
//      96753 - [workd, worle, world, workf, worke, yorke]
//      88726 - [tupam, turco, tupan, turbo, turan, tusco]
//      263333 - [codded, codefe, coffee, coeffe, andeee]
//      78277 - [subpr, starr, stass, stapp, stars, subss, quars, quarr, quass, quasq, starq, subsq, subsp]
//      386 - [eto, ftn, dvm, dun, eum, dvo, evn, dtm, dum, fun, euo, etn, evo, duo, fum, eun]
//      227 - [acq, bcp, acp, bap, acs, aaq, bcr, ccp, acr, aap, caq, bar, ccs, aas, ccr, cap, aar, bcs, cas, car, bas, abp, abr, abq, bbs, cbr, abs, cbs]
//      3278 - [ecpt, ecru, daru, earv, darv, dast, faqu, ecst, farv, eart, dart, faru, fart, east, fast]
//      2 - [a, b, c]
//      3 - [d, e, f]
//      4 - [g, h, i]
//      5 - [j, k, l]
//      6 - [m, n, o]
//      7 - [p, q, r, s]
//      8 - [t, u, v]
//      9 - [w, x, y, z]
//
//  real	0m4.903s  <<<----  Elapsed real (wall clock) time used by the process, in seconds.
//  user	0m4.438s  <<<----  Total number of CPU-seconds that the process used directly (in user mode), in seconds.
//  sys	  0m1.372s           Total number of CPU-seconds used by the system on behalf of the process (in kernel mode), in seconds.
}
