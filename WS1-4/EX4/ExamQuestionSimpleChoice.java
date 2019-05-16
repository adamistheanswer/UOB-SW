import java.util.ArrayList;

/**
 * ExamQuestionSimpleChoice extends ExamQuestion information in the form "questionText and
 * maximalMark" while also defining "possibleAnswers and correctAnswer". ExamQuestionSimpleChoice is
 * a class for testing user input of "value" against "correctAnswer" returning "maximalMark"
 *
 * @author Adam Robinson
 * @version 2017-11-12
 */

public class ExamQuestionSimpleChoice extends ExamQuestion {

  private int correctAnswer;
  private ArrayList<String> possibleAnswers;

  /**
   * This constructor creates examQuestionSimpleChoice information from four parts: questionText,
   * maximalMark, possibleAnswers and correctAnswer. Which are a string, an int, a string ArrayList
   * and an int respectively.
   *
   * @param questionText The question under consideration for the user
   * @param maximalMark The max mark that can be achieved answering the question
   * @param possibleAnswers Array containing possible answers
   * @param correctAnswer The position of the answer to the question in consideration within the
   * possibleAnswers array
   */

  public ExamQuestionSimpleChoice(String questionText, int maximalMark,
      ArrayList<String> possibleAnswers, int correctAnswer) {
    super(questionText, maximalMark);
    this.possibleAnswers = possibleAnswers;
    this.correctAnswer = correctAnswer;
  }

  /**
   * @param value users answer to the the question under consideration
   * @return mark achieved for answering question
   */

  public int mark(int value) {
    if (value == correctAnswer) {
      return getMaximalMark();
    } else {
      return 0;
    }

  }

  /**
   * @return The print format of the ExamQuestionSimpleChoice information "Question (Maximal mark:
   * [maximalMark]): [questionText] Possible answers are:  [possibleAnswers] Correct answer position
   * is: [correctAnswer]
   */


  @Override
  public String toString() {
    return super.toString() + "\nPossible answers are: " + possibleAnswers
        + "\nCorrect answer position is:" + correctAnswer;
  }
}
