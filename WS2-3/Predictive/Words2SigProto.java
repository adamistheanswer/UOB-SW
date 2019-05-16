package Predictive;

/**
 * @author Adam Robinson This class contains command-line program for Worksheet 2-3
 */

public class Words2SigProto {

  /**
   * command-line program
   *
   * accepts a list of strings and calls wordToSignature, making the appropriate conversion.
   *
   * @param args Input words
   */

  public static void main(String[] args) {
    for (String word : args) {
      System.out.println(word + " - " + PredictivePrototype.wordToSignature(word));
    }
  }
}
