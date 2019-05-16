import java.util.ArrayList;

/**
 * ExamQuestionMultipleChoice extends ExamQuestion information in the form "questionText and
 * maximalMark" while also defining "possibleAnswers and correctAnswers". ExamQuestionMultipleChoice
 * is a class for testing user input of "value" against "correctAnswers" returning "maximalMark"
 *
 * @author Adam Robinson
 * @version 2017-11-12
 */

public class ExamQuestionMultipleChoice extends ExamQuestion {

  private ArrayList<Integer> correctAnswers;
  private ArrayList<String> possibleAnswers;

  /**
   * This constructor creates examQuestionMultipleChoice information from four parts: questionText,
   * maximalMark, possibleAnswers and correctAnswers. Which are a string, an int, a string ArrayList
   * and an Integer ArrayList respectively.
   *
   * @param questionText The question under consideration for the user
   * @param maximalMark The max mark that can be achieved answering the question
   * @param possibleAnswers ArrayList containing possible answers
   * @param correctAnswers ArrayList containing correct answers
   */

  public ExamQuestionMultipleChoice(String questionText, int maximalMark,
      ArrayList<String> possibleAnswers,
      ArrayList<Integer> correctAnswers) {
    super(questionText, maximalMark);
    this.correctAnswers = correctAnswers;
    this.possibleAnswers = possibleAnswers;
  }

  // Array list to store single instance of correct answers to account for duplicates
  ArrayList<Integer> answers = new ArrayList<>();
  int incorrect = 0;

  /**
   * @param answersProvided users answers to the the question for consideration
   * @return maximal mark achieved for question adjusted against incorrect answers
   */

  public int mark(ArrayList<Integer> answersProvided) {

    // Determines correct answers input by users while accounting for duplicates
    for (int i = 0; i < answersProvided.size(); i++) {
      int j = answersProvided.get(i);
      if (correctAnswers.contains(j) && !answers.contains(j)) {
        answers.add(j);
      } else if (!correctAnswers.contains(j)) {
        incorrect++;
      }
    }

    // Calculates maximal mark
    double answerWeight = (double) getMaximalMark() / correctAnswers.size();
    double sum = (answerWeight * (answers.size() - incorrect));

    if (sum < 0) {
      return 0;
    }
    return (int) Math.round(sum);

  }

  /**
   * @return The print format of the ExamQuestionSimpleChoice information "Question (Maximal mark:
   * [maximalMark]): [questionText] The possible answers to the question are: [possibleAnswers] The
   * correct values are: [correctAnswers]
   */

  @Override
  public String toString() {
    return super.toString() + "\nThe possible answers to the question are: " + possibleAnswers
        + "\nThe correct values are: " + correctAnswers;
  }
}
