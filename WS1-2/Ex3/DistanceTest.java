import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * Tests for WS2 EX3
 * @author Adam Robinson
 *
 */

public class DistanceTest {

    private Distance distance1, distance2;
    private final static double ACCURACY = 0.000001;

    @Before
    public void setUp() {
        distance1 = new Distance(100);
        distance2 = new Distance(66.6);
    }

    @Test
    public void test1() {
        double expected = 100;
        assertEquals(expected, distance1.getKilometres(), ACCURACY);
    }

    @Test
    public void test2() {
        double expected = 62.137273664980675;
        assertEquals(expected, distance1.getMiles(), ACCURACY);
    }

    @Test
    public void test3() {

        double expected = 100000;
        assertEquals(expected, distance1.getMetres(), ACCURACY);
    }

    @Test
    public void test4() {

        double expected = 109361.60165036599;
        assertEquals(expected, distance1.getYards(),  ACCURACY);
    }

    @Test
    public void test5() {

        double expected = 66600;
        assertEquals(expected, distance2.getMetres(), ACCURACY);
    }

    @Test
    public void test6() {

        double expected = 72834.82669914374;
        assertEquals(expected, distance2.getYards(),  ACCURACY);
    }

}
