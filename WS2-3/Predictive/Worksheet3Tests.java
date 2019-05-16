package Predictive;

import static junit.framework.TestCase.assertEquals;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import org.junit.Test;

/**
 * JUnit tests for Worksheet 2-3
 *
 * @author Adam Robinson
 */

public class Worksheet3Tests {

  // Exercise 1

  @Test
  public void predProtoW2s_empty() {
    String word = "";
    String expected = "";
    String actual = PredictivePrototype.wordToSignature(word);
    assertEquals(expected, actual);
  }

  @Test
  public void predProtoW2s_space() {
    String word = " ";
    String expected = " ";
    String actual = PredictivePrototype.wordToSignature(word);
    assertEquals(expected, actual);
  }

  @Test
  public void predProtoW2s_single() {
    String word = "Z";
    String expected = "9";
    String actual = PredictivePrototype.wordToSignature(word);
    assertEquals(expected, actual);
  }

  @Test
  public void predProtoW2s_HelloCaps() {
    String word = "HEllo";
    String expected = "43556";
    String actual = PredictivePrototype.wordToSignature(word);
    assertEquals(expected, actual);
  }

  @Test
  public void predProtoW2s_AllCharType() {
    String signature = "hE1l()wOr1d";
    String expected = "43 5  967 3";
    String actual = PredictivePrototype.wordToSignature(signature);
    assertEquals(expected, actual);
  }

  @Test
  public void predProtoS2w_empty() {
    String signature = "";
    HashSet<String> expected = new HashSet<>();
    Set<String> actual = PredictivePrototype.signatureToWords(signature);
    assertEquals(expected, actual);
  }

  @Test
  public void predProtoS2w_space() {
    String word = " ";
    HashSet<String> expected = new HashSet<>();
    Set<String> actual = PredictivePrototype.signatureToWords(word);
    assertEquals(expected, actual);
  }

  @Test
  public void predProtoS2w_KeyPadMapping() {
    String signature = "6";
    HashSet<String> expected = new HashSet<>();
    expected.add("m");
    expected.add("n");
    expected.add("o");
    Set<String> actual = PredictivePrototype.signatureToWords(signature);
    assertEquals(expected, actual);
  }

  @Test
  public void predProtoS2w_Hello() {
    String signature = "43556";
    HashSet<String> expected = new HashSet<>();
    expected.add("gekko");
    expected.add("hello");
    Set<String> actual = PredictivePrototype.signatureToWords(signature);
    assertEquals(expected, actual);
  }

  @Test
  public void predProtoS2w_invalid() {
    String signature = "{}{}{";
    HashSet<String> expected = new HashSet<>();
    Set<String> actual = PredictivePrototype.signatureToWords(signature);
    assertEquals(expected, actual);
  }

  @Test
  public void isValidWord_Empty() {
    String word = "";
    boolean expected = false;
    boolean actual = PredictivePrototype.isValidWord(word);
    assertEquals(expected, actual);
  }

  @Test
  public void isValidWord_TwoArgsAsOne() {
    String word = "hello world";
    boolean expected = false;
    boolean actual = PredictivePrototype.isValidWord(word);
    assertEquals(expected, actual);
  }

  @Test
  public void isValidWord_Numeric() {
    String word = "4";
    boolean expected = false;
    boolean actual = PredictivePrototype.isValidWord(word);
    assertEquals(expected, actual);
  }

  @Test
  public void isValidWord_HelloCaps() {
    String word = "HEllo";
    boolean expected = true;
    boolean actual = PredictivePrototype.isValidWord(word);
    assertEquals(expected, actual);
  }

  // Command Line Programs

  @Test
  public void commandLineProgram_w2s_proto() {
    Words2SigProto.main(new String[]{"Hello", "World", "Computer", "Science"});
  }

  @Test
  public void commandLineProgram_s2w_proto() {
    Sigs2WordsProto.main(new String[]{"43556", "96753", "26678837", "7243623"});
  }

  @Test
  public void commandLineProgram_s2w_List() {
    ListDictionary listDictionary = new ListDictionary("src/Predictive/words.txt");
    Sigs2WordsList.main(new String[]{"43556", "96753", "26678837", "7243623"});
  }

  @Test
  public void commandLineProgram_s2w_Map() {
    MapDictionary mapDictionary = new MapDictionary("src/Predictive/words.txt");
    Sigs2WordsList.main(new String[]{"43556", "96753", "26678837", "7243623"});
  }

  @Test
  public void commandLineProgram_s2w_Tree() {
    TreeDictionary treeDictionary = new TreeDictionary("src/Predictive/words.txt");
    Sigs2WordsList.main(new String[]{"43556", "96753", "26678837", "7243623", "223"});
  }

  // Exercise 2

  @Test
  public void ListDicS2w_KeyPadMapping() {
    ListDictionary listDictionaryTest = new ListDictionary("src/Predictive/words.txt");
    HashSet<String> expected = new HashSet<>();
    expected.add("m");
    expected.add("n");
    expected.add("o");
    Set<String> actual = listDictionaryTest.signatureToWords("6");
    assertEquals(expected, actual);
  }

  @Test
  public void ListDicS2w_empty() {
    ListDictionary listDictionaryTest = new ListDictionary("src/Predictive/words.txt");
    HashSet<String> expected = new HashSet<>();
    Set<String> actual = listDictionaryTest.signatureToWords("");
    assertEquals(expected, actual);
  }

  @Test
  public void ListDicS2w_Hello() {
    ListDictionary listDictionaryTest = new ListDictionary("src/Predictive/words.txt");
    TreeSet<String> expected = new TreeSet<>();
    expected.add("gekko");
    expected.add("hello");
    Set<String> actual = listDictionaryTest.signatureToWords("43556");
    assertEquals(expected, actual);
  }

  // Exercise 3

  @Test
  public void MapDicS2w_KeyPadMapping() {
    MapDictionary mapDictionaryTest = new MapDictionary("src/Predictive/words.txt");
    HashSet<String> expected = new HashSet<>();
    expected.add("m");
    expected.add("n");
    expected.add("o");
    Set<String> actual = mapDictionaryTest.signatureToWords("6");
    assertEquals(expected, actual);
  }

  @Test
  public void MapDicS2w_empty() {
    MapDictionary mapDictionaryTest = new MapDictionary("src/Predictive/words.txt");
    HashSet<String> expected = null;
    Set<String> actual = mapDictionaryTest.signatureToWords("");
    assertEquals(expected, actual);
  }

  @Test
  public void MapDicS2w_Hello() {
    MapDictionary mapDictionaryTest = new MapDictionary("src/Predictive/words.txt");
    TreeSet<String> expected = new TreeSet<>();
    expected.add("gekko");
    expected.add("hello");
    Set<String> actual = mapDictionaryTest.signatureToWords("43556");
    assertEquals(expected, actual);
  }

  @Test
  public void MapDicS2w_invalid() {
    MapDictionary mapDictionaryTest = new MapDictionary("src/Predictive/words.txt");
    HashSet<String> expected = null;
    Set<String> actual = mapDictionaryTest.signatureToWords("{}{}{");
    assertEquals(expected, actual);
  }

  // Exercise 4

  @Test
  public void TreeDicS2w_KeyPadMapping() {
    TreeDictionary treeDictionaryTest = new TreeDictionary("src/Predictive/words.txt");
    HashSet<String> expected = new HashSet<>();
    expected.add("m");
    expected.add("n");
    expected.add("o");
    Set<String> actual = treeDictionaryTest.signatureToWords("6");
    assertEquals(expected, actual);
  }

  @Test
  public void TreeDicS2w_empty() {
    TreeDictionary treeDictionaryTest = new TreeDictionary("src/Predictive/words.txt");
    HashSet<String> expected = new HashSet<>();
    Set<String> actual = treeDictionaryTest.signatureToWords("");
    assertEquals(expected, actual);
  }

  @Test
  public void TreeDicS2w_Hello() {
    TreeDictionary treeDictionaryTest = new TreeDictionary("src/Predictive/words.txt");
    TreeSet<String> expected = new TreeSet<>();
    expected.add("gellm");
    expected.add("helln");
    expected.add("hellm");
    expected.add("gekko");
    expected.add("hello");
    Set<String> actual = treeDictionaryTest.signatureToWords("43556");
    assertEquals(expected, actual);
  }

}



