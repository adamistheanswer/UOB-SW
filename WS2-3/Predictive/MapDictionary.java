package Predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Adam Robinson This class contains the solutions for Worksheet 2-3 Excersise 2
 */

public class MapDictionary implements Dictionary {

  private Map<String, TreeSet<String>> mapDictionary;

  /**
   * Constructor for the class MapDictionary that takes a String path which is the directory to a
   * dictionary. Constructor initialises MapDictionary object by reading and storing dictionary in
   * an Hash Map. Each entry in the hash map is comprised of a key of string (Signature) and a Tree
   * set of values (Words)
   *
   * @param path dictionary directory
   */

  public MapDictionary(String path) {

    mapDictionary = new HashMap<>();

    try {

      File file = new File(path);
      Scanner sc = new Scanner(file);
      while (sc.hasNextLine()) {

        String word = sc.nextLine().toLowerCase();
        String signature = wordToSignature(word);

        if (mapDictionary.containsKey(signature)) {

          TreeSet<String> wordsFromDict = mapDictionary.get(signature);

          if (!wordsFromDict.contains(word)) {
            if (isValidWord(word)) {
              wordsFromDict.add(word);
            }
          }
          mapDictionary.put(signature, wordsFromDict);

        } else {
          TreeSet<String> wordsFromDict = new TreeSet<>();
          if (isValidWord(word)) {
            wordsFromDict.add(word);
          }
          mapDictionary.put(signature, wordsFromDict);
        }
      }

    } catch (FileNotFoundException e) {
      System.out.println("No File Found!");
    }
  }


  /**
   * This checks if the input word is value. Valid words contain only letters.
   *
   * @param word Input word
   * @return True if Valid
   */

  private static boolean isValidWord(String word) {
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

  /**
   * This method takes a word and returns a numeric T9 representation based on phone keypad inputs.
   * Words will be converted to lowercase and then they be are assigned their keypad numbers via a
   * step through ASCII code check and string concatenation using StringBuffer.
   *
   * @param word Input word of type string
   * @return Numeric T9 representation based on phone keypad inputs
   */

  private static String wordToSignature(String word) {
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
   * Using the signature as a key to the hash map the corresponding tree set of matching words is
   * returned
   *
   * @param signature T9 numeric signature of the word
   * @return Tree set of matching words
   */

  public Set<String> signatureToWords(String signature) {
    return mapDictionary.get(signature);
  }

//  @Override
//  public String toString() {
//    return "Dict" + mapDictionary;
//  }

//  public static void main(String[] args) {
//    Dictionary mp = new MapDictionary("src/Predictive/words.txt");
//    System.out.println(mp);
//    System.out.println(mp.signatureToWords("9999999999999"));
//    System.out.println(isValidWord("Hello"));
//    System.out.println(mp.signatureToWords("2"));
//    System.out.println(mp.signatureToWords("3"));
//    System.out.println(mp.signatureToWords("4"));
//    System.out.println(mp.signatureToWords("5"));
//    System.out.println(mp.signatureToWords("6"));
//    System.out.println(mp.signatureToWords("7"));
//    System.out.println(mp.signatureToWords("8"));
//    System.out.println(mp.signatureToWords("9"));
//    System.out.println(mp.signatureToWords("329999999999999999999"));
//  }

}
