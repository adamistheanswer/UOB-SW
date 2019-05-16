import static junit.framework.TestCase.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.Test;

/**
 * JUnit tests for Worksheet 2-4
 *
 * @author Adam Robinson
 */

public class Worksheet4Tests {

  @Test
  public void removeChar1() throws IOException {
    DictionaryModel Dict = new DictionaryModel();
    Dict.setDisplay("hello");
    Dict.removeLastCharacter();
    String expected = "hell";
    String actual = Dict.getDisplay();
    assertEquals(expected, actual);
  }

  @Test
  public void removeChar2() throws IOException {
    DictionaryModel Dict = new DictionaryModel();
    Dict.setDisplay("h");
    Dict.removeLastCharacter();
    String expected = "";
    String actual = Dict.getDisplay();
    assertEquals(expected, actual);
  }

  @Test
  public void removeChar3() throws IOException {
    DictionaryModel Dict = new DictionaryModel();
    Dict.setDisplay("hello ");
    Dict.removeLastCharacter();
    String expected = "hello";
    String actual = Dict.getDisplay();
    assertEquals(expected, actual);
  }

  @Test
  public void addChar1() throws IOException {
    DictionaryModel Dict = new DictionaryModel();
    Dict.setSignature("7846");
    Dict.addCharacter('2');
    String expected = "78462";
    String actual = Dict.getSignature();
    assertEquals(expected, actual);
  }

  @Test
  public void addChar2() throws IOException {
    DictionaryModel Dict = new DictionaryModel();
    Dict.setSignature("");
    Dict.addCharacter('2');
    String expected = "2";
    String actual = Dict.getSignature();
    assertEquals(expected, actual);
  }

  @Test
  public void addChar3() throws IOException {
    DictionaryModel Dict = new DictionaryModel();
    Dict.setSignature("4355");
    Dict.addCharacter('6');
    String expected = String.valueOf(Dict.getPosWords());
    String actual = "[gekko, gellm, hellm, helln, hello]";
    assertEquals(expected, actual);
  }

  @Test
  public void getMessage1() throws IOException {
    DictionaryModel Dict = new DictionaryModel();
    Dict.setDisplay("hello world");
    Dict.getMessage();
    String expected = "hello, world";
    String actual = "hello, world";
    assertEquals(expected, actual);
  }

  @Test
  public void getMessage2() throws IOException {
    DictionaryModel Dict = new DictionaryModel();
    Dict.setDisplay("hello");
    Dict.getMessage();
    String expected = "hello";
    String actual = "hello";
    assertEquals(expected, actual);
  }

  @Test
  public void getMessage3() throws IOException {
    DictionaryModel Dict = new DictionaryModel();
    Dict.setDisplay("");
    Dict.getMessage();
    String expected = "";
    String actual = "";
    assertEquals(expected, actual);
  }

  @Test
  public void nextMatch1() throws IOException {
    DictionaryModel Dict = new DictionaryModel();
    ArrayList<String> posWords = new ArrayList<>();
    posWords.add("hello");
    posWords.add("world");
    posWords.add("computer");
    posWords.add("science");
    posWords.add("rules");
    Dict.setPosWords(posWords);
    Dict.nextMatch();
    String expected = "hello";
    String actual = Dict.getWord();
    assertEquals(expected, actual);
  }

  @Test
  public void nextMatch2() throws IOException {
    DictionaryModel Dict = new DictionaryModel();
    ArrayList<String> posWords = new ArrayList<>();
    posWords.add("hello");
    posWords.add("world");
    posWords.add("computer");
    posWords.add("science");
    posWords.add("rules");
    Dict.setPosWords(posWords);
    Dict.nextMatch();
    Dict.nextMatch();
    String expected = "world";
    String actual = Dict.getWord();
    assertEquals(expected, actual);
  }

  @Test
  public void nextMatch3() throws IOException {
    DictionaryModel Dict = new DictionaryModel();
    ArrayList<String> posWords = new ArrayList<>();
    posWords.add("hello");
    posWords.add("world");
    posWords.add("computer");
    posWords.add("science");
    posWords.add("rules");
    Dict.setPosWords(posWords);
    Dict.nextMatch();
    Dict.nextMatch();
    Dict.nextMatch();
    Dict.nextMatch();
    Dict.nextMatch();
    Dict.nextMatch();
    String expected = "hello";
    String actual = Dict.getWord();
    assertEquals(expected, actual);
  }

  @Test
  public void acceptWord1() throws IOException {
    DictionaryModel Dict = new DictionaryModel();
    Dict.setDisplay("hello");
    Dict.setWord("world");
    Dict.acceptWord();
    String expected = "hello world";
    String actual = Dict.getDisplay();
    assertEquals(expected, actual);
  }

  @Test
  public void acceptWord2() throws IOException {
    DictionaryModel Dict = new DictionaryModel();
    Dict.setDisplay("hello");
    Dict.setWord("");
    Dict.acceptWord();
    String expected = "hello ";
    String actual = Dict.getDisplay();
    assertEquals(expected, actual);
  }

  @Test
  public void acceptWord3() throws IOException {
    DictionaryModel Dict = new DictionaryModel();
    Dict.setDisplay("hello world");
    Dict.setWord("yo");
    Dict.acceptWord();
    String expected = "hello world yo";
    String actual = Dict.getDisplay();
    assertEquals(expected, actual);
  }

}