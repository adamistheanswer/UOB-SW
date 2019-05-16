import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * Tests for WS2 - EX1
 * @author Adam Robinson
 *
 */

public class FilmTest {

    private Film film1;
    @Before
    public void setUp() {
        film1 = new Film("Alien", 1979 , 95);
    }

    @Test
    public void test1() {

        film1.setLength(50000);

        assertEquals("Alien", film1.getTitle());
        assertEquals(1979, film1.getYear());
        assertEquals(50000, film1.getLength());
    }

    @Test
    public void test2() {

        film1.setLength(0);

        assertEquals("Alien", film1.getTitle());
        assertEquals(1979, film1.getYear());
        assertEquals(0, film1.getLength());
    }

    @Test
    public void test3() {

        film1.setLength(100);

        assertEquals("Alien", film1.getTitle());
        assertEquals(1979, film1.getYear());
        assertEquals(100, film1.getLength());
    }

    @Test
    public void test4() {

        film1.setLength(9999999);

        assertEquals("Alien", film1.getTitle());
        assertEquals(1979, film1.getYear());
        assertEquals(9999999, film1.getLength());
    }


    @Test
    public void test5() {

        film1.setLength(180);

        assertEquals("Alien", film1.getTitle());
        assertEquals(1979, film1.getYear());
        assertEquals(180, film1.getLength());
    }

    @Test
    public void test6() {

        film1.setLength(185);

        assertEquals("Alien", film1.getTitle());
        assertEquals(1979, film1.getYear());
        assertEquals(185, film1.getLength());
    }
}
