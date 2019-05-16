import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author David Mcdonald and Alexandros Evangelidis
 */

public class Ws3PublicTestsEx2 {
    @Rule public final ExpectedException exception = ExpectedException.none();
	
    //public test
    @Test
    public void test1() {
		
        double rating = 4.0;
		
        String expected = "OK";
        String actual = StarRating.interpret(rating);
		
        assertEquals(expected, actual);
    }
	 
    //public test
    @Test
    public void test2() {
		
        double rating = 5.0;
		
        String expected = "[HAS ONLY ONE REVIEW]";
        String actual = StarRating.interpret(rating);
		
        assertEquals(expected, actual);
    }
	
    //public test
    @Test
    public void test3() {
		
        double rating = 1.5;
		
        String expected = "CRAP";
        String actual = StarRating.interpret(rating);
		
        assertEquals(expected, actual);
    }
	
    //public test
    @Test
    public void test4() {
		
        double rating = 4.5;
		
        String expected = "EXCELLENT";
        String actual = StarRating.interpret(rating);
		
        assertEquals(expected, actual);
    }
	
    //public test
    @Test
    public void test5() {
		
        double rating = 2.5;
		
        String expected = "CRAP";
        String actual = StarRating.interpret(rating);
		
        assertEquals(expected, actual);
    }

    //public test
    @Test
    public void test6() {
		
        double rating = 100;
		
        exception.expect(IllegalArgumentException.class);
        StarRating.interpret(rating);
    }
	
    //public test
    @Test
    public void test7() {
		
        double rating = 3.0;
		
        String expected = "CRAP";
        String actual = StarRating.interpret(rating);
		
        assertEquals(expected, actual);
    }
	
    //public test
    @Test
    public void test8() {
		
        double rating = -5.5;
		
        exception.expect(IllegalArgumentException.class);
        StarRating.interpret(rating);
			
    }
}
