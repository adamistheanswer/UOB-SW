package Predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Adam Robinson This class contains the solutions for Worksheet 2-3 Excersise 2
 */

public class TreeDictionary implements Dictionary {

  private TreeDictionary[] treeDictionaries = new TreeDictionary[8];
  private Set<String> words = new HashSet<>();

  /**
   * No argument constructor creates new object of TreeDictionary with instances of treeDictionaries
   * array [T9 Keypad] and words HashSet [words at node store] initialised.
   */

  public TreeDictionary() {
  }

  /**
   * Constructor for the class TreeDictionary that takes a String path which is the directory to a
   * dictionary. Constructor initialises TreeDictionary object by reading and storing dictionary
   * into a custom trie data structure storing a list of potential words at every node. When
   * signature obtained we use first number to see start point of word in trie based on branch
   * between [0-7]. This is node 2 in trie structure. At that array index the Tree structure is
   * recursively built starting at that node
   *
   * @param path the path to the dictionary
   */


  public TreeDictionary(String path) {

    Arrays.setAll(treeDictionaries, i -> new TreeDictionary());

    try {
      File file = new File(path);
      Scanner sc = new Scanner(file);
      while (sc.hasNextLine()) {
        String word = sc.nextLine().toLowerCase();
        if (isValidWord(word)) {
          String signature = wordToSignature(word);
          int T9 = (int) signature.charAt(0) - 48;
          treeDictionaries[T9 - 2].populate(word, signature, 1);
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println("No File Found!");
    }
  }

  /**
   * Helper method Populates trie by creating new TreeDictionary objects (containing array and hash
   * set) at corresponding array indexes (based on sig char conversion to T9) while also adding the
   * words to the set at respective nodes.
   *
   * @param word word to be inserted into tree structure
   * @param signature numerical T9 word signature
   * @param character the character under inspection
   */


  public void populate(String word, String signature, int character) {
    words.add(word);
    if (signature.length() > character) {
      int T9 = signature.charAt(character) - 48;
      character++;
      if (treeDictionaries[T9 - 2] == null) {
        treeDictionaries[T9 - 2] = new TreeDictionary();
      }
      treeDictionaries[T9 - 2].populate(word, signature, character);
    }
  }

  /**
   * Returns a Hash set of prefixes for the input numeric signature Partial words returned that
   * match the length of signature Possible hits derived from traversedNodes Hash set
   *
   * @param signature numerical T9 word signature
   * @return returns T9 text predictions
   */

  public Set<String> signatureToWords(String signature) {
    Set<String> predictive = new HashSet<>();
    try {
      for (String word : traverseNodes(signature)) {
        predictive.add(word.substring(0, signature.length()));
      }
    } catch (NullPointerException e) {
      return predictive;
    }
    return predictive;
  }

  /**
   * Helper method traverses the custom trie data structure and returns a set of all possible hits
   * that could be at that node, via recursive signature navigation. Each character of sig is one
   * node value of the trie
   *
   * @param signature numerical T9 word signature
   * @return Hash set of all possible words in signature pattern node
   */

  private Set<String> traverseNodes(String signature) {

    if (!signature.isEmpty()) {
      int T9 = (int) signature.charAt(0) - 48;
      return treeDictionaries[T9 - 2].traverseNodes(signature.substring(1));
    } else {
      return words;
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

  public static void main(String[] args) {
    Dictionary test = new TreeDictionary("src/Predictive/words.txt");
    System.out.println(test.signatureToWords("2"));
  }


}