package Predictive;

/**
 * @author Adam Robinson This class contains command-line program for Worksheet 2-3
 */

public class WordSig implements Comparable<WordSig> {

  private String words;
  private String signature;

  /**
   * Getter for dictionary words
   *
   * @return words
   */

  public String getWords() {
    return words;
  }

  /**
   * Getter for words numerical signatures
   *
   * @return Numerical signature
   */

  public String getSignature() {
    return signature;
  }

  /**
   * @param words Word from input dictionary
   * @param signature Words conversion into numeric T9 Signature
   */

  public WordSig(String words, String signature) {
    this.words = words;
    this.signature = signature;
  }

  /**
   * Compare to override for comparison between two words signatures
   *
   * @param ws Comparision word signature
   * @return -1 negative int if this less than that 0 if this == that +1 positive int if this
   * greater than that
   */

  @Override
  public int compareTo(WordSig ws) {
    return this.signature.compareTo(ws.signature);
  }

  @Override
  public String toString() {
    return words + " " + signature + "\n";
  }
}



