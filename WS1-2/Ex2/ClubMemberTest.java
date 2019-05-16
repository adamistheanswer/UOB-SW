import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * Tests for WS2 EX2
 * @author Adam Robinson
 *
 */

public class ClubMemberTest {

    private ClubMember member1;

    @Before
    public void setUp() {

        member1 = new ClubMember("Adam", "11 November 1991", "696911", "Platinum");
    }

    // getName Test

    @Test
    public void test1() {

        assertEquals("Adam", member1.getName());

    }

    // getRegistrationNumber Test

    @Test
    public void test2() {

        assertEquals("696911", member1.getRegistrationNumber());
    }

    // getMembershipType Test

    @Test
    public void test3() {

        assertEquals("Platinum", member1.getMembershipType());
    }

    // getDateOfBirth Test

    @Test
    public void test4() {

        assertEquals("11 November 1991", member1.getDateOfBirth());
    }

    // toString Test

    @Test
    public void test5() {

        String expected = "[Adam, 11 November 1991, ID: 696911, Platinum]";
        assertEquals(expected, member1.toString());
    }

    // New inputs toString Test

    @Test
    public void test6() {

        member1 = new ClubMember("Sue", "18 November 1998", "888888", "Silver");

        String expected = "[Sue, 18 November 1998, ID: 888888, Silver]";
        assertEquals(expected, member1.toString());
    }

}

