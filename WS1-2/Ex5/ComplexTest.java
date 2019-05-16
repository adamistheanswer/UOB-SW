import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * Tests for WS2 EX5
 * @author Adam Robinson
 *
 */

public class ComplexTest {

    private Complex complex1,complex2,complex3,complex4,complex5;
    private final static double ACCURACY = 0.000001;

    @Before
    public void setUp() {
        complex1 = new Complex(100,100);
        complex2 = new Complex(6,9);
        complex3 = new Complex(0,0);
        complex4 = new Complex(0,1);
        complex5 = new Complex(2,4);
    }

    @Test
    public void test1() {

        Complex complex6 = complex1.add(complex2);

        assertEquals(106.0, complex6.getRealPart(), ACCURACY);
        assertEquals(109.0, complex6.getImaginaryPart(), ACCURACY);

        assertEquals(100.0, complex1.getRealPart(),ACCURACY);
        assertEquals(100.0, complex1.getImaginaryPart(),ACCURACY);

        assertEquals(6.0, complex2.getRealPart(),ACCURACY);
        assertEquals(9.0, complex2.getImaginaryPart(),ACCURACY);

        String expected = "106.0 + 109.0i";
        assertEquals(expected, complex6.toString());

    }


    @Test
    public void test2() {

        Complex complex6 = complex1.multiply(complex2);

        assertEquals(-300.0, complex6.getRealPart(), ACCURACY);
        assertEquals(1500.0, complex6.getImaginaryPart(), ACCURACY);

        assertEquals(100.0, complex1.getRealPart(),ACCURACY);
        assertEquals(100.0, complex1.getImaginaryPart(),ACCURACY);

        assertEquals(6.0, complex2.getRealPart(),ACCURACY);
        assertEquals(9.0, complex2.getImaginaryPart(),ACCURACY);

        String expected = "-300.0 + 1500.0i";
        assertEquals(expected, complex6.toString());

    }



    @Test
    public void test3(){

        Complex complex6 = complex3.add(complex4);

        assertEquals(0.0, complex6.getRealPart(), ACCURACY);
        assertEquals(1.0, complex6.getImaginaryPart(), ACCURACY);

        assertEquals(0.0, complex3.getRealPart(),ACCURACY);
        assertEquals(0.0, complex3.getImaginaryPart(),ACCURACY);

        assertEquals(0.0, complex4.getRealPart(),ACCURACY);
        assertEquals(1.0, complex4.getImaginaryPart(),ACCURACY);

        String expected = "0.0 + 1.0i";
        assertEquals(expected, complex6.toString());

    }


    @Test
    public void test4() {

        Complex complex6 = complex3.multiply(complex4);

        assertEquals(0.0, complex6.getRealPart(), ACCURACY);
        assertEquals(0.0, complex6.getImaginaryPart(), ACCURACY);

        assertEquals(0.0, complex3.getRealPart(),ACCURACY);
        assertEquals(0.0, complex3.getImaginaryPart(),ACCURACY);

        assertEquals(0.0, complex4.getRealPart(),ACCURACY);
        assertEquals(1.0, complex4.getImaginaryPart(),ACCURACY);

        String expected = "0.0 + 0.0i";
        assertEquals(expected, complex6.toString());

    }



    @Test
    public void test5() {


        Complex complex6 = complex2.add(complex5);

        assertEquals(8.0, complex6.getRealPart(), ACCURACY);
        assertEquals(13.0, complex6.getImaginaryPart(), ACCURACY);

        assertEquals(6.0, complex2.getRealPart(),ACCURACY);
        assertEquals(9.0, complex2.getImaginaryPart(),ACCURACY);

        assertEquals(2.0, complex5.getRealPart(),ACCURACY);
        assertEquals(4.0, complex5.getImaginaryPart(),ACCURACY);

        String expected = "8.0 + 13.0i";
        assertEquals(expected, complex6.toString());

    }

    @Test
    public void test6() {


        Complex complex6 = complex2.multiply(complex5);

        assertEquals(-24.0, complex6.getRealPart(), ACCURACY);
        assertEquals(42, complex6.getImaginaryPart(), ACCURACY);

        assertEquals(6.0, complex2.getRealPart(),ACCURACY);
        assertEquals(9.0, complex2.getImaginaryPart(),ACCURACY);

        assertEquals(2.0, complex5.getRealPart(),ACCURACY);
        assertEquals(4.0, complex5.getImaginaryPart(),ACCURACY);

        String expected = "-24.0 + 42.0i";
        assertEquals(expected, complex6.toString());

    }


}
