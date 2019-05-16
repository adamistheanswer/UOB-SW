import java.util.function.Function;

/**
 * Statistics is a class for calculating mean and standard deviation of elements within a double
 * array with functions applied to them
 *
 * @author Adam Robinson
 * @version 2017-11-08
 */

public class Statistics {

  /**
   * @param f function to be applied to the array
   * @param argumentValues double array containing values to have function applied to
   * @return mean of double array elements with function applied
   */

  public static double mean(Function<Double, Double> f, double[] argumentValues) {
    double sum = 0;
    for (int i = 0; i < argumentValues.length; i++) {
      sum += f.apply(argumentValues[i]);
    }
    return sum / argumentValues.length;
  }

  /**
   * @param f function to be applied to the array
   * @param argumentValues double array containing values to have function applied to
   * @return standard deviation of double array elements with function applied
   */

  public static double standardDeviation(Function<Double, Double> f, double[] argumentValues) {
    double sum = 0;
    double mean = mean(f, argumentValues);
    for (int i = 0; i < argumentValues.length; i++) {
      sum += Math.pow((f.apply(argumentValues[i]) - mean), 2);
    }
    return Math.sqrt(sum / argumentValues.length);
  }

}
