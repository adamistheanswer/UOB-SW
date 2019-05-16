package Predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Adam Robinson This class contains the solutions for Worksheet 2-3 Excersise 2
 */

public class ListDictionary implements Dictionary {

  private ArrayList<WordSig> wordSigArrayList;

  /**
   * Constructor for the class ListDictionary that takes a String path which is the directory to a
   * dictionary. Constructor initialises ListDictionary object by reading and storing dictionary in
   * an ArrayList. Each entry in the ArrayList is a pair, consisting of the word that has been read
   * in and its signature. Each pain is represented as an Object of class WordSig
   *
   * @param path dictionary directory
   */

  public ListDictionary(String path) {

    wordSigArrayList = new ArrayList<>();

    File words = new File(path);
    Scanner wordsScanner = null;

    try {
      wordsScanner = new Scanner(words);
    } catch (FileNotFoundException e) {
      System.out.println("No File Found!");
    }

    while (wordsScanner.hasNextLine()) {
      String nextWord = wordsScanner.nextLine();
      nextWord = nextWord.toLowerCase();
      if (isValidWord(nextWord)) {
        wordSigArrayList.add(new WordSig(nextWord, wordToSignature(nextWord)));
      }
    }
    Collections.sort(wordSigArrayList);
  }

  /**
   * This method takes a word and returns a numeric T9 representation based on phone keypad inputs.
   * Words will be converted to lowercase and then they be are assigned their keypad numbers via a
   * step through ASCII code check and string concatenation using StringBuffer.
   *
   * @param word Input word of type string
   * @return Numeric T9 representation based on phone keypad inputs
   */

  public static String wordToSignature(String word) {
    word = word.toLowerCase();
    StringBuffer signature;
    signature = new StringBuffer();

    for (int i = 0; i < word.length(); i++) {
      int charUnicode = word.charAt(i);

      if (charUnicode >= 97 && charUnicode <= 99) {          // abc
        signature.append(2);
      } else if (charUnicode >= 100 && charUnicode <= 102) { // def
        signature.append(3);
      } else if (charUnicode >= 103 && charUnicode <= 105) { // ghi
        signature.append(4);
      } else if (charUnicode >= 106 && charUnicode <= 108) { // jkl
        signature.append(5);
      } else if (charUnicode >= 109 && charUnicode <= 111) { // mno
        signature.append(6);
      } else if (charUnicode >= 112 && charUnicode <= 115) { // pqrs
        signature.append(7);
      } else if (charUnicode >= 116 && charUnicode <= 118) { // tuv
        signature.append(8);
      } else if (charUnicode >= 119 && charUnicode <= 122) { // wxyz
        signature.append(9);
      } else {
        signature.append(" ");
      }
    }
    return signature.toString();
  }

  /**
   * This method is a more efficient in its word look up to class PredictivePrototype due to it use
   * of an ArrayList (wordSigArrayList) containing words. Method uses binary search to find an
   * element in wordSigArrayList where its signature matches the one provided as the argument. After
   * determining the index of an element that is a match for the signature, this is used as an index
   * to radiate from. "next" or "previous" elements in the set are also checked adding each further
   * match to the suggested TreeSet of String.
   *
   * @param signature signature value the method returns the corresponding words for
   * @return TreeSet of matching words to the signature provided as an argument
   */

  public Set<String> signatureToWords(String signature) {

    TreeSet<String> suggested = new TreeSet<>();

    int i = Collections.binarySearch(wordSigArrayList, new WordSig("", signature));

    if (i < 0) {
      return suggested;
    } else {

      int next = i;
      int previous = i;

      while (wordSigArrayList.get(next).getSignature().equals(signature)) {
        suggested.add(wordSigArrayList.get(next).getWords());
        next++;
        if (wordSigArrayList.size() == next) {
          break;
        }
      }

      while (wordSigArrayList.get(previous).getSignature().equals(signature)) {
        suggested.add(wordSigArrayList.get(previous).getWords());
        previous--;
        if (previous < 0) {
          break;
        }
      }
    }
    return suggested;
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

//  @Override
//  public String toString() {
//    return "Dic" + wordSigArrayList;
//  }
//
//  public static void main(String[] args) {
//    ListDictionary listDictionary = new ListDictionary("src/Predictive/words.txt");
//    System.out.println(listDictionary.signatureToWords("2"));
//    System.out.println(listDictionary.signatureToWords("3"));
//    System.out.println(listDictionary.signatureToWords("4"));
//    System.out.println(listDictionary.signatureToWords("5"));
//    System.out.println(listDictionary.signatureToWords("6"));
//    System.out.println(listDictionary.signatureToWords("7"));
//    System.out.println(listDictionary.signatureToWords("8"));
//    System.out.println(listDictionary.signatureToWords("9"));
//    System.out.println(listDictionary.toString());
//    System.out.println(wordToSignature("pass"));
//  }
}
