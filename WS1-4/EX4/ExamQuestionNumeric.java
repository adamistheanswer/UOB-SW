/**
 * ExamQuestionNumeric extends ExamQuestion information in the form "questionText and maximalMark"
 * while also defining "answer". ExamQuestionNumeric is a class for testing user input of "value"
 * against "answer" returning "maximalMark"
 *
 * @author Adam Robinson
 * @version 2017-11-12
 */


public class ExamQuestionNumeric extends ExamQuestion {

  public int answer;

  /**
   * This constructor creates examQuestionNumeric information from three parts: questionText,
   * maximalMark and answer. Which are a string, an int and an int respectively.
   *
   * @param questionText The question under consideration for the user
   * @param maximalMark The max mark that can be achieved answering the question
   * @param answer The answer to the question in consideration
   */

  public ExamQuestionNumeric(String questionText, int maximalMark, int answer) {
    super(questionText, maximalMark);
    this.answer = answer;
  }

  /**
   * @param value users answer to the the question under consideration
   * @return mark achieved for answering question
   */

  public int mark(int value) {
    if (value == answer) {
      return getMaximalMark();
    } else {
      return 0;
    }
  }

  /**
   * @return The print format of the ExamQuestionNumeric information "Question (Maximal mark:
   * [maximalMark]): [questionText] Correct answer is: [answer]"
   */

  @Override
  public String toString() {
    return super.toString() + " Correct answer is: " + answer;
  }
}
