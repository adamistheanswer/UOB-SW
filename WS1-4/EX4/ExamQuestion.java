/**
 * ExamQuestion is a class for the representation of Exam Question information in the form
 * "questionText and maximalMark"
 *
 * @author Adam Robinson
 * @version 2017-11-12
 */


public class ExamQuestion {

  private String questionText;
  private int maximalMark;

  /**
   * This constructor creates examQuestion information from two parts: questionText and maximalMark.
   * Which are a string and an int respectively.
   *
   * @param questionText The question under consideration for the user
   * @param maximalMark The max mark that can be achieved answering the question
   */

  public ExamQuestion(String questionText, int maximalMark) {
    this.questionText = questionText;
    this.maximalMark = maximalMark;
  }


  /**
   * @return The question under consideration for the user
   */

  public String getQuestionText() {
    return questionText;
  }

  /**
   * @return The max mark that can be achieved answering the question
   */

  public int getMaximalMark() {
    return maximalMark;
  }

  /**
   * @param questionText A question for the user to answer
   */

  public void setQuestionText(String questionText) {
    this.questionText = questionText;
  }

  /**
   * @param maximalMark The max mark that can be achieved answering the question
   */

  public void setMaximalMark(int maximalMark) {
    this.maximalMark = maximalMark;
  }

  /**
   * @return The print format of the ExamQuestion information "Question (Maximal mark:
   * [maximalMark]): [questionText]"
   */


  @Override
  public String toString() {
    return "Question (Maximal mark: " + maximalMark + "): " + questionText;
  }
}
