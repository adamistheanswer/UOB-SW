import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * Tests for WS2 EX4
 * @author Adam Robinson
 *
 */

public class EmployeeTest {

    private Employee employee1;
    private final static double ACCURACY = 0.000001;


    @Before
    public void setUp() {
        employee1 = new Employee("Adam", 35, 50);
    }

    // Zero Test

    @Test
    public void test1() {

        employee1.setHourlySalary(0);
        employee1.setNumberOfHours(0);

        employee1.increaseSalary(0);
        employee1.increaseSalary(0);
        assertEquals(0.0, employee1.monthlySalary(0), ACCURACY);

        String expected = "Adam has an hourly salary of 0.0 \u00a3 and has worked last month for 0 hours.";

        assertEquals(expected, employee1.toString());

    }

    // Setters & Getters Test

    @Test
    public void test2() {

        employee1.setName("Adam");
        employee1.setHourlySalary(100.95);
        employee1.setNumberOfHours(50);

        assertEquals("Adam", employee1.getName());
        assertEquals(100.95, employee1.getHourlySalary(), ACCURACY);
        assertEquals(50, employee1.getNumberOfHours());
    }

    // toString Test

    @Test
    public void test3() {

        employee1.setHourlySalary(100.95);
        employee1.setNumberOfHours(50);

        String expected = "Adam has an hourly salary of 100.95 \u00a3 and has worked last month for 50 hours.";
        assertEquals(expected, employee1.toString());
    }

    // Monthly Salary calculation test

    @Test
    public void test4() {

        employee1.setHourlySalary(75.75);
        employee1.setNumberOfHours(50);

        assertEquals(3408.75, employee1.monthlySalary(10), ACCURACY);

    }

    // Monthly salary with percentage increase tests

    @Test
    public void test5() {

        employee1.setHourlySalary(75.75);
        employee1.setNumberOfHours(50);

        employee1.increaseSalary(10.5);

        assertEquals(83.70375, employee1.getHourlySalary(), ACCURACY);
        assertEquals(3348.15, employee1.monthlySalary(20), ACCURACY);
    }

    @Test
    public void test6() {

        employee1.setHourlySalary(20.75);
        employee1.setNumberOfHours(20);

        employee1.increaseSalary(15.5);

        assertEquals(23.96625, employee1.getHourlySalary(), ACCURACY);
        assertEquals(383.46, employee1.monthlySalary(20), ACCURACY);
    }

}
