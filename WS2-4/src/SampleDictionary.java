import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SampleDictionary {
  private Set<String> words = new TreeSet();
  private SampleDictionary[] children = new SampleDictionary[8];

  public SampleDictionary(String dict) throws IOException {
    Scanner fileScan = new Scanner(new File(dict));

    while(fileScan.hasNext()) {
      String word = fileScan.nextLine().toLowerCase();
      if (isValidWord(word)) {
        this.insert(wordToSignature(word), word);
      }
    }

    fileScan.close();
  }

  public SampleDictionary[] getChildren() {
    return this.children;
  }

  public void setChildren(SampleDictionary[] children) {
    this.children = children;
  }

  private SampleDictionary() {
  }

  private void insert(String signature, String word) {
    if (signature.length() > 0) {
      this.insertHelper(0, signature, word);
    }

  }

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

  private void insertHelper(int n, String signature, String word) {
    if (n == signature.length()) {
      this.words.add(word);
    } else {
      char ch = signature.charAt(n);
      if (ch >= '2' && ch <= '9') {
        int num = Character.digit(ch, 10);
        int index = num - 2;
        if (this.children[index] == null) {
          this.children[index] = new SampleDictionary();
        }

        this.words.add(word);
        this.children[index].insertHelper(n + 1, signature, word);
      }
    }

  }

  public Set<String> signatureToWords(String signature) {
    Set<String> result = this.find(signature);
    Set<String> resultCopy = new TreeSet();
    Iterator var5 = result.iterator();

    while(var5.hasNext()) {
      String word = (String)var5.next();
      resultCopy.add(word.substring(0, signature.length()));
    }

    return resultCopy;
  }

  private Set<String> find(String signature) {
    return this.findHelper(0, signature);
  }

  private Set<String> findHelper(int n, String signature) {
    if (n == signature.length()) {
      return new TreeSet(this.words);
    } else {
      char ch = signature.charAt(n);
      if (ch >= '2' && ch <= '9') {
        int num = Character.digit(ch, 10);
        int index = num - 2;
        return (Set)(this.children[index] == null ? new TreeSet() : this.children[index].findHelper(n + 1, signature));
      } else {
        return new TreeSet();
      }
    }
  }
}
