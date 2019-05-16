import static org.junit.Assert.assertEquals;

import java.util.function.Function;
import org.junit.Test;

/**
 * @author Adam Robinson
 */

public class StatisticsTest {

  private final static double ACCURACY = 1e-6;

  // Zero array
  @Test
  public void test1() {

    Function<Double, Double> f1 = x -> x * x;
    double[] a = {0, 0, 0};

    double expectedMean = 0;
    double actualMean = Statistics.mean(f1, a);
    assertEquals(expectedMean, actualMean, ACCURACY);

    double expectedStd = 0;
    double actualStd = Statistics.standardDeviation(f1, a);
    assertEquals(expectedStd, actualStd, ACCURACY);

  }

  // Pi Test
  @Test
  public void test2() {

    Function<Double, Double> f1 = x -> Math.PI;
    double[] a = {1, 1, 1};

    double expectedMean = 3.141592653589793;
    double actualMean = Statistics.mean(f1, a);
    assertEquals(expectedMean, actualMean, ACCURACY);

    double expectedStd = 0;
    double actualStd = Statistics.standardDeviation(f1, a);
    assertEquals(expectedStd, actualStd, ACCURACY);

  }

  // Math Signum
  @Test
  public void test3() {

    Function<Double, Double> f1 = x -> Math.signum(x);
    double[] a = {4, 2, -16, 3, 5, -2, 1};

    double expectedMean = 0.42857142857142855;
    double actualMean = Statistics.mean(f1, a);
    assertEquals(expectedMean, actualMean, ACCURACY);

    double expectedStd = 0.9035079029052513;
    double actualStd = Statistics.standardDeviation(f1, a);
    assertEquals(expectedStd, actualStd, ACCURACY);

  }

  // public test
  @Test
  public void test4() {

    Function<Double, Double> f1 = x -> Math.cos(Math.PI * x);
    double[] a = {-4, 2, -16, Double.MIN_VALUE, -3, 12, 5, -25, 32, 1};

    double expectedMean = 0.2;
    double actualMean = Statistics.mean(f1, a);
    assertEquals(expectedMean, actualMean, ACCURACY);

    double expectedStd = 0.9797958971132712;
    double actualStd = Statistics.standardDeviation(f1, a);
    assertEquals(expectedStd, actualStd, ACCURACY);

  }

  // public test
  @Test
  public void test5() {

    Function<Double, Double> f1 = x -> Math.cos(x);
    double[] a = {Double.MAX_VALUE, Double.MIN_VALUE};

    double expectedMean = 6.155286720044284E-6;
    double actualMean = Statistics.mean(f1, a);
    assertEquals(expectedMean, actualMean, ACCURACY);

    double expectedStd = 0.9999938447132799;
    double actualStd = Statistics.standardDeviation(f1, a);
    assertEquals(expectedStd, actualStd, ACCURACY);
  }

  // public test
  @Test
  public void test6() {

    Function<Double, Double> f1 = x -> Math.PI * (Math.sin(x));
    double[] a = {666, 69696969};

    double expectedMean = 1.149728334349857;
    double actualMean = Statistics.mean(f1, a);
    assertEquals(expectedMean, actualMean, ACCURACY);

    double expectedStd = 1.2051511992340596;
    double actualStd = Statistics.standardDeviation(f1, a);
    assertEquals(expectedStd, actualStd, ACCURACY);
  }

}
