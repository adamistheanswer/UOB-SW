import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;

public class DictionaryModel extends Observable implements DictionaryModelInterface {

  private SampleDictionary dictionary;
  private String display, signature, word;
  private int index;
  private ArrayList<String> posWords;

  /*
   * Constructor to take a sting path to dictionary .txt file
   */

  public DictionaryModel(String path) throws IOException {
    dictionary = new SampleDictionary(path);
    //Initialise
    reset();
    display = "";
  }

  /*
   * Constructor with hard coded path to dictionary .txt file
   */

  public DictionaryModel() throws IOException {
    dictionary = new SampleDictionary("src/words.txt");
    //Initialise
    reset();
    display = "";
  }

  /*
   * Method splits on screen message into individual items of a list while adding most recent word
   */

  @Override
  public List<String> getMessage() {

    List<String> displayList = new ArrayList<>();
    String splitString = display;
    String[] onScreen = splitString.split("\\s+");
    displayList.addAll(Arrays.asList(onScreen));
    displayList.add(word);

    return displayList;
  }

  /*
   * This method concatenates new key press to signature.
   * Then generates an array list of all of the possible words of new signature
   * Word is set to index of the new possible words array list.
   */

  @Override
  public void addCharacter(char key) {

    signature += key;
    posWords = new ArrayList<>();
    posWords.addAll(dictionary.signatureToWords(signature));
    word = posWords.get(index);

    setChanged();
    notifyObservers();
  }


  /*
   * This method removes the last character from the word and signature and then regenerates the
   * possible words array from the new signature. This method also displays that change though
   * removing the last character from the display. If there is noting to be removed the GUI resets.
   */

  @Override
  public void removeLastCharacter() {

    if (!word.isEmpty()) {
      word = word.substring(0, word.length() - 1);
      signature = signature.substring(0, signature.length() - 1);

      posWords = new ArrayList<>();
      posWords.addAll(dictionary.signatureToWords(signature));

    } else if (!display.isEmpty() && (word.trim().length() == 0)) {
      display = display.substring(0, display.length() - 1);

    } else {
      reset();
      display = "";
    }

    setChanged();
    notifyObservers();
  }

  /*
   * This method cycles through the possible words array through incrementing the index.
   * When bounds of array reached index set to zero to restart loop.
   */

  @Override
  public void nextMatch() {

    if (index < posWords.size()) {
      word = posWords.get(index++);
    } else {
      index = 0;
      word = posWords.get(index);
    }

    setChanged();
    notifyObservers();
  }

  /*
   * method concatenates word with display message, including space.
   */

  @Override
  public void acceptWord() {

    display += " " + word;
    reset();

    setChanged();
    notifyObservers();
  }

  /*
   * Helper method to clear word, signature, possible words array and index.
   * Used to initialise field variables in constructors.
   */

  private void reset() {
    word = "";
    signature = "";
    posWords = new ArrayList<>();
    index = 0;
  }

  // SETTERS & GETTERS FOR TESTING

  public void setDisplay(String display) {
    this.display = display;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public String getDisplay() {
    return display;
  }

  public String getSignature() {
    return signature;
  }

  public String getWord() {
    return word;
  }

  public ArrayList<String> getPosWords() {
    return posWords;
  }

  public void setPosWords(ArrayList<String> posWords) {
    this.posWords = posWords;
  }
}