package Predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Adam Robinson This class contains the solutions for Worksheet 2-3 Excersise 1
 */

public class PredictivePrototype {

  /**
   * This method takes a word and returns a numeric T9 representation based on phone keypad inputs.
   * Words will be converted to lowercase and then they be are assigned their keypad numbers via a
   * step through ASCII code check and string concatenation using StringBuffer. The StringBuffer
   * class is used to represent characters that can be modified. Objects of type String are read
   * only and immutable. The significant performance difference between these two classes is that
   * StringBuffer is faster than String for performing simple concatenations though modifying it's
   * resultant object stored in the heap unlike using the string pool with the String class.
   *
   * @param word Input word of type string
   * @return Numeric T9 representation based on phone keypad inputs
   */

  public static String wordToSignature(String word) {
    word = word.toLowerCase();
    StringBuffer signature;
    signature = new StringBuffer();

    for (int i = 0; i < word.length(); i++) {
      int charASCII = word.charAt(i);

      if (charASCII >= 97 && charASCII <= 99) {          // abc
        signature.append(2);
      } else if (charASCII >= 100 && charASCII <= 102) { // def
        signature.append(3);
      } else if (charASCII >= 103 && charASCII <= 105) { // ghi
        signature.append(4);
      } else if (charASCII >= 106 && charASCII <= 108) { // jkl
        signature.append(5);
      } else if (charASCII >= 109 && charASCII <= 111) { // mno
        signature.append(6);
      } else if (charASCII >= 112 && charASCII <= 115) { // pqrs
        signature.append(7);
      } else if (charASCII >= 116 && charASCII <= 118) { // tuv
        signature.append(8);
      } else if (charASCII >= 119 && charASCII <= 122) { // wxyz
        signature.append(9);
      } else {
        signature.append(" ");
      }
    }
    return signature.toString();
  }

  /**
   * This method takes a given numeric T9 signature and returns a set of possible matching words
   * from a supplied dictionary. This method will have low efficiency due to the it's ineffective
   * use of memory. For every signature query this method needs to traverse the entire words.txt
   * file. If the words were stored in a collection in memory then this data would be more
   * manageable and it would be much faster for large query volumes. The file would need to be
   * duplicated into memory once there its elements could be searched and traversed much more
   * efficiently.
   *
   * @param signature T9 keypad signature
   * @return set of possible words within supplied dictionary
   */


  public static Set<String> signatureToWords(String signature) {

    Set<String> stringHashSet = new TreeSet<>();
    File words = new File("src/Predictive/words.txt");
    Scanner wordsScanner = null;

    try {
      wordsScanner = new Scanner(words);
    } catch (FileNotFoundException e) {
      System.out.println("No File Found!");
    }

    while (wordsScanner.hasNextLine()) {
      String nextWord = wordsScanner.nextLine();
      nextWord = nextWord.toLowerCase();
      if (signature.equals(wordToSignature(nextWord)) && isValidWord(nextWord)) {
        stringHashSet.add(nextWord);
      }
    }
    return stringHashSet;
  }

  /**
   * This checks if the input word is value. Valid words contain only letters.
   *
   * @param word Input word
   * @return True if Valid
   */

  public static boolean isValidWord(String word) {
    word = word.toLowerCase();
    if (word.length() == 0) {
      return false;
    } else {
      for (int i = 0; i < word.length(); i++) {
        int charUni = word.charAt(i);
        if (charUni < 97 || charUni > 122) {
          return false;
        }
      }
      return true;
    }
  }

//  public static void main(String[] args) {
//    System.out.println(isValidWord("Hello"));
//    System.out.println(wordToSignature("HE%LLO W0r|D"));
//    System.out.println(signatureToWords("2"));
//    System.out.println(signatureToWords("3"));
//    System.out.println(signatureToWords("4"));
//    System.out.println(signatureToWords("5"));
//    System.out.println(signatureToWords("6"));
//    System.out.println(signatureToWords("7"));
//    System.out.println(signatureToWords("8"));
//    System.out.println(signatureToWords("9"));
//    System.out.println(signatureToWords("329"));
//  }
}

