import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Adam Robinson
 */
public class ExamQuestionTest {

  private ExamQuestion q1;
  private ExamQuestionNumeric nQ1;
  private ExamQuestionSimpleChoice sCQ1;
  private ExamQuestionMultipleChoice mCQ1;

  @Before
  public void setup() {
    q1 = new ExamQuestion("What is 5 times 3?", 10);

    nQ1 = new ExamQuestionNumeric("What is 10 times 10?", 100, 100);

    ArrayList<String> simpleChoiceAnswers1 = new ArrayList<String>(
        Arrays.asList("4", "5", "10", "20"));
    sCQ1 = new ExamQuestionSimpleChoice("What is 3 plus 2?", 10,
        simpleChoiceAnswers1, 2);

    ArrayList<String> possibleAnswers1 = new ArrayList<>(Arrays.asList("-2", "-4", "-1", "2"));
    ArrayList<Integer> correctAnswers1 = new ArrayList<>(Arrays.asList(1, 4));
    mCQ1 = new ExamQuestionMultipleChoice("x * x = 4", 10, possibleAnswers1,
        correctAnswers1);

  }

  //Exam Question toString Test
  @Test
  public void test1() {

    q1 = new ExamQuestion("What is 5 times 3?", 10);

    String expected = "Question (Maximal mark: 10): What is 5 times 3?";
    String actual = q1.toString();

    assertEquals(expected, actual);

  }


  //Exam numericQuestion toString Test
  @Test
  public void test2() {

    nQ1 = new ExamQuestionNumeric("What is 5 times 3?", 10, 15);

    String expected = "Question (Maximal mark: 10): What is 5 times 3? Correct answer is: 15";
    String actual = nQ1.toString();

    assertEquals(expected, actual);

  }


  //Exam simpleChoiceQuestion toString Test
  @Test
  public void test3() {

    ArrayList<String> simpleChoiceAnswers1 = new ArrayList<String>(
        Arrays.asList("4", "5", "10", "20"));
    sCQ1 = new ExamQuestionSimpleChoice("What is 3 plus 2?", 10,
        simpleChoiceAnswers1, 2);

    String expected = "Question (Maximal mark: 10): What is 3 plus 2?\n"
        + "Possible answers are: [4, 5, 10, 20]\n"
        + "Correct answer position is:2";
    String actual = sCQ1.toString();

    assertEquals(expected, actual);

  }

  //Exam multipleChoiceQuestion toString Test
  @Test
  public void test4() {

    ArrayList<String> possibleAnswers1 = new ArrayList<>(Arrays.asList("-2", "0", "1", "2"));
    ArrayList<Integer> correctAnswers1 = new ArrayList<>(Arrays.asList(1, 4));
    mCQ1 = new ExamQuestionMultipleChoice("x * x = 4", 10, possibleAnswers1,
        correctAnswers1);

    String expected = "Question (Maximal mark: 10): x * x = 4\n"
        + "The possible answers to the question are: [-2, 0, 1, 2]\n"
        + "The correct values are: [1, 4]";

    String actual = mCQ1.toString();

    assertEquals(expected, actual);
  }


  //Max and Min multipleChoiceQuestion mark test
  @Test
  public void test5() {

    ArrayList<Integer> givenAnswers = new ArrayList<>(
        Arrays.asList(Integer.MAX_VALUE, Integer.MIN_VALUE));

    int expected = 0;
    int actual = mCQ1.mark(givenAnswers);

    assertEquals(expected, actual);
  }

  // Max and Min simpleChoiceQuestion mark test
  @Test
  public void test6() {

    int expected1 = 0;
    int actual1 = sCQ1.mark(Integer.MAX_VALUE);

    assertEquals(expected1, actual1);

    int expected2 = 0;
    int actual2 = sCQ1.mark(Integer.MIN_VALUE);

    assertEquals(expected2, actual2);
  }


}
